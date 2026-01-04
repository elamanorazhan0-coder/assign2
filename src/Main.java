public class Main {
    public static void main(String[] args) {
        Servicable[] serviceQueue = new Servicable[2];

        serviceQueue[0] = new Car("Tesla Model 3", 2022, 45000, 4);
        serviceQueue[1] = new Bus("Volvo 9700", 2019, 120000, 50);

        for (Servicable s : serviceQueue) {
            System.out.println("--- Starting Service ---");

            s.performService();
            System.out.println("Recommended interval: " + s.getServiceIntervalKm() + " km");
        }
    }
}