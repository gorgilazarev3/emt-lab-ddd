package mk.ukim.finki.emt.usermanagement.services;

import mk.ukim.finki.emt.usermanagement.domain.models.User;
import mk.ukim.finki.emt.usermanagement.domain.models.UserId;
import mk.ukim.finki.emt.usermanagement.services.forms.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(UserId id);
    User createUser(UserForm userForm);
    List<User> findAll();
}
