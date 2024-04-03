package dev.project.restaurentmanagement.Service;

import dev.project.restaurentmanagement.Dto.CategoryDto;
import dev.project.restaurentmanagement.Entity.Category;
import dev.project.restaurentmanagement.Repository.CategoryRepository;
import dev.project.restaurentmanagement.Service.BaseService.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminServiceImpl implements AdminService {

    private final CategoryRepository categoryRepository;

    public AdminServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

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
                .description(categoryDto.getDescription())
                .image(categoryDto.getImage())
                .returnedImage(categoryDto.getReturnedImage())
                .build();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getCategoryDto)
                .collect(Collectors.toList());
    }
}
