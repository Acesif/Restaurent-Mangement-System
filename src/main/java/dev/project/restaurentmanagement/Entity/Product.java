package dev.project.restaurentmanagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.project.restaurentmanagement.Dto.ProductDto;
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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Long price;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    public ProductDto getProductDto(){
        return ProductDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .returnedImg(img)
                .categoryId(category.getId())
                .categoryName(category.getName())
                .build();
    }
}
