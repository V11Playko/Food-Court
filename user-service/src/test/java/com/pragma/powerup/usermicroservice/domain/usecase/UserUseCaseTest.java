package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserUseCaseTest {
    @Mock
    private IUserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        User user = DomainDataTest.obtainUser();

        assertEquals("ADMIN", user.getRole().getName());
        assertDoesNotThrow(() ->userUseCase.saveUser(user));

    }

    @Test
    void deleteUser() {
        User user = DomainDataTest.obtainUser();
        userUseCase.deleteUser(user);

        verify(userPersistencePort).deleteUser(user);
    }

    @Test
    void roleFindByUserIdTest() {
        Long id = 1L;
        User user = DomainDataTest.obtainUser();

        when(userPersistencePort.getProvider(id)).thenReturn(user);

        assertEquals(1, id);
    }
}