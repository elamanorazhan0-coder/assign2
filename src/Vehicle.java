public abstract class Vehicle {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() { return id; }

    public String getModel() { return model; }
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        this.model = model;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 1886 || year > 2026) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - this.year;
    }

    public abstract double calculateInsuranceFee();

    public abstract void performService();

    public abstract int getServiceIntervalKm();

    @Override
    public String toString() {
        return "ID: " + id + ", Model: " + model + ", Year: " + year + ", Price: " + basePrice;
    }
}