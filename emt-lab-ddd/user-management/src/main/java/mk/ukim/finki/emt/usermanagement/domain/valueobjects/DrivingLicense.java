package mk.ukim.finki.emt.usermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class DrivingLicense implements ValueObject {
    private final String drivingLicenseNumber;

    protected DrivingLicense() {
        this.drivingLicenseNumber = null;
    }

    public DrivingLicense(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
