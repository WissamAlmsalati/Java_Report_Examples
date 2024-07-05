package src;

// Shape.java (Abstraction example)
abstract class Shape {
    abstract void draw();
}

// Circle.java (Concrete class using abstraction)
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Main.java (Driver program to demonstrate abstraction)
public class Abstraction {
    public static void main(String[] args) {
        Shape shape = new Circle(); // Reference of Shape pointing to Circle object
        shape.draw(); // Calls Circle's draw method
    }
}