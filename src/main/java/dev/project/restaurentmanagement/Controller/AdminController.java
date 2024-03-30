package dev.project.restaurentmanagement.Controller;

import dev.project.restaurentmanagement.Controller.Router.AdminRouter;
import dev.project.restaurentmanagement.Dto.CategoryDto;
import dev.project.restaurentmanagement.Entity.Category;
import dev.project.restaurentmanagement.Service.BaseService.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController implements AdminRouter {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> postCategory(CategoryDto categoryDto) throws Exception {
        CategoryDto createdDto = adminService.postCategory(categoryDto);
        if(createdDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdDto,HttpStatus.CREATED);
    }
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtoList = adminService.getAllCategories();
        if(categoryDtoList == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }
}
