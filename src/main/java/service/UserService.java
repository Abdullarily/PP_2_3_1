package service;

import JPA.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public void editUser(User user) {
        em.merge(user);
    }

    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}
