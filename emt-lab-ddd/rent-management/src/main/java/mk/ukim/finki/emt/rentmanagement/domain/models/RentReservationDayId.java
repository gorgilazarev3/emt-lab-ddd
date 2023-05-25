package mk.ukim.finki.emt.rentmanagement.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class RentReservationDayId extends DomainObjectId {
    private RentReservationDayId() {
        super(RentReservationDayId.randomId(RentReservationDayId.class).getId());
    }

    public RentReservationDayId(@NonNull String uuid) {
        super(uuid);
    }

    public static RentReservationDayId of(String uuid) {
        RentReservationDayId p = new RentReservationDayId(uuid);
        return p;
    }
}
