public class PriorityTask extends Task {
    private int priorityLevel; // 1 = High, 2 = Medium, 3 = Low

    // Constructor with just title (overloading)
    public PriorityTask(String title) {
        super(title);
        this.priorityLevel = 2; // Default to Medium
    }

    // Constructor with all fields
    public PriorityTask(String title, String description, java.time.LocalDate deadline, int priorityLevel) {
        super(title, description, deadline);
        this.priorityLevel = priorityLevel;
    }

    // Getter and setter
    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    // Override toString
    @Override
    public String toString() {
        String priorityText = switch (priorityLevel) {
            case 1 -> "HIGH";
            case 2 -> "MEDIUM";
            case 3 -> "LOW";
            default -> "UNKNOWN";
        };
        return super.toString() + " [Priority: " + priorityText + "]";
    }

    // Override equals to include priority level
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PriorityTask) {
            PriorityTask other = (PriorityTask) obj;
            return super.equals(other) && this.priorityLevel == other.priorityLevel;
        }
        return false;
    }
}
