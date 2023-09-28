package my.project.mininetservice.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import my.project.mininetservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{ //User, Password

    Optional<User> findByUsername(String username);
}
