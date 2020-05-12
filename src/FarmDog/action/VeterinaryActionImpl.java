package FarmDog.action;

import FarmDog.entity.Dog;

import java.util.List;

public class VeterinaryActionImpl implements VeterinaryAction {

    @Override
    public boolean heal(Dog dog) {
        if (dog.getState().isHealthy()) return false;
        dog.getState().setHealthy(true);
        return true;
    }

    @Override
    public void launchCheckup(Dog dog) throws InterruptedException {
        if(!heal(dog)){
            Thread.sleep(500);
            System.out.println("Собака " + dog.getName() + " здорова");
        } else{
            Thread.sleep(5000);
            System.out.println("Собака " + dog.getName() + " вылечена");
        }
    }


}
