package slack_task_14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Оголошення змінної типу List та створення об’єкту типу ArrayList
        List<Animal> animals = new ArrayList<>();

        // Додавання в ArrayList об’єктів типу Animal
        animals.add(new Dog("bones", "Ukraine", "Low"));
        animals.add(new Cat("mice", "USA", "High"));
        animals.add(new Horse("grass", "Japan", "Middle"));

        // Створення об’єкта типу Veterinarian
        Veterinarian veterinarian = new Veterinarian();

        // Перебір елементів ArrayList
        for (Animal animal : animals) {// Цикл for each
            // Передавання методу treatAnimal об’єкта типу Veterinarian посилання на об’єкт типу Animal
            veterinarian.treatAnimal(animal);
            System.out.println();
        }
    }
}
