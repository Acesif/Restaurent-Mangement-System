package dev.project.restaurentmanagement.Controller;

import dev.project.restaurentmanagement.Controller.Router.AdminRouter;
import dev.project.restaurentmanagement.Dto.CategoryDto;
import dev.project.restaurentmanagement.Dto.ProductDto;
import dev.project.restaurentmanagement.Service.BaseService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController implements AdminRouter {

    private final AdminService adminService;

    public ResponseEntity<CategoryDto> postCategory(CategoryDto categoryDto) throws Exception {
        CategoryDto createdDto = adminService.postCategory(categoryDto);
        if(createdDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdDto,HttpStatus.CREATED);
    }

    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtoList = adminService.getAllCategories();
        if(categoryDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id){
        adminService.deleteCategory(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoryByName(String name) {
        List<CategoryDto> categoryDtoList = adminService.getAllCategoriesByName(name);
        if (categoryDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> postProduct(Integer categoryId, ProductDto productDto) throws IOException {
        ProductDto createdProductDto = adminService.postProduct(categoryId,productDto);
        if(createdProductDto == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productDto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(Integer categoryId) {
        List<ProductDto> productDtoList = adminService.getAllProductsByCategory(categoryId);
        if(productDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductsByCategoryAndTitle(Integer categoryId, String name) {
        List<ProductDto> productDtoList = adminService.getProductsByCategoryAndName(categoryId,name);
        if(productDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

}
