

void main() {Car myCar = new Car("Toyota", 2020, 20000, 4);
    Bus myBus = new Bus("Mercedes", 2015, 50000, 30);

    System.out.println(myCar.toString());
    System.out.println("Insurance: " + myCar.calculateInsuranceFee());
}