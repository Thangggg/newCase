package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    UserDAO userDao = new UserDAO();
    List<User> users = userDao.getAllUser();

    public   List<User> getAccountList(){
        return users = userDao.getAllUser();
    }
    public boolean saveUser(User user){
        boolean result=  userDao.saveUser(user);
        users = userDao.getAllUser();
        return result;
    }
    public  int findIndexById(int id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public User checkLogin(String userName,String password){
        return userDao.checkLogin(userName,password);
    }
}
