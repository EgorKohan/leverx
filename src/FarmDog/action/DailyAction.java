package FarmDog.action;

import FarmDog.entity.Dog;

import java.util.List;
import java.util.concurrent.Phaser;

public interface DailyAction {

    void launchFeeding(Phaser phaser, List<Dog> dogs);

    void launchCheckup(List<Dog> dogs) throws InterruptedException;

    void launchWork(Phaser phaser, List<Dog> dogs);

}
