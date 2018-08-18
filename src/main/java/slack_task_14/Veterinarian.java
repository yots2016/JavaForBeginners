package slack_task_14;

public class Veterinarian {
    // Метод, що реалізовує прийом до ветеринара
    public void treatAnimal(Animal animal) {
        System.out.println("On the treatment of an animal that eats " + animal.getFood() +
                " and lives in " + animal.getLocation());
    }
}
