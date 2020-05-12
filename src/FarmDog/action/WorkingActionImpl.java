package FarmDog.action;

import FarmDog.entity.Dog;
import FarmDog.entity.DogState;

import java.util.Random;

public class WorkingActionImpl implements WorkingAction {
    private final Random random = new Random();

    private void setNewStateAfterWork(DogState state){
        state.setHealthy(random.nextBoolean());
        state.setHungry(random.nextBoolean());
        state.setTrained(true);
    }

    @Override
    public boolean startTraining(Dog dog) throws InterruptedException {
        System.out.println("Щенок " + dog.getName() + " начал тренировку");
        setNewStateAfterWork(dog.getState());
        Thread.sleep(3000);
        System.out.println("Щенок " + dog.getName() + " закончил тренировку");
        return true;
    }

    @Override
    public boolean startWorking(Dog dog) throws InterruptedException {
        System.out.println("Собака " + dog.getName() + " начала работу");
        setNewStateAfterWork(dog.getState());
        Thread.sleep(5000);
        System.out.println("Собака " + dog.getName() + " закончил работу");
        return true;
    }

    @Override
    public boolean stayInTheAviary(Dog dog) throws InterruptedException {
        System.out.println("Собака " + dog.getName() + " осталась в вольере");
        dog.getState().setHungry(random.nextBoolean());
        dog.getState().setHealthy(random.nextBoolean());
        return true;
    }
}
