package mk.ukim.finki.emt.vehiclecatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class VehicleModel implements ValueObject {

    private final int year;

    private final String model;

    protected VehicleModel() {
        this.year = 0;
        this.model = null;
    }

    public VehicleModel(@NonNull int year, @NonNull String model) {
        this.year = year;
        this.model = model;
    }

    public VehicleModel valueOf(int year, String model) {
        return new VehicleModel(year,model);
    }

    public VehicleModel changeYear(int newYear) {
        return new VehicleModel(newYear,getModel());
    }

    public VehicleModel changeModel(String newModel) {
        return new VehicleModel(getYear(),newModel);
    }
}
