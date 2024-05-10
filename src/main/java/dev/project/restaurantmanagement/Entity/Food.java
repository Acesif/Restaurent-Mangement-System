package dev.project.restaurantmanagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.project.restaurantmanagement.Dto.FoodDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "food",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"food_id"})}
)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "food_id")
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

    @ManyToMany(mappedBy = "foods")
    List<Order> orders;


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
