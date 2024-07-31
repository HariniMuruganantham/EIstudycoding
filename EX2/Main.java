import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();

        scheduleManager.addObserver(new ConflictObserver());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask(scanner, taskFactory);
                    break;
                case "2":
                    removeTask(scanner);
                    break;
                case "3":
                    viewTasks();
                    break;
                case "4":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void addTask(Scanner scanner, TaskFactory taskFactory) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority level (High, Medium, Low): ");
        String priority = scanner.nextLine();

        Task task = taskFactory.createTask(description, startTime, endTime, priority);
        ScheduleManager.getInstance().addTask(task);
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        ScheduleManager.getInstance().removeTask(description);
    }

    private static void viewTasks() {
        for (Task task : ScheduleManager.getInstance().getTasks()) {
            System.out.println(String.format("%s - %s: %s [%s]", task.getStartTime(), task.getEndTime(), task.getDescription(), task.getPriority()));
        }
    }
}
