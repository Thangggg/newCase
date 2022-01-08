package dao;

import model.Positions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionsDAO {
    ConnectMySQL connectMySQL = new ConnectMySQL();
    Connection connection = connectMySQL.getConnection();

    public List<Positions> getAll(){
        String sqlGetAll = "SELECT * FROM qlsach.positions";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Positions> positionsList = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                positionsList.add(new Positions(id,name));
            }
            return positionsList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
