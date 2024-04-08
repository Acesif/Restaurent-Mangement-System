package dev.project.restaurentmanagement.Service;

import dev.project.restaurentmanagement.Dto.CategoryDto;
import dev.project.restaurentmanagement.Dto.ProductDto;
import dev.project.restaurentmanagement.Entity.Category;
import dev.project.restaurentmanagement.Entity.Product;
import dev.project.restaurentmanagement.Repository.CategoryRepository;
import dev.project.restaurentmanagement.Repository.ProductRepository;
import dev.project.restaurentmanagement.Service.BaseService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
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

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> getAllCategoriesByName(String name) {
        return categoryRepository.findAllByName(name)
                .stream()
                .map(Category::getCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
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

    @Override
    public List<ProductDto> getAllProductsByCategory(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId)
                .stream()
                .map(Product::getProductDto)
                .collect(Collectors.toList());
    }
}
