package com.test.helmes.controllertests;

import com.test.helmes.controllers.UserController;
import com.test.helmes.dtos.LoginResponseDto;
import com.test.helmes.dtos.UserDto;
import com.test.helmes.errors.InvalidDataException;
import com.test.helmes.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * This tests a successful registering.
     */
    @Test
    public void testRegisterUserSuccess() throws Exception {
        UserDto userDto = new UserDto("username", "password", null);
        String successMessage = "Created: username";

        doNothing().when(userService).register(userDto);
        ResponseEntity<?> responseEntity = userController.registerUser(userDto);

        verify(userService, times(1)).register(userDto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertTrue(successMessage.contains(successMessage));
    }

    /**
     * This tests user registering with invalid data.
     */
    @Test
    public void testRegisterUserInvalidData() throws Exception {
        UserDto userDto = new UserDto("invalid_username", "password", null);
        String errorMessage = "Invalid data error message";
        doThrow(new InvalidDataException(errorMessage)).when(userService).register(userDto);

        ResponseEntity<?> responseEntity = userController.registerUser(userDto);

        verify(userService, times(1)).register(userDto);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }

    /**
     * This method tests successful login request.
     */
    @Test
    public void testLoginSuccess() throws Exception {
        UserDto userDto = new UserDto("username", "password", null);
        LoginResponseDto loginResponseDto = new LoginResponseDto("token", "token");
        when(userService.login(userDto)).thenReturn(loginResponseDto);

        ResponseEntity<?> responseEntity = userController.login(userDto);

        verify(userService, times(1)).login(userDto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loginResponseDto, responseEntity.getBody());
    }

    /**
     * Test login with invalid data.
     */
    @Test
    public void testLoginInvalidData() throws Exception {
        UserDto userDto = new UserDto("invalid_username", "password", null);
        String errorMessage = "Invalid data error message";
        when(userService.login(userDto)).thenThrow(new InvalidDataException(errorMessage));

        ResponseEntity<?> responseEntity = userController.login(userDto);

        verify(userService, times(1)).login(userDto);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }

}
