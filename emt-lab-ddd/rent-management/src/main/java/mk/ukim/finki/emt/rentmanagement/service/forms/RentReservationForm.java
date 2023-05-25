package mk.ukim.finki.emt.rentmanagement.service.forms;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Location;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.UserId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
public class RentReservationForm {

    @NotNull
    private UserId userId;

    @NotNull
    private LocalDate reservationStartDate;

    @NotNull
    private LocalDate reservationEndDate;

    @NotNull
    private Currency currency;

    @NotNull
    private Location pickupLocation;

    @NotNull
    private Location dropOffLocation;

    @NotEmpty
    @Valid
    private List<RentReservationDayForm> rentReservationDaysList = new ArrayList<>();
}
