package mk.ukim.finki.emt.rentmanagement.domain.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ExtraFeatureDescription;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.VehicleId;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rent_reservation_day")
public class RentReservationDay extends AbstractEntity<RentReservationDayId> {

    @AttributeOverride(name = "id", column = @Column(name = "vehicle_id", nullable = false))
    private VehicleId vehicleId;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ExtraFeature> extraFeatures = new HashSet<>();

    private Money pricePerDay;

    private LocalDate reservationDayDate;
}
