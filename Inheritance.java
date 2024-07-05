// Vehicle.java (Parent class for inheritance)
class Vehicle {
    void drive() {
        System.out.println("Vehicle is driving");
    }
}

// Car.java (Subclass demonstrating inheritance)
class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Car is driving");
    }
}

// Truck.java (Another subclass demonstrating inheritance)
class Truck extends Vehicle {
    @Override
    void drive() {
        System.out.println("Truck is driving");
    }
}

// Main.java (Driver program to demonstrate inheritance)
public class Inheritance {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Truck();

        vehicle1.drive(); // Outputs "Car is driving"
        vehicle2.drive(); // Outputs "Truck is driving"
    }
}