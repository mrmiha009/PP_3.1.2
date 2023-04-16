package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

//    private final SessionFactory sessionFactory;
//
//    public UserDaoImp(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> carOwners(String model, int series) {
//        TypedQuery<User> query = sessionFactory.getCurrentSession()
//                .createQuery("select u from User u where u.userCar.model=:model and u.userCar.series=:series")
//                .setParameter("model", model).setParameter("series", series);
//        return query.getResultList();
//    }

}
