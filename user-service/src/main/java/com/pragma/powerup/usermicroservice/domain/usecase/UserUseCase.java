package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.UserValid;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        if (user.getName() == null || user.getSurname() == null || user.getBirthdate() == null ||
                user.getMail() == null || user.getDniNumber() == null ||
                user.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"All data are required.");
        }
        if (UserValid.heIsOlder(user)) {
            userPersistencePort.saveUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tienes que ser mayor de edad");
        }
    }

    @Override
    public void deleteUser(User user) {
        userPersistencePort.deleteUser(user);
    }

    @Override
    public List<User> getAllProviders(int page) {
        return userPersistencePort.getAllProviders(page);
    }

    @Override
    public User getProvider(Long id) {
        return userPersistencePort.getProvider(id);
    }

    @Override
    public User getOwner(Long id) {
        return userPersistencePort.getOwner(id);
    }

    @Override
    public User getEmployee(Long id) {
        return userPersistencePort.getEmployee(id);
    }

    @Override
    public User getClient(Long id) {
        return userPersistencePort.getClient(id);
    }
}
