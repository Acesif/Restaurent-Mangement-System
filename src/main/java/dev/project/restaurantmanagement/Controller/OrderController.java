package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.OrderRouter;
import dev.project.restaurantmanagement.Dto.OrderDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/order")
@RequiredArgsConstructor
public class OrderController implements OrderRouter {

    private final OrderService orderService;

    @Override
    public ResponseEntity<?> postOrder(OrderDto orderDto) {
        Response<OrderDto> createdOrder = orderService.postOrder(orderDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOrders() {
        Response<List<OrderDto>> getOrders = orderService.getOrders();
        return new ResponseEntity<>(getOrders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOrderByCode(String code) {
        Response<OrderDto> getOrder = orderService.getOrderByCode(code);
        return new ResponseEntity<>(getOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteOrder(Integer id) {
        Response<Void> deletedOrder = orderService.deleteOrder(id);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateOrder(OrderDto orderDto) {
        Response<OrderDto> updatedOrder = orderService.updateOrder(orderDto);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
}
