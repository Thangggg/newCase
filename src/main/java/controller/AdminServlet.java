package controller;

import service.CategoryService;
import service.PositionsService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    PositionsService positionsService = new PositionsService();
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();
    RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if (act == null){
            act = "";
        }
        switch (act){
            case "delete":
                deleteProduct(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        try {
            resp.sendRedirect("/admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("positionList",positionsService.findAllPositionByProduct(productService.fillAll()));
        req.setAttribute("categoryList",categoryService.findAllCategoryByProduct(productService.fillAll()));
        req.setAttribute("productList",productService.fillAll());
        requestDispatcher = req.getRequestDispatcher("/admin.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
