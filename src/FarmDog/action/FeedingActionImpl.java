package FarmDog.action;

import FarmDog.entity.Dog;

import java.util.Random;

public class FeedingActionImpl implements FeedingAction {

    @Override
    public boolean feed(Dog dog) {
        if (dog.getState().isHungry()) {
            dog.getState().setHungry(false);
            return true;
        }
        return false;
    }

    @Override
    public void launchFeeding(Dog dog) throws InterruptedException {
        //Использую как имитацию деления рациона: щенки питаются меньше и быстрее, остальные дольше и тд
        int feedingLength = 1000;
        if (dog.getAge() > 1) feedingLength = 2000;
        if (dog.getAge() > 5) feedingLength = 3000;
        Thread.sleep(new Random().nextInt(1000) + feedingLength);
        System.out.println(feed(dog) ?
                "Собака " + dog.getName() + " накормлена" :
                "Собака " + dog.getName() + " не голодна");
    }

}
