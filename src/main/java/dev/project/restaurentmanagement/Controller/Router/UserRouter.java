package dev.project.restaurentmanagement.Controller.Router;

import dev.project.restaurentmanagement.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserRouter {

    @PostMapping("/signup")
    ResponseEntity<String> signUp(@RequestBody UserDto userDto);
}
