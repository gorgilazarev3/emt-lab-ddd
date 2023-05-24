package mk.ukim.finki.emt.rentmanagement.domain.valueobjects;

import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

public enum ReservationState implements ValueObject {
    RECEIVED, SCHEDULED, STARTED, FINISHED, CANCELLED
}
