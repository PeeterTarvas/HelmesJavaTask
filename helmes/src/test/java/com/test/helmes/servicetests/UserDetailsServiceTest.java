package com.test.helmes.servicetests;


import com.test.helmes.dbos.UserDbo;
import com.test.helmes.dtos.UserDto;
import com.test.helmes.repositories.UserRepository;
import com.test.helmes.services.ConverterService;
import com.test.helmes.services.UserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class tests UserDetailsService service class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserDetailsServiceTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ConverterService converterService;

    @BeforeEach
    public void setUp() {
        Mockito.reset(userRepository);
        Mockito.reset(converterService);
    }

    /**
     * This tests loading a user by username when the user exists.
     */
    @Test
    public void testLoadUserByUsernameUserExists() {
        String username = "testUser";
        UserDbo userDbo = new UserDbo(1L, username, "password");

        when(userRepository.getUserDboByUsername(username)).thenReturn(Optional.of(userDbo));
        when(converterService.convertToUserDto(userDbo)).thenReturn(new UserDto(username, "password", null));

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
    }

    /**
     *  Tests loading user by a username that does not exist.
     */
    @Test
    public void testLoadUserByUsernameUserDoesNotExist() {
        String username = "nonExistentUser";

        when(userRepository.getUserDboByUsername(username)).thenReturn(Optional.empty());

        UsernameNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(username)
        );
        assertEquals("No user found", exception.getMessage());
    }

}
