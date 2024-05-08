package dev.project.restaurantmanagement.Dto;

import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OrderDto {

    private Integer id;
    private String orderCode;
    private List<String> foodCodeList;
    private Integer user_id;
    private Float bill;
}
