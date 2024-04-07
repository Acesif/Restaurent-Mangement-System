package dev.project.restaurentmanagement.Service.BaseService;

import dev.project.restaurentmanagement.Dto.CategoryDto;
import dev.project.restaurentmanagement.Entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    CategoryDto postCategory(CategoryDto categoryDto) throws Exception;

    List<CategoryDto> getAllCategories();

    Void deleteCategory(Integer id);
}
