package web.service;


import web.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> listAllUsers() throws SQLException;
    boolean addUser(User user) throws Exception;
    void updateUser(User user) throws SQLException;
    void deleteUser(Long id) throws SQLException;
    User getUserById(Long id) throws SQLException;
    User findUserByUserName(String username) throws SQLException;
}











