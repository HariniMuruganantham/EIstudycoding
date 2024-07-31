import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Item {
    void accept(Visitor visitor);
}

class Book implements Item {
    private double price;
    private String isbn;

    public Book(double price, String isbn) {
        this.price = price;
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Fruit implements Item {
    private double pricePerKg;
    private double weight;
    private String name;

    public Fruit(double pricePerKg, double weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}

class ShoppingCartVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        double cost = book.getPrice();
        System.out.println("Book ISBN: " + book.getIsbn() + " Cost: " + cost);
    }

    @Override
    public void visit(Fruit fruit) {
        double cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " Cost: " + cost);
    }
}

public class VisitorPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Select item type to add to the cart:");
            System.out.println("1. Book");
            System.out.println("2. Fruit");
            System.out.println("3. Finish");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();

                    items.add(new Book(price, isbn));
                    break;

                case 2:
                    // Add Fruit
                    System.out.print("Enter fruit price per kg: ");
                    double pricePerKg = scanner.nextDouble();

                    System.out.print("Enter fruit weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter fruit name: ");
                    String name = scanner.nextLine();

                    items.add(new Fruit(pricePerKg, weight, name));
                    break;

                case 3:
                    // Finish
                    scanner.close();
                    // Process the items with the visitor
                    Visitor visitor = new ShoppingCartVisitor();
                    for (Item item : items) {
                        item.accept(visitor);
                    }
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
