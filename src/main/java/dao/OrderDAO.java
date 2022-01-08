package dao;



import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    ConnectMySQL connectMySQL = new ConnectMySQL();
    Connection connection = connectMySQL.getConnection();

    public List<Order> getAllOrder() {
        String sqlGetAll = "SELECT * FROM orders ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Order> orderLists = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int accountId = resultSet.getInt("userID");
                int totalPrice = resultSet.getInt("totalPrice");
                String status = resultSet.getString("statuss");
                orderLists.add(new Order(id,accountId,totalPrice,status));
            }
            return orderLists;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public  boolean saveOrder(Order order) {
        boolean result=false;
        String saveSQl = "INSERT INTO orders(userID,totalPrice) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQl);
            preparedStatement.setInt(1,order.getUserId());
            preparedStatement.setDouble(2,order.getTotalPrice());
            result = preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public Order findOrderMax(){
        String sqlGetAll = "SELECT * FROM orders where id = (select max(id) from orders);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = new Order();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int accountId = resultSet.getInt("userID");
                int totalPrice = resultSet.getInt("totalPrice");
                String status = resultSet.getString("statuss");
                return new Order(id,accountId,totalPrice,status);

            }
            return order;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
