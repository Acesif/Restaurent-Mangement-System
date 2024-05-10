package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.OrderDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Entity.Order;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Repository.FoodRepository;
import dev.project.restaurantmanagement.Repository.OrderRepository;
import dev.project.restaurantmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public Response<OrderDto> postOrder(OrderDto orderDto) {
        User customer = userRepository.findById(orderDto.getUser_id()).orElseThrow();
        List<Food> foodList = new ArrayList<>();
        for (String code : orderDto.getFoodCodeList()) {
            foodList.add(foodRepository.findByFoodCode(code).orElseThrow());
        }

        Order order = Order.builder()
                .user(customer)
                .orderCode(orderDto.getOrderCode())
                .bill(orderDto.getBill())
                .foods(foodList)
                .build();
        Order savedOrder = orderRepository.save(order);

        return Response.<OrderDto>builder()
                .isSuccess(true)
                .code(201)
                .message("Order placed successfully")
                .values(OrderDto.builder()
                        .id(savedOrder.getId())
                        .bill(savedOrder.getBill())
                        .orderCode(savedOrder.getOrderCode())
                        .foodCodeList(orderDto.getFoodCodeList())
                        .user_id(savedOrder.getUser().getId())
                        .build())
                .build();
    }

    public Response<List<OrderDto>> getOrders(){
        List<Order> orderList = orderRepository.findAll();
        return Response.<List<OrderDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("Orders successfully fetched")
                .values(orderList.stream().map(Order::getOrderDto).toList())
                .build();
    }
    public Response<OrderDto> getOrderByCode(String code){
        Order order = orderRepository.getOrderByOrderCode(code).orElseThrow();

        return Response.<OrderDto>builder()
                .isSuccess(true)
                .code(200)
                .message("Order "+ code +" successfully fetched")
                .values(OrderDto.builder()
                        .id(order.getId())
                        .orderCode(order.getOrderCode())
                        .user_id(order.getUser().getId())
                        .foodCodeList(order.getFoods().stream().map(Food::getFoodCode).collect(Collectors.toList()))
                        .orderCode(order.getOrderCode())
                        .build())
                .build();
    }

    public Response<Void> deleteOrder(Integer id){
        orderRepository.deleteById(id);
        return Response.<Void>builder()
                .isSuccess(true)
                .code(200)
                .message("Order deleted successfully")
                .values(null)
                .build();
    }
    public Response<OrderDto> updateOrder(OrderDto orderDto){
        Order order = orderRepository.getOrderByOrderCode(orderDto.getOrderCode()).orElseThrow();
        List<Food> foodList = new ArrayList<>();
        for(String code: orderDto.getFoodCodeList()){
            foodList.add(foodRepository.findByFoodCode(code).orElse(null));
        }
        order.setBill(orderDto.getBill());
        order.setUser(userRepository.findById(orderDto.getUser_id()).orElse(order.getUser()));
        order.setFoods(foodList);
        Order savedOrder = orderRepository.save(order);

        return Response.<OrderDto>builder()
                .isSuccess(true)
                .code(201)
                .message("Order successfully updated")
                .values(OrderDto.builder()
                        .orderCode(savedOrder.getOrderCode())
                        .id(savedOrder.getId())
                        .bill(savedOrder.getBill())
                        .user_id(savedOrder.getUser().getId())
                        .foodCodeList(savedOrder.getFoods().stream().map(Food::getFoodCode).collect(Collectors.toList()))
                        .build())
                .build();
    }
}
