package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.concurrent.atomic.AtomicLong;

public class AnimalService {
    private static AtomicLong idCounter = new AtomicLong();
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getById(long id) {
        return animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Animal not exist!"));
    }

    public Animal add(String type, String name) {
        Animal animal = new Animal(idCounter.getAndIncrement(), type, name);
        return animalRepository.add(animal);
    }
}
