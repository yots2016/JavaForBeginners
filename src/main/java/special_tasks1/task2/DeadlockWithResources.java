package special_tasks1.task2;

public class DeadlockWithResources {
    public static void main(String[] args) {
        Resource1 resource1 = new Resource1("Resource #1");
        Resource2 resource2 = new Resource2("Resource #2");
        resource1.setResource2(resource2);
        resource2.setResource1(resource1);

        new Thread(resource1::printString).start();
        new Thread(resource2::printString).start();
    }
}

class Resource1 {
    private final String name;
    private Resource2 resource2;

    public Resource1(String name) {
        this.name = name;
    }

    public synchronized void printString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(resource2.getString());
    }

    public synchronized String getString() {
        return name;
    }

    public void setResource2(Resource2 resource2) {
        this.resource2 = resource2;
    }
}

class Resource2 {
    private final String name;
    private Resource1 resource1;

    public Resource2(String name) {
        this.name = name;
    }

    public synchronized void printString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(resource1.getString());
    }

    public synchronized String getString() {
        return name;
    }

    public void setResource1(Resource1 resource1) {
        this.resource1 = resource1;
    }
}
