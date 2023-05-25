package mk.ukim.finki.emt.rentmanagement.domain.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ExtraFeatureDescription;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.VehicleId;

import java.time.LocalDate;
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

    public Money totalPricePerDay() {
        return extraFeatures.stream().map(ExtraFeature::getExtraFeaturePrice).reduce(new Money(pricePerDay.getCurrency(), pricePerDay.getAmount()),Money::add);
    }

    public ExtraFeature addExtraFeatureOnDay(@NonNull ExtraFeatureDescription extraFeatureDescription, @NonNull Money priceForExtraFeature) {
        ExtraFeature extraFeature = new ExtraFeature(extraFeatureDescription,priceForExtraFeature);
        extraFeatures.add(extraFeature);
        return extraFeature;
    }

    public void removeExtraFeatureOnDay(@NonNull ExtraFeatureId extraFeatureId) {
        extraFeatures.removeIf(ef -> ef.getId().equals(extraFeatureId));
    }

    protected RentReservationDay() {
        super(DomainObjectId.randomId(RentReservationDayId.class));
    }

    public RentReservationDay(VehicleId vehicleId, Money pricePerDay, LocalDate reservationDayDate) {
        super(DomainObjectId.randomId(RentReservationDayId.class));
        this.vehicleId = vehicleId;
        this.pricePerDay = pricePerDay;
        this.reservationDayDate = reservationDayDate;
    }
}
