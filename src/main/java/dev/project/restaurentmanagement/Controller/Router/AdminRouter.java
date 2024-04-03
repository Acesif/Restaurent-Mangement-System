package dev.project.restaurentmanagement.Controller.Router;

import dev.project.restaurentmanagement.Dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdminRouter {

    ResponseEntity<?> postCategory(@ModelAttribute CategoryDto categoryDto) throws Exception;
}
