package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String place;

    private final String country;

    private final String address;

    private final int postalCode;

    protected Address() {
        this.place = null;
        this.country = null;
        this.address = null;
        this.postalCode = 0;
    }

    public Address(@NonNull String place, @NonNull String country, @NonNull String address, @NonNull int postalCode) {
        this.place = place;
        this.country = country;
        this.address = address;
        this.postalCode = postalCode;
    }
}
