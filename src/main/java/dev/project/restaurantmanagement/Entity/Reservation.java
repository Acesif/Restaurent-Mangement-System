package dev.project.restaurantmanagement.Entity;

import dev.project.restaurantmanagement.Dto.ReservationDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "reservation",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"resv_id"})}
)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resv_id", nullable = false)
    private String reservationCode;

    @Column(name = "num_people", nullable = false)
    private Integer amountOfPeople;

    @Column(name = "slot", nullable = false)
    private Date slotTime;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public ReservationDto getReservationDto(){
        return ReservationDto.builder()
                .id(id)
                .reservationCode(reservationCode)
                .amountOfPeople(amountOfPeople)
                .slotTime(slotTime)
                .user_id(user.getId())
                .build();
    }
}
