package service;

import dao.PositionsDAO;
import model.Category;
import model.Positions;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class PositionsService {
    PositionsDAO positionsDAO = new PositionsDAO();
    List<Positions> positionsList = positionsDAO.getAll();

    public List<Positions> fillAll(){
        return positionsList;
    }

    public Positions findById(int id) {
        positionsList = positionsDAO.getAll();
        for (int i = 0; i < positionsList.size(); i++) {
            if (id == positionsList.get(i).getId()) {
                return positionsList.get(i);
            }
        }
        return null;
    }

    public int findByIndex(int id) {
        positionsList = positionsDAO.getAll();
        for (int i = 0; i < positionsList.size(); i++) {
            if (id == positionsList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public List<Positions> findAllPositionByProduct(List<Product> productList){
        List<Positions> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            int index = findByIndex(productList.get(i).getIdPosition());
            Positions positions = positionsList.get(index);
            list.add(positions);
        }
        return list;
    }
}
