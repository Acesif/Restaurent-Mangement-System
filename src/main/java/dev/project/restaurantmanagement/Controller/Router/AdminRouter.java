package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

public interface AdminRouter {

    @PostMapping("/category")
    ResponseEntity<?> postCategory(@ModelAttribute CategoryDto categoryDto) throws Exception;

    @GetMapping("/category")
    ResponseEntity<?> getAllCategories();

    @DeleteMapping("/category/{id}")
    ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id);

    @GetMapping("/category/{name}")
    ResponseEntity<?> getAllCategoryByName(@PathVariable("name") String name);

    @PostMapping("/{categoryId}/product")
    ResponseEntity<?> postProduct(@PathVariable("categoryId") Integer categoryId, @ModelAttribute ProductDto productDto) throws IOException;

    @GetMapping("/{categoryId}/products")
    ResponseEntity<?> getAllProductsByCategory(@PathVariable("categoryId") Integer categoryId);

    @GetMapping("/{categoryId}/product/{name}")
    ResponseEntity<?> getProductsByCategoryAndTitle(@PathVariable("categoryId") Integer categoryId, @PathVariable("name") String name);

}