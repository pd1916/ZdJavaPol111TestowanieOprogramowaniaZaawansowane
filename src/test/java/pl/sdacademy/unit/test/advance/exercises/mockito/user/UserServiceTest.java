package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final User USER = new User(1L, "Jan", "Nowak");

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserValidator userValidator;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnCorrectUserById() {
        //given
        //Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user)); // any() -> dowolony argument/parametr
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(USER));
        //when
        User result = userService.getUserById(1L);
        //then
        assertThat(result).isEqualTo(USER);
        //assertThat(result.getLastName()).isEqualTo("Nowak");
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> userService.getUserById(1L))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldCreateUser() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(true);
        Mockito.when(userRepository.addUser(any())).thenReturn(USER);
        //when
        User result = userService.createUser(USER);
        //then
        assertThat(result).isEqualTo(USER);
    }

    @Test
    void shouldThrowExceptionWhenUserInNotValid() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(false);
        //when & then
        assertThatThrownBy(() -> userService.createUser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User is invalid");
        verifyNoInteractions(userRepository);
    }
}