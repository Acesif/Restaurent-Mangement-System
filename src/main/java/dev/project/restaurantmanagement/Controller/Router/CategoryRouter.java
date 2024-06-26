package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

public interface CategoryRouter {

    @PostMapping
    ResponseEntity<?> postCategory(@ModelAttribute CategoryDto categoryDto) throws Exception;

    @GetMapping
    ResponseEntity<?> getAllCategories();

    @GetMapping("/{id}")
    ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id);

    @PutMapping
    ResponseEntity<?> updateCategory(@ModelAttribute CategoryDto categoryDto) throws IOException;

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id);

}
