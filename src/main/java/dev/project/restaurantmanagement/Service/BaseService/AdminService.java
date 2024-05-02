package dev.project.restaurantmanagement.Service.BaseService;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    CategoryDto postCategory(CategoryDto categoryDto) throws Exception;

    List<CategoryDto> getAllCategories();

    List<CategoryDto> getAllCategoriesByName(String name);

    void deleteCategory(Integer id);

    ProductDto postProduct(Integer categoryId, ProductDto productDto) throws IOException;

    List<ProductDto> getAllProductsByCategory(Integer categoryId);

    List<ProductDto> getProductsByCategoryAndName(Integer category_id, String name);
}
