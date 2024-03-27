package dev.project.restaurentmanagement.Repository;

import dev.project.restaurentmanagement.Dto.UserDto;
import dev.project.restaurentmanagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT email FROM user u WHERE u.email = ?",nativeQuery = true)
    String findByEmail(String email);
}
