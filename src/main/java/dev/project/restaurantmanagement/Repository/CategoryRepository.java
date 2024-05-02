package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByName(String name);
}
