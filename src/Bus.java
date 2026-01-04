public class Bus extends Vehicle {
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
    public String toString() {
        return super.toString() + ", Capacity: " + passengerCapacity;
    }
}