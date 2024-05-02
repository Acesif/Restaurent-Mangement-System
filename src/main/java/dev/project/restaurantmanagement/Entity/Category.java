package dev.project.restaurantmanagement.Entity;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;

    public CategoryDto getCategoryDto(){
        return CategoryDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .returnedImage(image)
                .build();
    }
}
