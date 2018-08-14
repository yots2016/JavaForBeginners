package slack_task_14;

public class Horse extends Animal {
    private final String endurance;

    public Horse(String food, String location, String endurance) {
        super(food, location, "Horse");
        this.endurance = endurance;
    }

    @Override
    public void makeNoise() {
        System.out.println("Neigh-neigh");
    }

    @Override
    public void eat() {
        System.out.println("Horse ets");
    }

    @Override
    public void sleep() {
        System.out.println("Horse sleeps");
    }

    public String getEndurance() {
        return endurance;
    }
}
