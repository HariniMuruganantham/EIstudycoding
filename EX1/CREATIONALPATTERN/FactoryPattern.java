import java.util.Scanner;
interface PaymentProcessor {
    void processPayment(double amount);
}
class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
 class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
 class PaymentProcessorFactory {
    public PaymentProcessor createPaymentProcessor(String type) {
        if (type.equalsIgnoreCase("CreditCard")) {
            return new CreditCardProcessor();
        } else if (type.equalsIgnoreCase("PayPal")) {
            return new PayPalProcessor();
        }
        throw new IllegalArgumentException("Unknown payment method: " + type);
    }
}


public class FactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the factory
        PaymentProcessorFactory factory = new PaymentProcessorFactory();

        // Collect payment method from user
        System.out.print("Enter payment method (CreditCard/PayPal): ");
        String paymentMethod = scanner.nextLine();

        // Create the payment processor
        PaymentProcessor processor = factory.createPaymentProcessor(paymentMethod);

        // Process payment
        processor.processPayment(100.00);

        scanner.close();
    }
}
