package petStore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class PetStoreTests {
    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal("Dog", 5, 100.00);
    }

    // 1. Test if the returned list is unmodifiable
    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ShouldReturn_UnmodifiableList() {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    // 2. Test if the returned list size is correct
    @Test
    public void test_GetCount_ShouldReturn_CorrectSize() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);     // Dog, 5, 100.00
        assertEquals(1, petStore.getCount());
    }

    // 3.1 Test if the method returns empty list when the given kgs are higher than any animals kg
    @Test
    public void test_FindAllAnimalsWithMaxKilograms_ShouldReturnEmptyList_WhenNoSuchAnimal_HasHigherKgs_ThanGiven() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(20);
        assertTrue(animals.isEmpty());
    }

    // 3.2. Test if the method returns the correct elements
    @Test
    public void test_FindAllAnimalsWithMaxKilograms_ShouldReturn_FilteredAnimals() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        petStore.addAnimal(new Animal("Cat", 3, 78.50));
        petStore.addAnimal(new Animal("Mouse", 1, 50.50));

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(2);

        assertEquals(2, animals.size());
    }

    // 4.1 Test addAnimal with passing null
    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimal_ThrowsException_WhenPassingNull() {
        petStore.addAnimal(null);
    }

    // 4.2. Test addAnimal - Happy path
    @Test
    public void test_AddAnimal() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        assertEquals(1, petStore.getCount());

        petStore.addAnimal(new Animal("Cat", 3, 78.50));
        petStore.addAnimal(new Animal("Mouse", 1, 50.50));

        List<Animal> animals = petStore.getAnimals();
        String[] species = {"Dog", "Cat", "Mouse"};

        for (int i = 0; i < animals.size(); i++) {
            assertEquals(species[i], animals.get(i).getSpecie());
        }
    }

    // 5.1. Test if this method will return the most expensive animal
    @Test
    public void test_GetTheMostExpensiveAnimal() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        petStore.addAnimal(new Animal("Cat", 3, 78.50));
        petStore.addAnimal(new Animal("Mouse", 1, 50.50));

        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();

        assertEquals(100.00, mostExpensiveAnimal.getPrice(), 0.00);
    }

    // 5.2. Test if this method will return null with empty list
    @Test
    public void test_test_GetTheMostExpensiveAnimal_ShouldReturnNull_WhenCollectionIsEmpty() {
        assertEquals(0, petStore.getCount());
        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        assertNull(mostExpensiveAnimal);
    }

    // 6.1 Test if the method returns empty list when there is no such speice
    @Test
    public void test_FindAllAnimalBySpecie_ShouldReturnEmptyList_WhenNoSuchSpecie() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        List<Animal> animals = petStore.findAllAnimalBySpecie("Cat");
        assertTrue(animals.isEmpty());
    }

    // 6.2. Test if the method returns the correct elements
    @Test
    public void test_FindAllAnimalBySpecie_ShouldReturn_FilteredAnimals() {
        petStore.addAnimal(animal); // Dog, 5, 100.00
        petStore.addAnimal(new Animal("Cat", 3, 78.50));
        petStore.addAnimal(new Animal("Mouse", 1, 50.50));
        petStore.addAnimal(new Animal("Cat", 4, 99.50));

        List<Animal> animals = petStore.findAllAnimalBySpecie("Cat");

        assertEquals(2, animals.size());
        assertEquals("Cat", animals.get(0).getSpecie());
    }
}

