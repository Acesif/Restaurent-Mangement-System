package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.FoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

public interface FoodRouter {

    @PostMapping
    ResponseEntity<?> postFood(@ModelAttribute FoodDto foodDto) throws IOException;

    @GetMapping("/{categoryId}/foods")
    ResponseEntity<?> getAllFoodsByCategory(@PathVariable("categoryId") Integer categoryId);

    @GetMapping("/{categoryId}/food/{name}")
    ResponseEntity<?> getFoodsByCategoryAndTitle(@PathVariable("categoryId") Integer categoryId, @PathVariable("name") String name);

}
