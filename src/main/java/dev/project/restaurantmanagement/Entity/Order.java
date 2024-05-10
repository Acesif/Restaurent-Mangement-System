package dev.project.restaurantmanagement.Entity;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "orders",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"order_id"})}
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private String orderCode;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "order_food",
            joinColumns = {
                @JoinColumn(name = "order_id",referencedColumnName = "order_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "food_id", referencedColumnName = "food_id")
            }
    )
    private List<Food> foods;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(nullable = false)
    private Float bill;

    public OrderDto getOrderDto(){
        return OrderDto.builder()
                .id(id)
                .orderCode(orderCode)
                .bill(bill)
                .foodCodeList(getFoods().stream().map(Food::getFoodCode).collect(Collectors.toList()))
                .user_id(user.getId())
                .build();
    }
}
