package mk.ukim.finki.emt.vehiclecatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.Vehicle;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.VehicleId;
import mk.ukim.finki.emt.vehiclecatalog.domain.repository.VehicleRepository;
import mk.ukim.finki.emt.vehiclecatalog.services.VehicleService;
import mk.ukim.finki.emt.vehiclecatalog.services.forms.VehicleForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> findById(VehicleId id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle createVehicle(VehicleForm vehicleForm) {
        Vehicle v = Vehicle.build(vehicleForm.getBrandId(), vehicleForm.getVehicleModel(), vehicleForm.getVehicleClass(), vehicleForm.getVehicleType(), vehicleForm.getFuel(), vehicleForm.getNumberSeats());
        vehicleRepository.saveAndFlush(v);
        return v;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
