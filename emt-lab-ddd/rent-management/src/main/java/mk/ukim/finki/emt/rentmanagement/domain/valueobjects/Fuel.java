package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;


@Getter
public class Fuel implements ValueObject {

    private final int capacity;

    @Embedded
    private final Consumption consumption;

    protected Fuel() {
        capacity = 0;
        consumption = null;
    }

    public Fuel(@NonNull int capacity, @NonNull Consumption consumption) {
        this.capacity = capacity;
        this.consumption = consumption;
    }

    public Fuel increaseCapacity(int increase) {
        return new Fuel(getCapacity()+increase,getConsumption());
    }

    public Fuel decreaseCapacity(int decrease) {
        return new Fuel(getCapacity()-decrease,getConsumption());
    }
}
