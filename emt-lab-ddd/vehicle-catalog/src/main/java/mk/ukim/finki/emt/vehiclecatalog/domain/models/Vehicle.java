package mk.ukim.finki.emt.vehiclecatalog.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.Fuel;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleClass;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleModel;
import mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects.VehicleType;


@Entity
@Table(name = "vehicle")
@Getter
public class Vehicle extends AbstractEntity<VehicleId> {

    @AttributeOverrides({
            @AttributeOverride(name="year", column = @Column(name="model_year")),
            @AttributeOverride(name="model", column = @Column(name="model"))
    })
    private VehicleModel vehicleModel;

    private int numberSeats;

    @AttributeOverride(name = "id", column = @Column(name = "brand_id", nullable = false))
    private BrandId brandId;

    @Enumerated(EnumType.STRING)
    private VehicleClass vehicleClass;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @AttributeOverrides({
            @AttributeOverride(name="capacity", column = @Column(name="fuel_capacity")),
            @AttributeOverride(name="consumption", column = @Column(name="fuel_consumption"))
    })
    private Fuel fuel;

    protected Vehicle() {
        super(DomainObjectId.randomId(VehicleId.class));
    }

    public static Vehicle build(BrandId brandId, VehicleModel vehicleModel, VehicleClass vehicleClass, VehicleType vehicleType, Fuel fuel, int numberSeats) {
        Vehicle v = new Vehicle();
        v.brandId = brandId;
        v.vehicleModel = vehicleModel;
        v.vehicleClass = vehicleClass;
        v.vehicleType = vehicleType;
        v.fuel = fuel;
        v.numberSeats = numberSeats;
        return v;
    }
}
