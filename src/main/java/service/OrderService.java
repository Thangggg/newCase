package service;

import dao.OrderDAO;
import model.Order;

import java.util.List;

public class OrderService {
    OrderDAO orderDAO = new OrderDAO();
    List<Order> orderList = orderDAO.getAllOrder();

    public List<Order> fillAll(){
        return orderList;
    }


    public void create(Order order){
        orderDAO.saveOrder(order);
        orderList = orderDAO.getAllOrder();
    }

    public void delete(int id){
        orderDAO.deleteOrder(id);
        orderList = orderDAO.getAllOrder();

    }




}
