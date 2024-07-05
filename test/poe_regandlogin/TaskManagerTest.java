/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_regandlogin;

/**
 *
 * @author Mmakwena Masenya
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TaskManagerTest {

    private TaskManager taskManager;
    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach //initialize TaskManager and save original System.in
    public void setUp() {
        taskManager = new TaskManager();
    }

    @AfterEach //reset TaskManager and restore original System.in
    public void tearDown() {
        taskManager = null;
        System.setIn(originalSystemIn);
    }

    @Test
    public void testDisplayTasksWithStatusDone() {
       
        prepareTestData();

        String input = "4\nCreate Login\nMike Smith\n5\nTo Do\n" +
                       "8\nCreate Add Features\nEdward Harrison\n8\nDoing\n" +
                       "2\nCreate Reports\nSamantha Paulson\n2\nDone\n" +
                       "11\nAdd Arrays\nGlenda Oberholzer\n11\nTo Do\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        Scanner scanner = new Scanner(System.in);

        taskManager.runTaskManager(scanner);

        String expectedOutput = "Tasks with status 'Done':\n" +
                                "Developer: Samantha Paulson, Task Name: Create Reports, Task Duration: 2\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testDisplayDeveloperAndLongestTaskDuration() {
       
        prepareTestData();

        String input = "4\nCreate Login\nMike Smith\n5\nTo Do\n" +
                       "8\nCreate Add Features\nEdward Harrison\n8\nDoing\n" +
                       "2\nCreate Reports\nSamantha Paulson\n2\nDone\n" +
                       "11\nAdd Arrays\nGlenda Oberholzer\n11\nTo Do\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        Scanner scanner = new Scanner(System.in);
        
        taskManager.runTaskManager(scanner);

        String expectedOutput = "Developer with the longest task duration:\n" +
                                "Developer: Glenda Oberholzer, Task Duration: 11\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testSearchTaskByName() {
   
        prepareTestData();

        String input = "4\nCreate Login\nMike Smith\n5\nTo Do\n" +
                       "8\nCreate Add Features\nEdward Harrison\n8\nDoing\n" +
                       "2\nCreate Reports\nSamantha Paulson\n2\nDone\n" +
                       "11\nAdd Arrays\nGlenda Oberholzer\n11\nTo Do\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        Scanner scanner = new Scanner(System.in);

        taskManager.runTaskManager(scanner);

        String expectedOutput = "Searching for task with name 'Create Login':\n" +
                                "Task Name: Create Login, Developer: Mike Smith, Task Status: To Do\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        prepareTestData();

        String input = "4\nCreate Login\nMike Smith\n5\nTo Do\n" +
                       "8\nCreate Add Features\nEdward Harrison\n8\nDoing\n" +
                       "2\nCreate Reports\nSamantha Paulson\n2\nDone\n" +
                       "11\nAdd Arrays\nGlenda Oberholzer\n11\nTo Do\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        Scanner scanner = new Scanner(System.in);

        taskManager.runTaskManager(scanner);

        String expectedOutput = "Searching for tasks assigned to developer 'Samantha Paulson':\n" +
                                "Task Name: Create Reports, Task Status: Done\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testDeleteTaskByName() {
        
        prepareTestData();

        String input = "4\nCreate Login\nMike Smith\n5\nTo Do\n" +
                       "8\nCreate Add Features\nEdward Harrison\n8\nDoing\n" +
                       "2\nCreate Reports\nSamantha Paulson\n2\nDone\n" +
                       "11\nAdd Arrays\nGlenda Oberholzer\n11\nTo Do\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        Scanner scanner = new Scanner(System.in);

        taskManager.runTaskManager(scanner);

        String deleteInput = "Create Reports\n";
        testIn = new ByteArrayInputStream(deleteInput.getBytes());
        System.setIn(testIn);
        scanner = new Scanner(System.in);

        // Delete task and verify output
        taskManager.runTaskManager(scanner);
        String expectedOutput = "Deleting task with name 'Create Reports':\n" +
                                "Task 'Create Reports' deleted successfully.\n";
        assertEquals(expectedOutput, getOutput());
    }

    private void prepareTestData() {
        taskManager = new TaskManager();
    }

    private String getOutput() {
        return taskManager.getConsoleOutput();
    }
}
