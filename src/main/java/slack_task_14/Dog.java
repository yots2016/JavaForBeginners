package slack_task_14;

public class Dog extends Animal {
    private final String ProtectionOfHolder;

    public Dog(String food, String location, String protectionOfHolder) {
        super(food, location, "Dog");
        ProtectionOfHolder = protectionOfHolder;
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof-woof");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    public String getProtectionOfHolder() {
        return ProtectionOfHolder;
    }
}
