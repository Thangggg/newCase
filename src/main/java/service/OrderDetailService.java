package service;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.Order;
import model.OrderDetail;
import model.Product;

import java.util.List;

public class OrderDetailService {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    List<OrderDetail> orderDetailList = orderDetailDAO.getAllOrderDetail();
    CartService cartService = new CartService();
    OrderDAO orderDAO = new OrderDAO();
    public List<OrderDetail> fillAll(){
        return orderDetailList;
    }


    public void saveOrderDetail(){
        for (Product pr: cartService.getCart()) {
            System.out.println("aovl");
            OrderDetail orderDetail = new OrderDetail(pr.getDayNumber(), pr.getId(), orderDAO.findOrderMax().getId());
            System.out.println("service");
            orderDetailDAO.saveOrderDetail(orderDetail);

        }
        cartService.resetCart();
    }



    public void delete(int id){
        orderDetailDAO.deleteOrder(id);
        orderDetailList = orderDetailDAO.getAllOrderDetail();
    }

}
