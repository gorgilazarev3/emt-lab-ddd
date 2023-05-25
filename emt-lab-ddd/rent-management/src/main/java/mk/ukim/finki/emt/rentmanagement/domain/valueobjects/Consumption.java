package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;


@Getter
public class Consumption implements ValueObject {
    //Consumption is measured in l/100km
    private final double consumption;

    protected Consumption() {
        this.consumption = 0.0;
    }

    public Consumption(@NonNull double consumption) {
        this.consumption = consumption;
    }

    public double consumptionInLitersPer100Kilometers() {
        return consumption;
    }

    public double consumptionInMilesPerGallon() {
        return 235.215/consumption;
    }

    public Consumption increase(double increase) {
        return new Consumption(getConsumption()+increase);
    }

    public Consumption decrease(double decrease) {
        return new Consumption(getConsumption()-decrease);
    }
}
