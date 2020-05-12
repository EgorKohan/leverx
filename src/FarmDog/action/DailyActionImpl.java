package FarmDog.action;

import FarmDog.entity.Dog;

import java.util.List;
import java.util.concurrent.Phaser;

public class DailyActionImpl implements DailyAction {

    @Override
    public void launchFeeding(Phaser phaser, List<Dog> dogs) {
        FeedingActionImpl feed = new FeedingActionImpl();
        System.out.println("Кормежка: ");
        for (Dog dog : dogs) {
            new Thread(() -> {
                try {
                    feed.launchFeeding(dog);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
        phaser.arriveAndAwaitAdvance();
    }

    @Override
    public void launchCheckup(List<Dog> dogs) {
        VeterinaryActionImpl vet = new VeterinaryActionImpl();
        System.out.println("Медосмотр: ");
        for (Dog dog : dogs) {
            try {
                vet.launchCheckup(dog);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void launchWork(Phaser phaser, List<Dog> dogs) {
        WorkingActionImpl workingAction = new WorkingActionImpl();
        System.out.println("Чистка вольеров/Тренировка/Работа");
        for (Dog dog : dogs) {
            new Thread(() -> {
                try {
                    if (dog.getAge() <= 1) workingAction.startTraining(dog);
                    else if (dog.getAge() > 1 && dog.getAge() < 5) workingAction.startWorking(dog);
                    else workingAction.stayInTheAviary(dog);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
        phaser.arriveAndAwaitAdvance();
    }

}
