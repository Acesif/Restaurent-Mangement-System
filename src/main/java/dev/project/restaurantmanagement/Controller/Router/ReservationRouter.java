package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.ReservationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ReservationRouter {

    @PostMapping
    ResponseEntity<?> postReservation(@RequestBody ReservationDto reservationDto);

    @GetMapping
    ResponseEntity<?> getReservations();

    @GetMapping("/res_{code}")
    ResponseEntity<?> getReservationByCode(@PathVariable("code") String code);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteReservation(@PathVariable("id") Integer id);

    @PutMapping
    ResponseEntity<?> updateReservation(@RequestBody ReservationDto reservationDto);
}
