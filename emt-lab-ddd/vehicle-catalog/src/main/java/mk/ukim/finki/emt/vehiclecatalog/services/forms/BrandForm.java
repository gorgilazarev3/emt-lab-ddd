package mk.ukim.finki.emt.vehiclecatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.vehiclecatalog.domain.models.BrandId;
import jakarta.validation.constraints.*;

@Data
public class BrandForm {
    @NotNull
    private String brandName;
}
