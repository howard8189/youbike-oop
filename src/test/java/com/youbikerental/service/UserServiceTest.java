package com.youbikerental.service;

import static org.mockito.Mockito.*;

import com.youbikerental.model.User;
import com.youbikerental.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() {
        User newUser = new User();
        newUser.setPassword("rawPassword");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        User savedUser = userService.registerUser(newUser);
        verify(userRepository).save(newUser);
        assert savedUser.getPassword().equals("encodedPassword");
    }
}
