import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        this.endTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean overlapsWith(Task other) {
        return startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime);
    }
}
