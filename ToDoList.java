package AI_projects;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println(task +" added to the list");
    }

    public void removeTask(int index) {
        String st=tasks.get(index);
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println(st+" is removed from the list");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List:");
            System.out.println("\nOptions:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display all tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();
                    toDoList.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    toDoList.removeTask(taskNumber - 1);
                    break;
                case 3:
                    ToDoList.displayTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}