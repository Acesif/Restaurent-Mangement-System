package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.FoodDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Entity.Category;
import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Repository.CategoryRepository;
import dev.project.restaurantmanagement.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    public Response<FoodDto> postProduct(FoodDto foodDto) throws IOException {
        Optional<Category> category = categoryRepository.findById(foodDto.getCategoryId());
        if(foodRepository.findByFoodCode(foodDto.getFoodCode()).isPresent()){
            return Response.<FoodDto>builder()
                    .isSuccess(false)
                    .code(400)
                    .message("Food already exists")
                    .values(null)
                    .build();
        }
        if(category.isPresent()){
            Food food = Food.builder()
                    .name(foodDto.getName())
                    .foodCode(foodDto.getFoodCode())
                    .description(foodDto.getDescription())
                    .image(foodDto.getImage().getBytes())
                    .category(category.get())
                    .price(foodDto.getPrice())
                    .build();

            Food savedFood = foodRepository.save(food);
            return Response.<FoodDto>builder()
                    .isSuccess(true)
                    .code(201)
                    .message("Food created successfully")
                    .values(FoodDto.builder()
                            .id(savedFood.getId())
                            .foodCode(savedFood.getFoodCode())
                            .name(savedFood.getName())
                            .description(savedFood.getDescription())
                            .price(savedFood.getPrice())
                            .image(foodDto.getImage())
                            .returnedImage(savedFood.getImage())
                            .build())
                    .build();
        }
        return Response.<FoodDto>builder()
                .isSuccess(false)
                .code(400)
                .message("Category not found")
                .values(null)
                .build();
    }

    public Response<List<FoodDto>> getAllProductsByCategory(Integer categoryId) {
        List<FoodDto> allFood =  foodRepository.findAllByCategoryId(categoryId)
                .stream()
                .map(Food::getFoodDto)
                .toList();
        return Response.<List<FoodDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("All foods successfully fetched")
                .values(allFood)
                .build();
    }

    public Response<List<FoodDto>> getProductsByCategoryAndName(Integer category_id, String name) {
        List<FoodDto> catAndName =  foodRepository.findAllByCategoryIdAndNameContaining(category_id,name)
                .stream()
                .map(Food::getFoodDto)
                .toList();
        return Response.<List<FoodDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("All food with "+name+" successfully fetched")
                .values(catAndName)
                .build();
    }
}