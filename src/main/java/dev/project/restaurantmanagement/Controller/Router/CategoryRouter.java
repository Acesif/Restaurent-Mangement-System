package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CategoryRouter {

    @PostMapping
    ResponseEntity<?> postCategory(@ModelAttribute CategoryDto categoryDto) throws Exception;

    @GetMapping
    ResponseEntity<?> getAllCategories();

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id);

}
