package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;


public class VehicleId extends DomainObjectId {
    private VehicleId() {
        super(VehicleId.randomId(VehicleId.class).getId());
    }

    public VehicleId(@NonNull String uuid) {
        super(uuid);
    }

    public static VehicleId of(String uuid) {
        VehicleId p = new VehicleId(uuid);
        return p;
    }
}
