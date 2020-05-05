package web.dao;

import org.hibernate.Session;
//import web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.sql.SQLException;
import java.util.List;
@Repository
public class UserHibernateDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listAllUsers(){
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u").list();
        return listUser;
    }

    @Override
    public void addUser(User user){
       sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void updateUser(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findByUsername(String username){
        User userByName = (User)sessionFactory.getCurrentSession().createQuery("  select u FROM  User u WHERE u.userName=:username")
        .setParameter("username",username)
                .uniqueResult();
        return userByName;
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
        User userGetById = new User(user.getId(), user.getPassword(), user.getEmail());
        return userGetById;
    }

    @Override
    public boolean validate(String name, String password) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u  WHERE u.userName=:name")
                .setParameter("name", name)
                .setParameter("password",password)
                .uniqueResult();
        if (user != null) {
            return true;
        } else
            return false;
    }
}


















