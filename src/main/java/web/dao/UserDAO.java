package web.dao;


import web.model.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(Long id, User user);

    void removeUser(Long id);

    User getOneUser(Long id);
}
