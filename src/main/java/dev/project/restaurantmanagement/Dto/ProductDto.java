package dev.project.restaurantmanagement.Dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String description;

    private Long price;

    private byte[] returnedImg;

    @JsonSerialize(using = MultipartFileSerializer.class)
    private MultipartFile img;

    private Integer categoryId;

    private String categoryName;
}
