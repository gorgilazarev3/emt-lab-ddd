package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
public class Location implements ValueObject {

    private final double latitude;

    private final double longitude;

    protected Location() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Location(@NonNull double latitude, @NonNull double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
