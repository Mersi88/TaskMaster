import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Remove a task by title
    public boolean removeTaskByTitle(String title) {
        return tasks.removeIf(t -> t.getTitle().equalsIgnoreCase(title));
    }

    // List all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Find a task by title
    public Task findTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    // Sort tasks by deadline (earliest first)
    public void sortByDeadline() {
        Collections.sort(tasks, Comparator.comparing(Task::getDeadline));
    }

    // Sort by priority if PriorityTask
    public void sortByPriority() {
        Collections.sort(tasks, (a, b) -> {
            if (a instanceof PriorityTask && b instanceof PriorityTask) {
                return Integer.compare(((PriorityTask) a).getPriorityLevel(),
                                       ((PriorityTask) b).getPriorityLevel());
            }
            return 0;
        });
    }
}
