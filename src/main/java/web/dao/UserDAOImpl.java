package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = getOneUser(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = getOneUser(id);
        entityManager.remove(user);
    }

    @Override
    public User getOneUser(Long id) {
        return entityManager.createQuery("select u from User u where id = :id", User.class).setParameter("id",id).getSingleResult();
    }
}
