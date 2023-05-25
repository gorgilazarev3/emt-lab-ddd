package mk.ukim.finki.emt.vehiclecatalog.services;

import mk.ukim.finki.emt.vehiclecatalog.domain.models.Vehicle;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.VehicleId;
import mk.ukim.finki.emt.vehiclecatalog.services.forms.VehicleForm;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Optional<Vehicle> findById(VehicleId id);
    Vehicle createVehicle(VehicleForm vehicleForm);
    List<Vehicle> findAll();
}
