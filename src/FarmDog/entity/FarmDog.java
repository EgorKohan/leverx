package FarmDog.entity;

import FarmDog.action.DailyActionImpl;

import java.util.List;
import java.util.concurrent.Phaser;

public class FarmDog {
    private List<Dog> dogs;
    private final DailyActionImpl dailyAction = new DailyActionImpl();

    public void launchWorkday() {
        Phaser phaser = new Phaser(dogs.size());
        phaser.register();
        System.out.println("Начало дня: ");
        try {
            dailyAction.launchFeeding(phaser, dogs);
            dailyAction.launchCheckup(dogs);
            Thread.sleep(2000);
            dailyAction.launchWork(phaser, dogs);
            Thread.sleep(2000);
            dailyAction.launchFeeding(phaser, dogs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец дня");
        phaser.arriveAndDeregister();
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
