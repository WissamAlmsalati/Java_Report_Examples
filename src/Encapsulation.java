package src;
 
 class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// Main.java (Driver program to demonstrate encapsulation)
public class Encapsulation {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 50000);
        emp.displayInfo();

        // Accessing and modifying through getter and setter
        emp.setSalary(60000);
        System.out.println("Updated salary: " + emp.getSalary());
    }
}