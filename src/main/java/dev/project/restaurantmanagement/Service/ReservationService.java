package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.ReservationDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Entity.Order;
import dev.project.restaurantmanagement.Entity.Reservation;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Repository.ReservationRepository;
import dev.project.restaurantmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public Response<ReservationDto> postReservation(ReservationDto reservationDto){
        User customer = userRepository.findById(reservationDto.getUser_id()).orElseThrow();
        Reservation reservation = Reservation.builder()
                .reservationCode(reservationDto.getReservationCode())
                .amountOfPeople(reservationDto.getAmountOfPeople())
                .slotTime(reservationDto.getSlotTime())
                .user(customer)
                .build();

        Reservation savedReservation = reservationRepository.save(reservation);

        return Response.<ReservationDto>builder()
                .isSuccess(true)
                .code(201)
                .message("Spot reserved successfully")
                .values(ReservationDto.builder()
                        .id(savedReservation.getId())
                        .reservationCode(savedReservation.getReservationCode())
                        .amountOfPeople(savedReservation.getAmountOfPeople())
                        .slotTime(savedReservation.getSlotTime())
                        .user_id(savedReservation.getUser().getId())
                        .build()
                )
                .build();
    }

    public Response<List<ReservationDto>> getReservations(){
        List<Reservation> reservationList = reservationRepository.findAll();
        return Response.<List<ReservationDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("Reservations successfully fetched")
                .values(reservationList.stream().map(Reservation::getReservationDto).collect(Collectors.toList()))
                .build();
    }
    public Response<ReservationDto> getReservationByCode(String code){
        Reservation reservation = reservationRepository.findReservationByReservationCode(code).orElseThrow();

        return Response.<ReservationDto>builder()
                .isSuccess(true)
                .code(200)
                .message("Reservation "+ code +" successfully fetched")
                .values(ReservationDto.builder()
                        .id(reservation.getId())
                        .reservationCode(reservation.getReservationCode())
                        .amountOfPeople(reservation.getAmountOfPeople())
                        .slotTime(reservation.getSlotTime())
                        .user_id(reservation.getUser().getId())
                        .build()
                )
                .build();
    }

    public Response<Void> deleteReservation(Integer id){
        reservationRepository.deleteById(id);
        return Response.<Void>builder()
                .isSuccess(true)
                .code(200)
                .message("Reservation deleted successfully")
                .values(null)
                .build();
    }
    public Response<ReservationDto> updateReservation(ReservationDto reservationDto){
        Reservation reservation = reservationRepository.findReservationByReservationCode(reservationDto.getReservationCode()).orElseThrow();
        User updatedUser = userRepository.findById(reservationDto.getUser_id()).orElseThrow();

        reservation.setUser(updatedUser);
        reservation.setSlotTime(reservationDto.getSlotTime());
        reservation.setAmountOfPeople(reservationDto.getAmountOfPeople());

        reservationRepository.save(reservation);

        return Response.<ReservationDto>builder()
                .isSuccess(true)
                .code(201)
                .message("Reservation successfully updated")
                .values(ReservationDto.builder()
                        .id(reservation.getId())
                        .reservationCode(reservation.getReservationCode())
                        .amountOfPeople(reservation.getAmountOfPeople())
                        .slotTime(reservation.getSlotTime())
                        .user_id(reservation.getUser().getId())
                        .build())
                .build();
    }
    
}
