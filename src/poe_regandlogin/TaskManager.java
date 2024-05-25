/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_regandlogin;

/**
 *
 * @author Mmakwena Masenya
 */

import java.util.Scanner;
 

public class TaskManager {
 
    public void runTaskManager(Scanner scanner) {
        System.out.println("Welcome to EasyKanban");
 
        System.out.print("Enter the number of tasks: ");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); 
 
        Task[] tasks = new Task[numTasks];
 
        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter Task Name: ");
            String taskName = scanner.nextLine();
 
            System.out.print("Enter Task Description: ");
            String taskDescription = scanner.nextLine();
 
            System.out.print("Enter Developer Details: ");
            String developerDetails = scanner.nextLine();
 
            System.out.print("Enter Task Duration: ");
            int taskDuration = scanner.nextInt();
            scanner.nextLine(); 
 
            System.out.print("Enter Task Status (To Do, Done, Doing): ");
            String taskStatus = scanner.nextLine();
 
            tasks[i] = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
 
            if (!tasks[i].checkTaskDescription()) {
                System.out.println("Please enter a task description of less than 50 characters");
                System.out.print("Enter Task Description (less than 50 characters): ");
                taskDescription = scanner.nextLine();
                tasks[i] = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            }
 
            tasks[i].printTaskDetails();
        }
 
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        System.out.println("Total Hours: " + totalHours);
    }
}