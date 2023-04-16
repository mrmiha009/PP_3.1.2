package web.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

//    @Transactional
//    @Override
//    public List<User> carOwners(String model, int series) {
//        return userDao.carOwners(model, series);
//    }

}
