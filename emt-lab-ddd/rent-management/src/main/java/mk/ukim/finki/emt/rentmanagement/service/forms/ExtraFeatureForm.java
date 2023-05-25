package mk.ukim.finki.emt.rentmanagement.service.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.ExtraFeatureDescription;

@Data
public class ExtraFeatureForm {
    @NotNull
    private ExtraFeatureDescription extraFeatureDescription;

    @NotNull
    private Money priceForFeaturePerDay;
}
