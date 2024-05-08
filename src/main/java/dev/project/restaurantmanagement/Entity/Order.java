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
        uniqueConstraints = {@UniqueConstraint(columnNames = {"orderCode"})}
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private String orderCode;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<Food> food;

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
                .foodCodeList(getFood().stream().map(Food::getFoodCode).collect(Collectors.toList()))
                .user_id(user.getId())
                .build();
    }
}
