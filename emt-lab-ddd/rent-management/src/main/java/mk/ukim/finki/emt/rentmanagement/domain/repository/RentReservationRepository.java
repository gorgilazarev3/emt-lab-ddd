package mk.ukim.finki.emt.rentmanagement.domain.repository;

import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservation;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentReservationRepository extends JpaRepository<RentReservation, RentReservationId> {
}
