package dao;

import model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    ConnectMySQL connectMySQL = new ConnectMySQL();
    Connection connection = connectMySQL.getConnection();

    public List<Product> getAll(){
        String sqlGetAll = "SELECT * FROM qlsach.product";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                Date dateUp = resultSet.getDate("dateUp");
                String status = resultSet.getString("statuss");
                String description = resultSet.getString("descriptions");
                int price = resultSet.getInt("price");
                int idCategory = resultSet.getInt("idCategory");
                int idPosition = resultSet.getInt("idposition");
                String img = resultSet.getString("img");
                int quantity = resultSet.getInt("quantity");
                productList.add(new Product(id,nameProduct,dateUp,status,description,price,idCategory,idPosition,img,quantity));
            }

            return productList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void save(Product product){

        String saveSQL = "INSERT INTO qlsach.product (nameProduct, dateUp, statuss, descriptions, price, idCategory, idposition, img, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setDate(2,product.getDateUp());
            preparedStatement.setString(3,product.getStatus());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setInt(5,product.getPrice());
            preparedStatement.setInt(6,product.getIdCategory());
            preparedStatement.setInt(7,product.getIdPosition());
            preparedStatement.setString(8,product.getImg());
            preparedStatement.setInt(9,product.getQuantity());
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String deleteSQL = "DELETE from qlsach.product where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void edit(Product product){
        String editSQL = "UPDATE qlsach.product SET nameProduct = ?, dateUp = ?, statuss = ?, descriptions = ?, price = ?, idCategory = ?, idposition = ?, img = ?, quantity = ? WHERE (id = ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editSQL);
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setDate(2,product.getDateUp());
            preparedStatement.setString(3,product.getStatus());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setInt(5,product.getPrice());
            preparedStatement.setInt(6,product.getIdCategory());
            preparedStatement.setInt(7,product.getIdPosition());
            preparedStatement.setString(8,product.getImg());
            preparedStatement.setInt(9,product.getQuantity());
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Product> findName(String findName){
        String sqlFindName = "SELECT * FROM qlsach.product where nameProduct like \"%"+findName+"%\"";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlFindName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                Date dateUp = resultSet.getDate("dateUp");
                String status = resultSet.getString("statuss");
                String description = resultSet.getString("descriptions");
                int price = resultSet.getInt("price");
                int idCategory = resultSet.getInt("idCategory");
                int idPosition = resultSet.getInt("idposition");
                String img = resultSet.getString("img");
                int quantity = resultSet.getInt("quantity");
                productList.add(new Product(id,nameProduct,dateUp,status,description,price,idCategory,idPosition,img,quantity));
            }

            return productList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllByPosition(int id) {
        String getAllSql = "SELECT * FROM qlsach.product where idposition = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                Date dateUp = resultSet.getDate("dateUp");
                String status = resultSet.getString("statuss");
                String description = resultSet.getString("descriptions");
                int price = resultSet.getInt("price");
                int idCategory = resultSet.getInt("idCategory");
                int idPosition = resultSet.getInt("idposition");
                String img = resultSet.getString("img");
                int quantity = resultSet.getInt("quantity");
                productList.add(new Product(idProduct,nameProduct,dateUp,status,description,price,idCategory,idPosition,img,quantity));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllByCategory(int id) {
        String getAllSql = "SELECT * FROM qlsach.product where idCategory = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                Date dateUp = resultSet.getDate("dateUp");
                String status = resultSet.getString("statuss");
                String description = resultSet.getString("descriptions");
                int price = resultSet.getInt("price");
                int idCategory = resultSet.getInt("idCategory");
                int idPosition = resultSet.getInt("idposition");
                String img = resultSet.getString("img");
                int quantity = resultSet.getInt("quantity");
                productList.add(new Product(idProduct,nameProduct,dateUp,status,description,price,idCategory,idPosition,img,quantity));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
