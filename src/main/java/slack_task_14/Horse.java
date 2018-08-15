package slack_task_14;

public class Horse extends Animal {
    private final String endurance;

    //Конструктор класу
    public Horse(String food, String location, String endurance) {
        // Виклик конструктора батьківського класу
        super(food, location, "Horse");
        this.endurance = endurance;
    }

    // Перевизначений метод батьківського класу
    @Override
    public void makeNoise() {
        System.out.println("Neigh-neigh");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void eat() {
        System.out.println("Horse ets");
    }

    // Перевизначений метод батьківського класу
    @Override
    public void sleep() {
        System.out.println("Horse sleeps");
    }

    // Геттер для поля endurance
    public String getEndurance() {
        return endurance;
    }
}
