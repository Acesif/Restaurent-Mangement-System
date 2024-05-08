package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.FoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

public interface FoodRouter {

    @PostMapping
    ResponseEntity<?> postFood(@ModelAttribute FoodDto foodDto) throws IOException;

    @GetMapping("/{categoryId}/foods")
    ResponseEntity<?> getAllFoodsByCategory(@PathVariable("categoryId") Integer categoryId);

    @GetMapping("/{categoryId}/food/{name}")
    ResponseEntity<?> getFoodsByCategoryAndTitle(@PathVariable("categoryId") Integer categoryId, @PathVariable("name") String name);

    @PutMapping
    ResponseEntity<?> updateFood(@ModelAttribute FoodDto foodDto) throws IOException;

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteFood(@PathVariable("id") Integer id);
}
