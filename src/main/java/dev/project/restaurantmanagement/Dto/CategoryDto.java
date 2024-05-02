package dev.project.restaurantmanagement.Dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    @JsonSerialize(using = MultipartFileSerializer.class)
    private MultipartFile image;
    private byte[] returnedImage;
}
