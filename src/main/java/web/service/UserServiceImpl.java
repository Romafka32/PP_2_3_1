package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    private UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id,User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getOneUser(Long id) {
        return userDAO.getOneUser(id);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDAO.removeUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
