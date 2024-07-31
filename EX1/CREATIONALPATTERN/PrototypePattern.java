import java.util.Scanner;

// Prototype interface
interface Robot extends Cloneable {
    Robot clone();
    void setAttributes(String attributes);
    String getAttributes();
}

// Concrete prototype: BattleRobot
class BattleRobot implements Robot {
    private String attributes;

    @Override
    public Robot clone() {
        BattleRobot copy = new BattleRobot();
        copy.setAttributes(this.attributes);
        return copy;
    }

    @Override
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "BattleRobot with attributes: " + attributes;
    }
}

// Concrete prototype: ServiceRobot
class ServiceRobot implements Robot {
    private String attributes;

    @Override
    public Robot clone() {
        ServiceRobot copy = new ServiceRobot();
        copy.setAttributes(this.attributes);
        return copy;
    }

    @Override
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "ServiceRobot with attributes: " + attributes;
    }
}

// Client code
public class PrototypePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input and create BattleRobot
        System.out.print("Enter attributes for BattleRobot: ");
        String battleRobotAttributes = scanner.nextLine();
        Robot battleRobot1 = new BattleRobot();
        battleRobot1.setAttributes(battleRobotAttributes);
        Robot battleRobot2 = battleRobot1.clone();

        // Input and create ServiceRobot
        System.out.print("Enter attributes for ServiceRobot: ");
        String serviceRobotAttributes = scanner.nextLine();
        Robot serviceRobot1 = new ServiceRobot();
        serviceRobot1.setAttributes(serviceRobotAttributes);
        Robot serviceRobot2 = serviceRobot1.clone();

        // Print information
        System.out.println("\nRobots:");
        System.out.println(battleRobot1);
        System.out.println(battleRobot2);
        System.out.println(serviceRobot1);
        System.out.println(serviceRobot2);

        scanner.close();
    }
}
