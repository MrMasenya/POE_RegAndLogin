/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_regandlogin;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Mmakwena Masenya
 */
 
public class TaskTest {
 
    @Test
    public void testTaskDescriptionValidationSuccess() {
        Task task = new Task();
        String taskDescription = "Create Login to authenticate users";
        boolean isValid = task.checkTaskDescription(taskDescription);
        assertEquals(true, isValid);
    }
 
    @Test
    public void testTaskDescriptionValidationFailure() {
        Task task = new Task();
        String taskDescription = "This is a long description that exceeds 50 characters limit.";
        boolean isValid = task.checkTaskDescription(taskDescription);
        assertEquals(false, isValid);
    }
 
    @Test
    public void testTaskIDGeneration() {
        Task task = new Task();
        String taskName = "Add Login Feature";
        int taskNumber = 0; // Assuming this is the first task
        String developerDetails = "Robyn Harrison";
        String expectedTaskID = "AD:0:RYN";
        String taskID = task.createTaskID(taskName, taskNumber, developerDetails);
        assertEquals(expectedTaskID, taskID);
    }
 
    @Test
    public void testTotalHoursCalculation() {
        Task task1 = new Task("Login Feature", "", "Robyn Harrison", 8, "");
        Task task2 = new Task("Add Task Feature", "", "Mike Smith", 10, "");
        int expectedTotalHours = 18; // 8 + 10
        int totalHours = task1.getTaskDuration() + task2.getTaskDuration();
        assertEquals(expectedTotalHours, totalHours);
    }
}