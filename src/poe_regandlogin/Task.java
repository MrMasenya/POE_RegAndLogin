/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_regandlogin;
/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private static int taskCount = 0; 
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
 
    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = generateTaskID();
        taskCount++; 
    }
 
    // Method to generate task ID
    private String generateTaskID() {       
        String prefix = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase(); 
        String suffix = developerDetails.substring(Math.max(0, developerDetails.length() - 3)).toUpperCase();
        return prefix + ":" + taskCount + ":" + suffix;
    }
 
    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
 
    // Method to print task details
    public void printTaskDetails() {
        System.out.println("Task Status: " + taskStatus);
        System.out.println("Developer Details: " + developerDetails);
        System.out.println("Task Number: " + taskCount);
        System.out.println("Task Name: " + taskName);
        System.out.println("Task Description: " + taskDescription);
        System.out.println("Task ID: " + taskID);
        System.out.println("Task Duration: " + taskDuration);
    }
 
    // Getter method for task duration
    public int getTaskDuration() {
        return taskDuration;
    }
 
    // Getter method for task status
    public String getTaskStatus() {
        return taskStatus;
    }
}
