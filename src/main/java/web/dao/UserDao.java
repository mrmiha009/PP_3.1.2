package web.dao;



import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

//    List<User> carOwners(String model, int series);
}