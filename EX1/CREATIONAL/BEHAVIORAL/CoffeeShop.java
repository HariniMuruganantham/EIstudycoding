package BEHAVIORAL;
import java.util.Scanner;

interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Coffee coffee = new SimpleCoffee();
        
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Would you like to add Milk? (yes/no)");
        String milkChoice = scanner.nextLine();
        if (milkChoice.equalsIgnoreCase("yes")) {
            coffee = new MilkDecorator(coffee);
        }
        
        System.out.println("Would you like to add Sugar? (yes/no)");
        String sugarChoice = scanner.nextLine();
        if (sugarChoice.equalsIgnoreCase("yes")) {
            coffee = new SugarDecorator(coffee);
        }
        
        System.out.println("Your final order:");
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        scanner.close();
    }
}
