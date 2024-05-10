package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.ReservationRouter;
import dev.project.restaurantmanagement.Dto.ReservationDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController implements ReservationRouter {
    
    private final ReservationService reservationService;
    
    @Override
    public ResponseEntity<?> postReservation(ReservationDto reservationDto) {
        Response<ReservationDto> createdOrder = reservationService.postReservation(reservationDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getReservations() {
        Response<List<ReservationDto>> reservations = reservationService.getReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getReservationByCode(String code) {
        Response<ReservationDto> getReservationByCode = reservationService.getReservationByCode(code);
        return new ResponseEntity<>(getReservationByCode, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteReservation(Integer id) {
        Response<Void> deleteReservation = reservationService.deleteReservation(id);
        return new ResponseEntity<>(deleteReservation, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateReservation(ReservationDto reservationDto) {
        Response<ReservationDto> updatedReservation = reservationService.updateReservation(reservationDto);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }
}
