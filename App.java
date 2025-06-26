import java.time.LocalDate;

public class App {
    /**
     * Project: TaskMaster - A To-Do List Manager
     * 
     * Demonstrates:
     * - Inheritance via PriorityTask → Task
     * - Encapsulation with getters/setters
     * - Constructor overloading
     * - Overriding toString() and equals()
     * - Comparable-style sorting with deadline/priority
     * - Collections using ArrayList<Task>
     */
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();

        Task t1 = new Task("Laundry", "Wash and fold clothes", LocalDate.of(2025, 6, 28));
        PriorityTask t2 = new PriorityTask("Assignment", "Finish current project", LocalDate.of(2025, 6, 26), 1);
        PriorityTask t3 = new PriorityTask("Groceries", "Buy vegetables", LocalDate.of(2025, 6, 27), 3);

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        System.out.println("All Tasks:");
        manager.listTasks();

        System.out.println("\nSorted by Deadline:");
        manager.sortByDeadline();
        manager.listTasks();

        System.out.println("\nSorted by Priority:");
        manager.sortByPriority();
        manager.listTasks();

        System.out.println("\nSearch: Assignment → " + manager.findTaskByTitle("Assignment"));

        System.out.println("\nRemoving 'Groceries'");
        manager.removeTaskByTitle("Groceries");
        manager.listTasks();
    }
}
