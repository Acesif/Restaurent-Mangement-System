package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.FoodRouter;
import dev.project.restaurantmanagement.Dto.FoodDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/admin/food")
public class FoodController implements FoodRouter {
    
    private final FoodService foodService;
    
    @Override
    public ResponseEntity<?> postFood(FoodDto foodDto) throws IOException {
        Response<FoodDto> createdFoodDto = foodService.postProduct(foodDto);
        return new ResponseEntity<>(createdFoodDto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllFoodsByCategory(Integer categoryId) {
        Response<List<FoodDto>> foodDtoList = foodService.getAllProductsByCategory(categoryId);
        return new ResponseEntity<>(foodDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFoodsByCategoryAndTitle(Integer categoryId, String name) {
        Response<List<FoodDto>> foodDtoList = foodService.getProductsByCategoryAndName(categoryId,name);
        return new ResponseEntity<>(foodDtoList, HttpStatus.OK);
    }
}
