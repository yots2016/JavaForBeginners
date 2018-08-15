package slack_task_14;

// Абстрактний клас
public abstract class Animal {
    private final String food;
    private final String location;
    private final String kindOfAnimal;

    public Animal(String food, String location, String kindOfAnimal) {
        this.food = food;
        this.location = location;
        this.kindOfAnimal = kindOfAnimal;
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

    // Геттер поля kindOfAnimal
    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    @Override
    public String toString() {
        return kindOfAnimal + " eats " + food + " and dwelling in " + location;
    }
}
