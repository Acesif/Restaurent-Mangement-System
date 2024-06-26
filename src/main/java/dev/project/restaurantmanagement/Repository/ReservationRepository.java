package dev.project.restaurantmanagement.Repository;

import dev.project.restaurantmanagement.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    Optional<Reservation> findReservationByReservationCode(String code);
}
