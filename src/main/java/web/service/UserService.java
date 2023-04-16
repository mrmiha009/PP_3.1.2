package web.service;



import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUser(Integer id);
    void deleteUser(Integer id);
//    List<User> carOwners(String model, int series);
}
