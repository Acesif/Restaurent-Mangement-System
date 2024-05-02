package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
