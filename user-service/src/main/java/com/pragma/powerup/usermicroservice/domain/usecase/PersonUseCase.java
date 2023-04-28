package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.exceptions.DomainException;
import com.pragma.powerup.usermicroservice.domain.validations.PersonValid;
import com.pragma.powerup.usermicroservice.domain.model.Person;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonPersistencePort;
import com.pragma.powerup.usermicroservice.domain.api.IPersonServicePort;

public class PersonUseCase implements IPersonServicePort {
    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void savePerson(Person person) {
        if (person.getName() == null || person.getSurname() == null || person.getBirthdate() == null ||
                person.getAddress() == null || person.getMail() == null || person.getDniNumber() == null ||
                person.getPassword() == null) {
            throw new DomainException("All data are required.");
        }
        if (PersonValid.heIsOlder(person)) {
            personPersistencePort.savePerson(person);
        } else {
            throw new DomainException("Tienes que ser mayor de edad");
        }
    }
}
