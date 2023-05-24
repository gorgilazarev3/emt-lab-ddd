package mk.ukim.finki.emt.rentmanagement.domain.models;

import jakarta.persistence.*;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Location;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ReservationState;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.UserId;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "rent_reservation")
public class RentReservation extends AbstractEntity<RentReservationId> {
    @AttributeOverride(name="id", column = @Column(name="user_id"))
    private UserId userId;

    private LocalDate reservationStartDate;

    private LocalDate reservationEndDate;

    @Enumerated(EnumType.STRING)
    private ReservationState reservationState;

    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="pickup_latitude")),
            @AttributeOverride(name="longitude", column = @Column(name="pickup_longitude")),
    })
    private Location pickupLocation;

    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="dropoff_latitude")),
            @AttributeOverride(name="longitude", column = @Column(name="dropoff_longitude")),
    })
    private Location dropOffLocation;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="total_amount")),
            @AttributeOverride(name="currency", column = @Column(name="currency")),
    })
    private Money totalPrice;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentReservationDay> reservationDays;
}
