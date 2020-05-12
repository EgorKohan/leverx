package FarmDog.action;

import FarmDog.entity.Dog;

public interface WorkingAction {

    boolean startTraining(Dog dog) throws InterruptedException;

    boolean startWorking(Dog dog) throws InterruptedException;

    boolean stayInTheAviary(Dog dog) throws InterruptedException;

}
