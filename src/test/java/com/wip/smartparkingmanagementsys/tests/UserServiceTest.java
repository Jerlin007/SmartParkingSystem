package com.wip.smartparkingmanagementsys.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wip.smartparkingmanagementsys.dto.UserDto;
import com.wip.smartparkingmanagementsys.entity.User;
import com.wip.smartparkingmanagementsys.repository.UserRepository;
import com.wip.smartparkingmanagementsys.security.JwtUtil;
import com.wip.smartparkingmanagementsys.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private JwtUtil jwtUtil;
    @Mock private PasswordEncoder passwordEncoder;
    @InjectMocks private UserServiceImpl userService;

    @Test
    void login_validCredentials_returnsTokenAndRole() {
        User user = new User();
        user.setEmail("ram@gmail.com");
        user.setPassword("encodedPass");
        user.setRole("USER");

        when(userRepository.findByEmail("ram@gmail.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password123", "encodedPass")).thenReturn(true);
        when(jwtUtil.generateToken("ram@gmail.com")).thenReturn("mockToken");

        UserDto result = userService.login("ram@gmail.com", "password123");

        assertNotNull(result);
        assertEquals("mockToken", result.getToken());
        assertEquals("USER", result.getRole());
    }

    @Test
    void login_invalidEmail_throwsException() {
        when(userRepository.findByEmail("wrong@gmail.com")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            userService.login("wrong@gmail.com", "password123"));
    }

    @Test
    void login_wrongPassword_throwsException() {
        User user = new User();
        user.setEmail("ram@gmail.com");
        user.setPassword("encodedPass");

        when(userRepository.findByEmail("ram@gmail.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpass", "encodedPass")).thenReturn(false);

        assertThrows(RuntimeException.class, () ->
            userService.login("ram@gmail.com", "wrongpass"));
    }
}
