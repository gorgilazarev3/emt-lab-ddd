package mk.ukim.finki.emt.usermanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.DrivingLicense;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.usermanagement.domain.valueobjects.TelephoneNumber;

@Entity
@Table(name = "rent_user")
public class User extends AbstractEntity<UserId> {
    private String name;
    private String surname;
    private int age;
    private TelephoneNumber telephoneNumber;
    private Email email;
    private DrivingLicense drivingLicense;
}
