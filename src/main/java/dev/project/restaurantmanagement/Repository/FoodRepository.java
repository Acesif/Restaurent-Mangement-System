package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    List<Food> findAllByCategoryId(Integer category_id);
    Optional<Food> findByFoodCode(String code);
    List<Food> findAllByCategoryIdAndNameContaining(Integer category_id, String name);
}
