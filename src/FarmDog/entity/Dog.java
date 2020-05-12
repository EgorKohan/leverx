package FarmDog.entity;

public class Dog {
    private final String name;
    private final int age;
    private final DogBreed breed;
    private DogState state;

    public Dog(String name, int age, DogBreed breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        state = new DogState();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public DogBreed getBreed() {
        return breed;
    }

    public DogState getState() {
        return state;
    }

    public void setState(DogState state) {
        this.state = state;
    }
}

