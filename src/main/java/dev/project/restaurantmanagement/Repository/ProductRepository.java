package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByCategoryId(Integer category_id);

    List<Product> findAllByCategoryIdAndNameContaining(Integer category_id, String name);
}
