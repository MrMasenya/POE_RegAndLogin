package poe_regandlogin;

import java.util.Scanner;

public class TaskManager {
    private String[] developers;
    private String[] taskNames;
    private int[] taskIDs;
    private int[] taskDurations;
    private String[] taskStatuses;
    private int numTasks;

    public TaskManager() {
        // Default constructor
    }

    public void runTaskManager(Scanner scanner) {
        System.out.println("Welcome to EasyKanban");
        System.out.print("Enter the number of tasks: ");
        numTasks = scanner.nextInt();
        scanner.nextLine();  
        developers = new String[numTasks];
        taskNames = new String[numTasks];
        taskIDs = new int[numTasks];
        taskDurations = new int[numTasks];
        taskStatuses = new String[numTasks];

        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter Task Name: ");
            taskNames[i] = scanner.nextLine();
            System.out.print("Enter Developer: ");
            developers[i] = scanner.nextLine();
            System.out.print("Enter Task Duration: ");
            taskDurations[i] = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Task Status (To Do, Done, Doing): ");
            taskStatuses[i] = scanner.nextLine();
            taskIDs[i] = i + 1; 
        }

        // Display total hours
        int totalHours = calculateTotalHours();
        System.out.println("Total Hours: " + totalHours);

        // Menu for user interaction
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    displayTasksWithStatusDone();
                    break;
                case 2:
                    displayDeveloperAndLongestTaskDuration();
                    break;
                case 3:
                    promptAndSearchTaskByName(scanner);
                    break;
                case 4:
                    promptAndSearchTasksByDeveloper(scanner);
                    break;
                case 5:
                    promptAndDeleteTaskByName(scanner);
                    break;
                case 6:
                    displayFullReport();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting EasyKanban. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Display tasks with status 'Done'");
        System.out.println("2. Display developer with the longest task duration");
        System.out.println("3. Search for a task by name");
        System.out.println("4. Search for tasks by developer");
        System.out.println("5. Delete a task by name");
        System.out.println("6. Display full task report");
        System.out.println("7. Exit");
    }

    private int calculateTotalHours() {
        int total = 0;
        for (int duration : taskDurations) {
            total += duration;
        }
        return total;
    }

    private void displayTasksWithStatusDone() {
        System.out.println("Tasks with status 'Done':");
        for (int i = 0; i < numTasks; i++) {
            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                System.out.println("Developer: " + developers[i] +
                                   ", Task Name: " + taskNames[i] +
                                   ", Task Duration: " + taskDurations[i]);
            }
        }
    }

    private void displayDeveloperAndLongestTaskDuration() {
        int longestIndex = 0;
        for (int i = 1; i < numTasks; i++) {
            if (taskDurations[i] > taskDurations[longestIndex]) {
                longestIndex = i;
            }
        }
        System.out.println("Developer with the longest task duration:");
        System.out.println("Developer: " + developers[longestIndex] +
                           ", Task Duration: " + taskDurations[longestIndex]);
    }

    private void promptAndSearchTaskByName(Scanner scanner) {
        System.out.print("Enter Task Name to search: ");
        String name = scanner.nextLine();

        System.out.println("Searching for task with name '" + name + "':");
        boolean found = false;
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(name)) {
                System.out.println("Task Name: " + taskNames[i] +
                                   ", Developer: " + developers[i] +
                                   ", Task Status: " + taskStatuses[i]);
                found = true;
                break;  
            }
        }
        if (!found) {
            System.out.println("Task with name '" + name + "' not found.");
        }
    }

    private void promptAndSearchTasksByDeveloper(Scanner scanner) {
        System.out.print("Enter Developer Name to search tasks: ");
        String developer = scanner.nextLine();

        System.out.println("Searching for tasks assigned to developer '" + developer + "':");
        boolean found = false;
        for (int i = 0; i < numTasks; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                System.out.println("Task Name: " + taskNames[i] +
                                   ", Task Status: " + taskStatuses[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found assigned to developer '" + developer + "'.");
        }
    }

    private void promptAndDeleteTaskByName(Scanner scanner) {
        System.out.print("Enter Task Name to delete: ");
        String name = scanner.nextLine();

        deleteTaskByName(name);
    }

    // Function to delete a task using Task Name
    private void deleteTaskByName(String name) {
        System.out.println("Deleting task with name '" + name + "':");
        boolean found = false;
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(name)) {
                
                for (int j = i; j < numTasks - 1; j++) {
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
              
                int lastIndex = numTasks - 1;
                developers[lastIndex] = null;
                taskNames[lastIndex] = null;
                taskIDs[lastIndex] = 0;
                taskDurations[lastIndex] = 0;
                taskStatuses[lastIndex] = null;
                found = true;
                numTasks--; 
                break; 
            }
        }
        if (found) {
            System.out.println("Task '" + name + "' deleted successfully.");
        } else {
            System.out.println("Task with name '" + name + "' not found.");
        }
    }

    // Function to display a report
    private void displayFullReport() {
        System.out.println("Full Task Report:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task ID: " + taskIDs[i] +
                               ", Developer: " + developers[i] +
                               ", Task Name: " + taskNames[i] +
                               ", Task Duration: " + taskDurations[i] +
                               ", Task Status: " + taskStatuses[i]);
        }
    }
}
