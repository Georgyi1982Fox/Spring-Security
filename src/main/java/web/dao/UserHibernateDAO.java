package web.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserHibernateDAO implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listAllUsers() {
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createQuery("SELECT distinct u FROM User u LEFT JOIN FETCH u.roles".toString())
                .list();
        return listUser;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        User userByName = (User) sessionFactory.
                 getCurrentSession().createQuery("SELECT u FROM  User u  JOIN FETCH u.roles WHERE u.userName=:username")
                .setParameter("username", username)
                .uniqueResult();
        return userByName;
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User editUser = (User) sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.id=:id")
                .setParameter("id", id)
                .uniqueResult();
        User userEditById = new User(editUser.getId(), editUser.getUsername(), editUser.getEmail(), editUser.getRoles());
        return userEditById;
    }
}













