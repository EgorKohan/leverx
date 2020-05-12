package FarmDog.action;

import FarmDog.entity.Dog;

import java.util.List;

public interface VeterinaryAction {

    boolean heal(Dog dog);

    void launchCheckup(Dog dog) throws InterruptedException;

}
