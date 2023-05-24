package mk.ukim.finki.emt.usermanagement.domain.valueobjects;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Email implements ValueObject {
    private final String email;

    protected Email() {
        this.email = null;
    }
    public Email(@NonNull String email) {
        this.email = email;
    }
}
