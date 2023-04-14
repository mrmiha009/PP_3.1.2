package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> carOwners(String model, int series) {
//        TypedQuery<User> query = sessionFactory.getCurrentSession()
//                .createQuery("select u from User u where u.userCar.model=:model and u.userCar.series=:series")
//                .setParameter("model", model).setParameter("series", series);
//        return query.getResultList();
//    }

}
