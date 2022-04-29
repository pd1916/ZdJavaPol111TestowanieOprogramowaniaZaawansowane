package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Animal ANIMAL = new Animal(1L, "cat", "Filemon");
    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldAddNewAnimal() {
        //given
        Mockito.when(animalRepository.add(any())).thenReturn(ANIMAL);
        //when
        Animal result = animalService.add("cat", "Filemon");
        //then
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldGetAnimalById() {
        //given
        Mockito.when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(1L);
        //then
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldThrowWhenAnimalDoesNotExist() {
        //given
        Mockito.when(animalRepository.findById(2L)).thenReturn(Optional.empty());
        //when&then
        assertThatThrownBy(
                () -> animalService.getById(2L))
                .isInstanceOf(IllegalArgumentException.class);
        verifyNoMoreInteractions(animalRepository); // możemy sprawdzić czy na pewno nie doszło do próby zapisu rekordu
    }

}