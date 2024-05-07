package dev.project.restaurantmanagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.project.restaurantmanagement.Dto.FoodDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "food",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"foodCode"})}
)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String foodCode;
    private String name;
    private String description;
    private Long price;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    public FoodDto getFoodDto(){
        return FoodDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .foodCode(foodCode)
                .price(price)
                .returnedImage(image)
                .categoryId(category.getId())
                .build();
    }
}
