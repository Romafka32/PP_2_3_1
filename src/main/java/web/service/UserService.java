package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    void createUser(User user);

    void updateUser(Long id,User user);

    User getOneUser(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();
}
