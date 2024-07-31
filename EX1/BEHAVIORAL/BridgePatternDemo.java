import java.util.Scanner;

interface Device {
    void on();
    void off();
}

class TV implements Device {
    @Override
    public void on() {
        System.out.println("TV is on");
    }

    @Override
    public void off() {
        System.out.println("TV is off");
    }
}

class Radio implements Device {
    @Override
    public void on() {
        System.out.println("Radio is on");
    }

    @Override
    public void off() {
        System.out.println("Radio is off");
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

class ConcreteRemoteControl extends RemoteControl {
    public ConcreteRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.on();
    }

    @Override
    public void turnOff() {
        device.off();
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl tvRemote = new ConcreteRemoteControl(tv);
        RemoteControl radioRemote = new ConcreteRemoteControl(radio);

        while (true) {
            System.out.println("Select a device:");
            System.out.println("1. TV");
            System.out.println("2. Radio");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            int deviceChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            RemoteControl selectedRemote = null;
            switch (deviceChoice) {
                case 1:
                    selectedRemote = tvRemote;
                    break;
                case 2:
                    selectedRemote = radioRemote;
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.println("What do you want to do?");
            System.out.println("1. Turn On");
            System.out.println("2. Turn Off");
            System.out.print("Enter your choice (1/2): ");
            int actionChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (actionChoice) {
                case 1:
                    selectedRemote.turnOn();
                    break;
                case 2:
                    selectedRemote.turnOff();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

