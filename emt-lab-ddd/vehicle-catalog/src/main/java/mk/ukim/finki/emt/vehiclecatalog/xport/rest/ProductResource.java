package mk.ukim.finki.emt.vehiclecatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.Vehicle;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.VehicleId;
import mk.ukim.finki.emt.vehiclecatalog.services.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.RuntimeErrorException;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@AllArgsConstructor
public class ProductResource {

    private  final VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable String id) {
        return vehicleService.findById(VehicleId.of(id)).orElseThrow(IllegalArgumentException::new);
    }
}
