package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Entity.Category;
import dev.project.restaurantmanagement.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Response<CategoryDto> postCategory(CategoryDto categoryDto) throws Exception{
        if(categoryRepository.findByName(categoryDto.getName()).isPresent()){
            return Response.<CategoryDto>builder()
                    .isSuccess(false)
                    .code(400)
                    .message("Category already exists")
                    .build();
        }
        Category category = Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .image(categoryDto.getImage().getBytes())
                .build();
        Category savedCategory = categoryRepository.save(category);
        return Response.<CategoryDto>builder()
                .isSuccess(true)
                .code(200)
                .message("Category created successfully")
                .values(CategoryDto.builder()
                        .id(savedCategory.getId())
                        .name(savedCategory.getName())
                        .description(savedCategory.getDescription())
                        .image(categoryDto.getImage())
                        .returnedImage(savedCategory.getImage())
                        .build())
                .build();
    }

    public Response<CategoryDto> getCategoryById(Integer id){
        Category category = categoryRepository.findById(id).orElseThrow();
        return Response.<CategoryDto>builder()
                .isSuccess(true)
                .code(200)
                .message("Category successfully fetched")
                .values(CategoryDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .description(category.getDescription())
                        .returnedImage(category.getImage())
                        .build())
                .build();
    }

    public Response<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories =  categoryRepository.findAll()
                .stream()
                .map(Category::getCategoryDto)
                .toList();
        return Response.<List<CategoryDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("All categories fetched")
                .values(allCategories)
                .build();
    }

    public Response<CategoryDto> updateCategory(CategoryDto categoryDto){
        Category category = categoryRepository.findById(categoryDto.getId()).orElseThrow();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setImage(categoryDto.getReturnedImage());

        Category savedCategory = categoryRepository.save(category);

        return Response.<CategoryDto>builder()
                .isSuccess(true)
                .code(201)
                .message("Category successfully updated")
                .values(CategoryDto.builder()
                        .id(savedCategory.getId())
                        .name(savedCategory.getName())
                        .description(savedCategory.getDescription())
                        .image(categoryDto.getImage())
                        .build())
                .build();
    }

    public Response<Void> deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return Response.<Void>builder()
                .isSuccess(true)
                .code(200)
                .message("Category successfully deleted")
                .values(null)
                .build();
    }
}
