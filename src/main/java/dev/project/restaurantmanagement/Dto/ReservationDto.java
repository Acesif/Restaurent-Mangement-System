package dev.project.restaurantmanagement.Dto;

import dev.project.restaurantmanagement.Entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ReservationDto {

    private Integer id;

    private String reservationCode;

    private Integer amountOfPeople;

    private Date slotTime;

    private User user;
}
