package slack_task_14;

public class Dog extends Animal {
    private final String protectionOfHolder;

    //Конструктор класу
    public Dog(String food, String location, String protectionOfHolder) {
        // Виклик конструктора батьківського класу
        super(food, location);
        this.protectionOfHolder = protectionOfHolder;
    }

    // Перевизначений метод батьківського класу
    @Override
    public void makeNoise() {
        System.out.println("Woof-woof");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    // Перевизначений метод батьківського класу
    @Override
    public String toString() {
        return "Dog{" +
                "protectionOfHolder='" + protectionOfHolder + '\'' +
                '}';
    }

    // Геттер для поля protectionOfHolder
    public String getProtectionOfHolder() {
        return protectionOfHolder;
    }
}
