package FarmDog;

import FarmDog.entity.Dog;
import FarmDog.entity.DogBreed;
import FarmDog.entity.DogState;
import FarmDog.entity.FarmDog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class FarmDogRunner {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Бивень", 3, DogBreed.BULLDOG));
        dogs.add(new Dog("Сахарок", 1, DogBreed.SHEPHERD));
        Dog dog1 = new Dog("Рэнж Ровер", 6, DogBreed.LABRADOR);
        dog1.getState().setHealthy(false);
        dogs.add(dog1);
        FarmDog farmDog = new FarmDog();
        farmDog.setDogs(dogs);
        farmDog.launchWorkday();
    }
}
