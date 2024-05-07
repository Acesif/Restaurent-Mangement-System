package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.ProductDto;
import dev.project.restaurantmanagement.Entity.Category;
import dev.project.restaurantmanagement.Entity.Product;
import dev.project.restaurantmanagement.Repository.CategoryRepository;
import dev.project.restaurantmanagement.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryDto postCategory(CategoryDto categoryDto) throws Exception{
        Category category = Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .image(categoryDto.getImage().getBytes())
                .build();
        Category savedCategory = categoryRepository.save(category);
        return CategoryDto.builder()
                .id(savedCategory.getId())
                .name(savedCategory.getName())
                .description(savedCategory.getDescription())
                .image(categoryDto.getImage())
                .returnedImage(savedCategory.getImage())
                .build();
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getCategoryDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDto> getAllCategoriesByName(String name) {
        return categoryRepository.findAllByName(name)
                .stream()
                .map(Category::getCategoryDto)
                .collect(Collectors.toList());
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public ProductDto postProduct(Integer categoryId, ProductDto productDto) throws IOException {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            Product product = Product.builder()
                    .name(productDto.getName())
                    .description(productDto.getDescription())
                    .img(productDto.getImg().getBytes())
                    .category(category.get())
                    .price(productDto.getPrice())
                    .build();

            Product savedProduct = productRepository.save(product);
            return ProductDto.builder()
                    .id(savedProduct.getId())
                    .name(savedProduct.getName())
                    .description(savedProduct.getDescription())
                    .price(savedProduct.getPrice())
                    .returnedImg(savedProduct.getImg())
                    .build();
        }
        return null;
    }

    public List<ProductDto> getAllProductsByCategory(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId)
                .stream()
                .map(Product::getProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsByCategoryAndName(Integer category_id, String name) {
        return productRepository.findAllByCategoryIdAndNameContaining(category_id,name)
                .stream()
                .map(Product::getProductDto)
                .collect(Collectors.toList());
    }
}
