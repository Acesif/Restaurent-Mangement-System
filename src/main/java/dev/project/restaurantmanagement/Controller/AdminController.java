package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.AdminRouter;
import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.FoodDto;
import dev.project.restaurantmanagement.Service.AdminService;
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

}
