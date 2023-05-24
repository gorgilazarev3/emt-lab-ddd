package mk.ukim.finki.emt.usermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class TelephoneNumber implements ValueObject {
    private final String telephoneNumber;

    protected TelephoneNumber() {
        this.telephoneNumber = null;
    }
    public TelephoneNumber(@NonNull String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
