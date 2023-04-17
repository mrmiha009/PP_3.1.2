package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUser(Integer id);

    void delete(Integer id);

    void update(User user);

}
