package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    Optional<User> getUser(Integer id);

    void delete(Integer id);

    void update(User user);

}
