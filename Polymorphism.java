
// Animal.java (Base class for polymorphism)
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Dog.java (Subclass demonstrating polymorphism)
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Cat.java (Another subclass demonstrating polymorphism)
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main.java (Driver program to demonstrate polymorphism)
public class Polymorphism {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound(); // Outputs "Dog barks"
        myCat.sound(); // Outputs "Cat meows"
    }
}