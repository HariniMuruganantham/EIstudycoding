//client code
public class PrototypePatternDemo {
    public static void main(String[] args) {
        HumanoidRobot humanoid1 = new HumanoidRobot("T-800");
        HumanoidRobot humanoid2 = humanoid1.clone();

        AutonomousRobot autonomous1 = new AutonomousRobot("X-200");
        AutonomousRobot autonomous2 = autonomous1.clone();

        System.out.println(humanoid1);
        System.out.println(humanoid2);

        System.out.println(autonomous1);
        System.out.println(autonomous2);
    }
}
//prototype interface
interface Robot extends Cloneable {
    Robot clone();
}
//concrete prototypes
class HumanoidRobot implements Robot {
    private String model;

    public HumanoidRobot(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public HumanoidRobot clone() {
        return new HumanoidRobot(this.model);
    }

    @Override
    public String toString() {
        return "HumanoidRobot model " + model;
    }
}

class AutonomousRobot implements Robot {
    private String version;

    public AutonomousRobot(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public AutonomousRobot clone() {
        return new AutonomousRobot(this.version);
    }

    @Override
    public String toString() {
        return "AutonomousRobot version " + version;
    }
}