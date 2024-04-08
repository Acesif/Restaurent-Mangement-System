package dev.project.restaurentmanagement.Repository;

import dev.project.restaurentmanagement.Dto.ProductDto;
import dev.project.restaurentmanagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByCategoryId(Integer category_id);

    List<Product> findAllByCategoryIdAndNameContaining(Integer category_id, String name);
}
