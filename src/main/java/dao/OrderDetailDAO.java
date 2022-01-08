package dao;

import model.OrderDetail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {

    ConnectMySQL connectMySQL = new ConnectMySQL();
    Connection connection = connectMySQL.getConnection();
    public List<OrderDetail> getAllOrderDetail() {
        String sqlGetAll = "SELECT * FROM orderdetail ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<OrderDetail> orderDetailList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int dateNumber = resultSet.getInt("dateNumber");
                int productId = resultSet.getInt("productId");
                int orderId = resultSet.getInt("orderId");
                Date dateStart = resultSet.getDate("dateStart");
                Date dateEnd = resultSet.getDate("dateEnd");
                orderDetailList.add(new OrderDetail(id,dateNumber,productId,orderId,dateStart,dateEnd));
            }
            return orderDetailList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public  boolean saveOrderDetail(OrderDetail orderDetail) {
        boolean result = false;
        long longMillis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(longMillis);
        System.out.println("zo123");
        String saveSQl = "INSERT INTO orderdetail (dateNumber,productId,orderId,dateStart) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQl);
            preparedStatement.setInt(1,orderDetail.getDateNumber());
            preparedStatement.setInt(2,orderDetail.getIdProduct());
            preparedStatement.setInt(3,orderDetail.getOrderId());
            preparedStatement.setDate(4,date);
            System.out.println("zo");
            result = preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public  void deleteOrder(int id){
        String deleteSQL = "DELETE from orders where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
