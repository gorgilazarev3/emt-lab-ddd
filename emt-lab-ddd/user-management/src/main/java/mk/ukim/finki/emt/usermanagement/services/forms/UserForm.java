package mk.ukim.finki.emt.usermanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.DrivingLicense;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.TelephoneNumber;
import jakarta.validation.constraints.NotNull;

@Data
public class UserForm {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private int age;
    @NotNull
    private TelephoneNumber telephoneNumber;
    @NotNull
    private Email email;
    @NotNull
    private DrivingLicense drivingLicense;
}
