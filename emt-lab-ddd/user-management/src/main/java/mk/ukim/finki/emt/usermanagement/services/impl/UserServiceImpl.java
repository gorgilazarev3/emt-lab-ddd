package mk.ukim.finki.emt.usermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.models.User;
import mk.ukim.finki.emt.usermanagement.domain.models.UserId;
import mk.ukim.finki.emt.usermanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.usermanagement.services.UserService;
import mk.ukim.finki.emt.usermanagement.services.forms.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(UserId id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(UserForm userForm) {
        User u = User.build(userForm.getName(), userForm.getSurname(), userForm.getAge(), userForm.getTelephoneNumber(), userForm.getEmail(), userForm.getDrivingLicense());
        userRepository.saveAndFlush(u);
        return u;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
