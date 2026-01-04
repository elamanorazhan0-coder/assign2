import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Fleet Management System ---");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThanN();
                case 6 -> performAllServices();
                case 7 -> {
                    running = false;
                    System.out.println("Exiting application...");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    private void addCar() {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter base price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter number of doors: ");
        int doors = scanner.nextInt();

        vehicles.add(new Car(model, year, price, doors));
        System.out.println("Car added successfully!");
    }

    private void addBus() {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter base price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter passenger capacity: ");
        int capacity = scanner.nextInt();

        vehicles.add(new Bus(model, year, price, capacity));
        System.out.println("Bus added successfully!");
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.printf("Total yearly insurance fees: $%.2f\n", total);
    }

    private void showOlderThanN() {
        System.out.print("Enter current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter N (years): ");
        int n = scanner.nextInt();

        System.out.println("Vehicles older than " + n + " years:");
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void performAllServices() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable) {
                ((Servicable) v).performService();
            }
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}