package web.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web.dao.RoleDAO;
import web.dao.UserDAO;
//import web.model.Role;
import web.model.Role;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements  UserDetailsService, UserService{
    @Autowired
    private UserDAO userDAO;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    // @Autowired
    //RoleDAO roledao;





    @Transactional(readOnly=true)
    public List<User> listAllUsers() throws SQLException {
        return userDAO.listAllUsers();
    }

    @Transactional
    public void addUser(User user) throws SQLException {
       // User userDB = userDAO.findByUsername(user.getUsername());
        user.setRoles(Collections.singleton(new Role(1L,"ROLE_ADMIN")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.addUser(user);
    }


    @Transactional
    public void updateUser(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(Long id) throws SQLException {
        userDAO.deleteUser(id);
    }

    @Transactional
    public User getUserById(Long id) throws SQLException {
        return userDAO.getUserById(id);
    }

    @Transactional
    public boolean validate(String name, String password) throws SQLException {
        return userDAO.validate(name,password);
    }


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(name);
            if (user == null) {
                throw new UsernameNotFoundException("User not exist with name : " + name);
            }
            return user;
    }
}












