package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.*;
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



}
