import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Mediator Interface
interface Mediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements Mediator {
    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague (User) Interface
interface User {
    void sendMessage(String message);
    void receiveMessage(String message);
}

// Concrete Colleague (User) Class
class ChatUser implements User {
    String name;
    private Mediator mediator;

    public ChatUser(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.addUser(this);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Main Class with Runtime Input
public class MediatorPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mediator chatRoom = new ChatRoom();

        // Create users
        System.out.println("Enter the number of users:");
        int numberOfUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println("Enter the name of user " + (i + 1) + ":");
            String name = scanner.nextLine();
            new ChatUser(name, chatRoom);
        }

        // Send messages
        while (true) {
            System.out.println("\nEnter the name of the user sending the message (or type 'exit' to quit):");
            String senderName = scanner.nextLine();

            if (senderName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the message:");
            String message = scanner.nextLine();

            // Find the user by name and send the message
            for (User user : ((ChatRoom) chatRoom).users) {
                if (((ChatUser) user).name.equalsIgnoreCase(senderName)) {
                    user.sendMessage(message);
                    break;
                }
            }
        }

        scanner.close();
    }
}
