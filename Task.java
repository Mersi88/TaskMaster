import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate deadline;

    // Constructors
    public Task(String title) {
        this.title = title;
        this.description = "";
        this.deadline = LocalDate.now().plusDays(7); // Default deadline
    }

    public Task(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    // Method to calculate days left
    public int daysLeft() {
        return LocalDate.now().until(deadline).getDays();
    }

    // toString method (to be overridden in subclass)
    @Override
    public String toString() {
        return "[" + title + "] - " + description + " (Due: " + deadline + ")";
    }

    // equals method (based on title)
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task other = (Task) obj;
            return this.title.equalsIgnoreCase(other.title);
        }
        return false;
    }
}
