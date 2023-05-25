package mk.ukim.finki.emt.rentmanagement.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class RentReservationId extends DomainObjectId {
    private RentReservationId() {
        super(RentReservationDayId.randomId(RentReservationId.class).getId());
    }

    public RentReservationId(@NonNull String uuid) {
        super(uuid);
    }

    public static RentReservationId of(String uuid) {
        RentReservationId p = new RentReservationId(uuid);
        return p;
    }
}
