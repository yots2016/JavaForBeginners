package slack_task_14;

// Абстрактний клас
public abstract class Animal {
    private final String food;
    private final String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }


    // Абстрактний метод, який не має реалізації та повинен бути реалізований
    // в неабстрактних(звичайних) класах нащадках
    public abstract void makeNoise();

    // Абстрактний метод, який не має реалізації та повинен бути реалізований
    // в неабстрактних(звичайних) класах нащадках
    public abstract void eat();

    // Абстрактний метод, який не має реалізації та повинен бути реалізований
    // в неабстрактних(звичайних) класах нащадках
    public abstract void sleep();

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
