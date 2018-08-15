package slack_task_14;

import java.util.Objects;

public class Cat extends Animal {
    private final String miceFishing;

    //Конструктор класу
    public Cat(String food, String location, String miceFishing) {
        // Виклик конструктора батьківського класу
        super(food, location, "Cat");
        this.miceFishing = miceFishing;
    }

    // Перевизначений метод батьківського класу
    @Override
    public void makeNoise() {
        System.out.println("Meow-meow");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void sleep() {
        System.out.println("Cat sleeps");
    }

    // Геттер для поля miceFishing
    public String getMiceFishing() {
        return miceFishing;
    }
}
