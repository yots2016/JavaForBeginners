package special_tasks1.task2;

public class Deadlock {
    static class Service {
        private final String name;

        public Service(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void callService(Service service) {
            System.out.println(this.name + " call " + service.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            service.stopService(this);
        }

        public synchronized void stopService(Service service) {
            System.out.println(this.name + " stop " + service.getName());
        }
    }

    public static void main(String[] args) {
        final Service service1 = new Service("Service1");
        final Service service2 = new Service("Service2");

        new Thread(() -> service1.callService(service2)).start();

        new Thread(() -> service2.callService(service1)).start();
    }
}
