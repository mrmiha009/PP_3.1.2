package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User getUser(Integer id) {
        return userRepository.getReferenceById(id);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.save(user);
    }

}
