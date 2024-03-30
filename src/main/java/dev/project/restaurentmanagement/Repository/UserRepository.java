package dev.project.restaurentmanagement.Repository;

import dev.project.restaurentmanagement.Entity.User;
import dev.project.restaurentmanagement.Enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    User findByRole(Role role);
}
