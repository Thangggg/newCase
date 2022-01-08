package controller;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();
    RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "logout" : {
                HttpSession session = req.getSession();
                session.removeAttribute("user");
                resp.sendRedirect("/");
                break;
            }
            case "login" : {
                showLogin(req,resp);
                break;
            }
        }
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestDispatcher =req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "login" : {
                login(req,resp);
                break;
            }
            case "singup": {
                singUp(req,resp);
            }
        }
    }
    private void singUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        User user = new User(username,password,phone,address,email);
        if (!userService.saveUser(user)){
            req.setAttribute("messSingUp","Account or email already exists");
            showLogin(req,resp);
        }else {
            req.setAttribute("messSingOk","Account successfully created");
            showLogin(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("pass");
        User user = userService.checkLogin(userName,password);
        if (user==null){
            req.setAttribute("mess","Wrong user or pass");
            showLogin(req,resp);
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/");
        }
    }

}
