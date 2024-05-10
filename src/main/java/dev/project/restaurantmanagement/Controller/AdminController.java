package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.AdminRouter;
import dev.project.restaurantmanagement.Dto.*;
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

    private final AdminService adminService;

    @Override
    public ResponseEntity<?> updateUser(UserDto userDto) {
        Response<UserDto> updatedUser = adminService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserById(Integer id) {
        Response<UserDto> getUser = adminService.getUserById(id);
        return new ResponseEntity<>(getUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        Response<Void> deleteUser = adminService.deleteUser(id);
        return new ResponseEntity<>(deleteUser,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> signUpEmployee(UserDto registerRequest) {
        Response<AuthResponse> createdAdminDto = adminService.registerEmployee(registerRequest);
        return new ResponseEntity<>(createdAdminDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        Response<List<UserDto>> allUsers = adminService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
}
