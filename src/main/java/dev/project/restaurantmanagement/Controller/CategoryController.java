package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.CategoryRouter;
import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/admin/category")
public class CategoryController implements CategoryRouter {
    
    private final CategoryService categoryService;

    public ResponseEntity<?> postCategory(CategoryDto categoryDto) throws Exception {
        Response<CategoryDto> createdDto = categoryService.postCategory(categoryDto);
        if(createdDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdDto,HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllCategories(){
        Response<List<CategoryDto>> categoryDtoList = categoryService.getAllCategories();
        if(categoryDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id){
        Response<Void> deleted = categoryService.deleteCategory(id);
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }
}
