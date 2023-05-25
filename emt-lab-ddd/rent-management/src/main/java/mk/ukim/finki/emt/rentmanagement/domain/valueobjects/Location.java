package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
public class Location implements ValueObject {

    private final String address;

    private final double latitude;

    private final double longitude;

    protected Location() {
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.address = null;
    }

    public Location(String address, @NonNull double latitude, @NonNull double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
