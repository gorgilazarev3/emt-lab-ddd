package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Vehicle implements ValueObject {

    private final VehicleId id;

    private final VehicleModel vehicleModel;

    private final int numberSeats;

    private final BrandId brandId;

    private final VehicleClass vehicleClass;

    private final VehicleType vehicleType;

    private final Fuel fuel;

    private Vehicle() {
        this.id = VehicleId.randomId(VehicleId.class);
        this.vehicleModel = null;
        this.numberSeats =0;
        this.brandId  = null;
        this.vehicleClass  = null;
        this.vehicleType  = null;
        this.fuel  = null;
    }

    @JsonCreator
    public Vehicle(@JsonProperty("id") VehicleId id,
                   @JsonProperty("vehicleModel") VehicleModel vehicleModel,
                   @JsonProperty("numberSeats") int numberSeats,
                   @JsonProperty("brandId") BrandId brandId,
                   @JsonProperty("vehicleClass") VehicleClass vehicleClass,
                   @JsonProperty("vehicleType") VehicleType vehicleType,
                   @JsonProperty("fuel") Fuel fuel) {
        this.id = id;
        this.vehicleModel = vehicleModel;
        this.numberSeats = numberSeats;
        this.brandId = brandId;
        this.vehicleClass = vehicleClass;
        this.vehicleType = vehicleType;
        this.fuel = fuel;
    }

}
