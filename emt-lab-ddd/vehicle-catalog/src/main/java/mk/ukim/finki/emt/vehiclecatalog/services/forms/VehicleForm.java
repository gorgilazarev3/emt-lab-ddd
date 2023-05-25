package mk.ukim.finki.emt.vehiclecatalog.services.forms;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.BrandId;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.Fuel;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleClass;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleModel;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleType;

@Data
public class VehicleForm {
    @NotNull
    private BrandId brandId;
    @NotNull
    private VehicleModel vehicleModel;
    @NotNull
    private int numberSeats;
    @NotNull
    private VehicleClass vehicleClass;
    @NotNull
    private VehicleType vehicleType;
    @NotNull
    private Fuel fuel;
}
