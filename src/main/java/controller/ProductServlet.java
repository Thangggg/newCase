package controller;

import model.*;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    PositionsService positionsService = new PositionsService();
    OrderService orderService = new OrderService();
    CartService cartService = new CartService();
    OrderDetailService orderDetailService = new OrderDetailService();
    RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if (act == null){
            act = "";
        }
        switch (act){
            case "showListByCategory":
                showListByCategory(req,resp);
                break;
            case "showListByPosition":
                showListByPosition(req,resp);
                break;
            case "detail":
                showDetail(req,resp);
                break;
            case "addToCart":
                addToCart(req,resp);
                break;
            case "showCart":
                showCart(req,resp);
                break;
            case "plusDayNumber":
                plusDayNumber(req,resp);
                break;
            case "minusDayNumber":
                minusDayNumber(req,resp);
                break;
            case "checkout":
                checkOut(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void checkOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Order order = new Order(user.getId(), cartService.sumCart());
        orderService.create(order);
        orderDetailService.saveOrderDetail();

        resp.sendRedirect("/");


    }

    private void minusDayNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = cartService.getCart().get(cartService.findById(id));
        product.setDayNumber(product.getDayNumber() - 1);
        product.setTotalPrice(product.getTotalPrice() - product.getPrice());
        showCart(req,resp);
    }

    private void plusDayNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = cartService.getCart().get(cartService.findById(id));
        product.setDayNumber(product.getDayNumber() + 1);
        product.setTotalPrice(product.getTotalPrice() + product.getPrice());
        showCart(req,resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sum",cartService.sumCart());
        req.setAttribute("listCart",cartService.getCart());

        requestDispatcher = req.getRequestDispatcher("/cart.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        int index = cartService.findById(id);
        if (index >= 0){
            Product productCart = cartService.getCart().get(index);
            productCart.setDayNumber(productCart.getDayNumber() + 1);
            productCart.setTotalPrice(productCart.getTotalPrice() + productCart.getPrice());
        }else {
            cartService.saveCart(new Product(product.getId(),product.getNameProduct(),product.getPrice(),product.getImg(),product.getPrice(),1));
        }

        resp.sendRedirect("/");
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        Category category = categoryService.findById(product.getIdCategory());
        Positions positions = positionsService.findById(product.getIdPosition());

        req.setAttribute("product",product);
        req.setAttribute("category",category);
        req.setAttribute("positions",positions);
        requestDispatcher = req.getRequestDispatcher("/detail.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("productList",productService.getAllByCategory(id));
        req.setAttribute("positionList",positionsService.fillAll());
        req.setAttribute("categoryList",categoryService.fillAll());
        requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);

    }

    private void showListByPosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("productList",productService.getAllByPosition(id));
        req.setAttribute("positionList",positionsService.fillAll());
        req.setAttribute("categoryList",categoryService.fillAll());
        requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("count",cartService.getCart().size());
        req.setAttribute("positionList",positionsService.fillAll());
        req.setAttribute("categoryList",categoryService.fillAll());
        req.setAttribute("productList",productService.fillAll());
        requestDispatcher = req.getRequestDispatcher("/index.jsp");
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
