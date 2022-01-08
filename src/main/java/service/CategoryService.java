package service;

import dao.CategoryDAO;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categoryList = categoryDAO.getAll();

    public List<Category> fillAll(){
        return categoryList;
    }

    public Category findById(int id) {
        categoryList = categoryDAO.getAll();
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    public int findByIndex(int id) {
        categoryList = categoryDAO.getAll();
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public List<Category> findAllCategoryByProduct(List<Product> productList){
        List<Category> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            int index = findByIndex(productList.get(i).getIdCategory());
            Category category = categoryList.get(index);
            list.add(category);
        }
        return list;
    }
}
