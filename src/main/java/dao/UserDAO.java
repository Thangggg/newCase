package dao;

import dao.ConnectMySQL;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    ConnectMySQL connectMySQL = new ConnectMySQL();
    Connection connection = connectMySQL.getConnection();

    public List<User> getAllUser() {
        String sqlGetAll = "SELECT * FROM users";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("nameUser");
                String password = resultSet.getString("pass");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int roll = resultSet.getInt("roll");
                users.add(new User(id, userName, password, phone, address, email, roll));
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveUser(User user) {
        boolean result = false;
        String saveSQl = "INSERT INTO users(nameUser,pass,phone,address,email) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQl);
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getEmail());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User checkLogin(String name, String pass) {
        User user1 = null;
        System.out.println(name);
        System.out.println(pass);
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users where nameUser =? and pass = ?");) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("nameUser");
                String password = rs.getString("pass");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int roll = rs.getInt("roll");
                user1 = new User(id, userName, password, phone, address, email, roll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }

}
