package FarmDog.action;

import FarmDog.entity.Dog;

public interface FeedingAction {

    boolean feed(Dog dog);

    void launchFeeding(Dog dog) throws InterruptedException;

}
