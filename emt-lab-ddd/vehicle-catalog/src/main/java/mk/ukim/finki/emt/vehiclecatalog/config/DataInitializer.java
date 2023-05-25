package mk.ukim.finki.emt.vehiclecatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.Brand;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.Vehicle;
import mk.ukim.finki.emt.vehiclecatalog.domain.repository.BrandRepository;
import mk.ukim.finki.emt.vehiclecatalog.domain.repository.VehicleRepository;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final VehicleRepository vehicleRepository;
    private final BrandRepository brandRepository;

    @PostConstruct
    public void initData() {
        Brand brand1 = new Brand("Mercedes");
        Brand brand2 = new Brand("Volkswagen");

        if(brandRepository.findAll().isEmpty()) {
            brandRepository.saveAll(Arrays.asList(brand1,brand2));
        }

        Vehicle vehicle1 = Vehicle.build(brand1.getId(),new VehicleModel(2018,"E63s"), VehicleClass.SPORT, VehicleType.SEDAN, new Fuel(50,new Consumption(15.2)),5);
        Vehicle vehicle2 = Vehicle.build(brand2.getId(),new VehicleModel(2014,"Golf 7"), VehicleClass.ECONOMY, VehicleType.HATCHBACK, new Fuel(40,new Consumption(5.2)),5);

        if(vehicleRepository.findAll().isEmpty()) {
            vehicleRepository.saveAll(Arrays.asList(vehicle1,vehicle2));
        }
    }
}
