package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> getOrderByOrderCode(String code);
    void deleteOrderByOrderCode(String code);
}
