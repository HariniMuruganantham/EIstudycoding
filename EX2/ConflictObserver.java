interface TaskObserver {
    void notify(Task task);
}

public class ConflictObserver implements TaskObserver {
    @Override
    public void notify(Task task) {
        System.out.println("Conflict detected with task: " + task.getDescription());
    }
}
