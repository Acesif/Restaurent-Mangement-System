package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderRouter {

    @PostMapping
    ResponseEntity<?> postOrder(@RequestBody OrderDto orderDto);

    @GetMapping
    ResponseEntity<?> getOrders();

    @GetMapping("/ordr_{code}")
    ResponseEntity<?> getOrderByCode(@PathVariable("code") String code);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable("id") Integer id);

    @PutMapping
    ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto);
}
