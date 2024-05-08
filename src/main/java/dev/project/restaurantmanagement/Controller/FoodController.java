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
        Response<FoodDto> createdFoodDto = foodService.postFood(foodDto);
        return new ResponseEntity<>(createdFoodDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllFoodsByCategory(Integer categoryId) {
        Response<List<FoodDto>> foodDtoList = foodService.getAllFoodsByCategory(categoryId);
        return new ResponseEntity<>(foodDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFoodsByCategoryAndTitle(Integer categoryId, String name) {
        Response<List<FoodDto>> foodDtoList = foodService.getFoodsByCategoryAndName(categoryId,name);
        return new ResponseEntity<>(foodDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateFood(FoodDto foodDto) throws IOException {
        Response<FoodDto> updatedFoodDto = foodService.updateFood(foodDto);
        return new ResponseEntity<>(updatedFoodDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteFood(Integer id) {
        Response<Void> deleteFoodDto = foodService.deleteFood(id);
        return new ResponseEntity<>(deleteFoodDto,HttpStatus.CREATED);
    }
}
