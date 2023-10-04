package my.project.mininetservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import my.project.mininetservice.model.User;

@Service
@Transactional
public class UserService {
    private final EntityManager entityManager;

    @Autowired
    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void findAllAndPrintToConsole() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
