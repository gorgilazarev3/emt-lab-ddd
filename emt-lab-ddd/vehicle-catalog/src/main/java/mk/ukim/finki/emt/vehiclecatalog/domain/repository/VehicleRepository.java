package mk.ukim.finki.emt.vehiclecatalog.domain.repository;

import mk.ukim.finki.emt.vehiclecatalog.domain.models.Vehicle;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.VehicleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, VehicleId> {
}
