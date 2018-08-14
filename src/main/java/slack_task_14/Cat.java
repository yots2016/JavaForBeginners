package slack_task_14;

public class Cat extends Animal {
    private final String miceFishing;

    public Cat(String food, String location, String miceFishing) {
        super(food, location, "Cat");
        this.miceFishing = miceFishing;
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow-meow");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeps");
    }

    public String getMiceFishing() {
        return miceFishing;
    }
}
