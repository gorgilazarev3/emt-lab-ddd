package mk.ukim.finki.emt.rentmanagement.domain.models;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationDayIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Location;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ReservationState;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.UserId;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Vehicle;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rent_reservation")
public class RentReservation extends AbstractEntity<RentReservationId> {
    @AttributeOverride(name="id", column = @Column(name="user_id"))
    private UserId userId;

    private LocalDate reservationStartDate;

    private LocalDate reservationEndDate;

    @Column(name = "rent_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private ReservationState reservationState;

    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="pickup_latitude")),
            @AttributeOverride(name="longitude", column = @Column(name="pickup_longitude")),
            @AttributeOverride(name="address", column = @Column(name="pickup_address"))
    })
    private Location pickupLocation;

    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="dropoff_latitude")),
            @AttributeOverride(name="longitude", column = @Column(name="dropoff_longitude")),
            @AttributeOverride(name="address", column = @Column(name="dropoff_address"))
    })
    private Location dropOffLocation;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="total_amount")),
            @AttributeOverride(name="currency", column = @Column(name="currency")),
    })

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentReservationDay> reservationDays = new HashSet<>();;

    public Money totalPrice() {
        return reservationDays.stream().map(RentReservationDay::totalPricePerDay).reduce(new Money(currency, 0),Money::add);
    }

    public RentReservationDay addReservationDayForRent(@NonNull Vehicle vehicle, Money pricePerDay, LocalDate reservationDayDate) {
        RentReservationDay reservationDay = new RentReservationDay(vehicle.getId(), pricePerDay, reservationDayDate);
        reservationDays.add(reservationDay);
        return reservationDay;
    }

    public void cancelReservationDayForRent(@NonNull RentReservationDayId rentReservationDayId) {
        reservationDays.removeIf(d -> d.getId().equals(rentReservationDayId));
    }

    public RentReservationDay getRentReservationDayById(@NonNull RentReservationDayId rentReservationDayId) {
        return reservationDays.stream().filter(rd -> rd.getId().equals(rentReservationDayId)).findFirst().orElseThrow(ReservationDayIdNotExistException::new);
    }

    public Set<RentReservationDay> getReservationDays() {
        return reservationDays;
    }

    protected RentReservation() {
        super(DomainObjectId.randomId(RentReservationId.class));
    }

    public RentReservation(UserId userId, LocalDate reservationStartDate, LocalDate reservationEndDate, Location pickupLocation, Location dropOffLocation, Currency currency) {
        super(DomainObjectId.randomId(RentReservationId.class));
        this.userId = userId;
        if(!reservationStartDate.isBefore(reservationEndDate)) {
            throw new IllegalArgumentException();
        }
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.currency = currency;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.reservationDays = new HashSet<>();
    }
}
