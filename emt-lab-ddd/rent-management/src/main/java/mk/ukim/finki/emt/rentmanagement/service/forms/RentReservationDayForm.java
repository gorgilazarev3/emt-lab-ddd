package mk.ukim.finki.emt.rentmanagement.service.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Vehicle;

import java.time.LocalDate;

@Data
public class RentReservationDayForm {
    @NotNull
    private Vehicle vehicle;

    @NotNull
    private Money pricePerDay;

    @NotNull
    private LocalDate rentReservationDayDate;
}
