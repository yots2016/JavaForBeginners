package slack_task_14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Dog("bones", "Ukraine", "Low"));
        animals.add(new Cat("mice", "USA", "High"));
        animals.add(new Horse("grass", "Japan", "Middle"));

        Veterinarian veterinarian = new Veterinarian();

        for (Animal animal : animals) {
            veterinarian.treatAnimal(animal);
            System.out.println(animal);
            System.out.println();
        }
    }
}
