import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleManager {
    private static final ScheduleManager instance = new ScheduleManager();
    private final List<Task> tasks = new ArrayList<>();
    private final List<TaskObserver> observers = new ArrayList<>();

    private ScheduleManager() { }

    public static ScheduleManager getInstance() {
        return instance;
    }

    public void addTask(Task task) {
        for (Task existingTask : tasks) {
            if (existingTask.overlapsWith(task)) {
                notifyObservers(task);
                return;
            }
        }
        tasks.add(task);
        Collections.sort(tasks, (t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        Logger.getInstance().log("Task added: " + task.getDescription());
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            Logger.getInstance().log("Task removed: " + description);
        } else {
            Logger.getInstance().log("Task not found: " + description);
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.notify(task);
        }
    }
}
