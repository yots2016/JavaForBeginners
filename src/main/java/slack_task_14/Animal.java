package slack_task_14;

public abstract class Animal {
    private final String food;
    private final String location;
    private final String kindOfAnimal;

    public Animal(String food, String location, String kindOfAnimal) {
        this.food = food;
        this.location = location;
        this.kindOfAnimal = kindOfAnimal;
    }

    public abstract void makeNoise();

    public abstract void eat();

    public abstract void sleep();

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    @Override
    public String toString() {
        return kindOfAnimal + " eats " + food + " and dwelling in " + location;
    }
}
