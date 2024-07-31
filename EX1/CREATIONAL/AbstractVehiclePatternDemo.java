import java.util.Scanner;

// Abstract Factory Interface
interface VehicleFactory {
    Car createCar();
    Motorcycle createMotorcycle();
}

// Abstract Products
interface Car {
    void drive();
}

interface Motorcycle {
    void ride();
}

// Concrete Products for Urban Factory
class UrbanCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an urban car.");
    }
}

class UrbanMotorcycle implements Motorcycle {
    @Override
    public void ride() {
        System.out.println("Riding an urban motorcycle.");
    }
}

// Concrete Products for Rural Factory
class RuralCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a rural car.");
    }
}

class RuralMotorcycle implements Motorcycle {
    @Override
    public void ride() {
        System.out.println("Riding a rural motorcycle.");
    }
}

// Concrete Factories
class UrbanVehicleFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new UrbanCar();
    }

    @Override
    public Motorcycle createMotorcycle() {
        return new UrbanMotorcycle();
    }
}

class RuralVehicleFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new RuralCar();
    }

    @Override
    public Motorcycle createMotorcycle() {
        return new RuralMotorcycle();
    }
}

// Client Code
public class AbstractVehiclePatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a vehicle factory: ");
        System.out.println("1. Urban");
        System.out.println("2. Rural");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        VehicleFactory factory = null;
        if (choice == 1) {
            factory = new UrbanVehicleFactory();
        } else if (choice == 2) {
            factory = new RuralVehicleFactory();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        System.out.println("Choose a vehicle to create: ");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.print("Enter your choice (1 or 2): ");
        int vehicleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (vehicleChoice == 1) {
            Car car = factory.createCar();
            car.drive();
        } else if (vehicleChoice == 2) {
            Motorcycle motorcycle = factory.createMotorcycle();
            motorcycle.ride();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

