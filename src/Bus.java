public class Bus extends Vehicle implements Servicable {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return (getBasePrice() * 0.1) + (passengerCapacity * 50);
    }

    @Override
    public void performService() {
        System.out.println("Service for Bus " + getModel() + ": Safety check for " + passengerCapacity + " seats and brake system.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 30000; // У автобусов интервал больше
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacity: " + passengerCapacity;
    }
}