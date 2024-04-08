package dev.project.restaurentmanagement.Repository;

import dev.project.restaurentmanagement.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByName(String name);
}
