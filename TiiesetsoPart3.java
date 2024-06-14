/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiiesetsopart3;

/**
 *
 * @author Lethabo Molate
 */
import java.util.Scanner;

public class TiiesetsoPart3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to EasyKanban");

        // Prompt for user login
        System.out.println("Enter username for login:");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter password for login:");
        String enteredPassword = scanner.nextLine();

        // Create a default user for the example
        User user = new Login().createDefaultUser();

        // Check login status
        if (user.loginUser(enteredUsername, enteredPassword)) {
            System.out.println("Login successful");

            TaskManager taskManager = new TaskManager();

            boolean exit = false;
            while (!exit) {
                // Display menu options
                System.out.println("Choose an option:");
                System.out.println("1) Add tasks");
                System.out.println("2) Show report");
                System.out.println("3) Quit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                switch (choice) {
                    case 1:
                        // Add tasks
                        addTasks(scanner, taskManager);
                        break;
                    case 2:
                        // Show report
                        showReport(taskManager);
                        break;
                    case 3:
                        // Quit
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        scanner.close();
    }

    private static void addTasks(Scanner scanner, TaskManager taskManager) {
        System.out.println("How many tasks would you like to add?");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter task name:");
            String taskName = scanner.nextLine();

            System.out.println("Enter task description (max 50 characters):");
            String taskDescription = scanner.nextLine();
            while (taskDescription.length() > 50) {
                System.out.println("Please enter a task description of less than 50 characters:");
                taskDescription = scanner.nextLine();
            }

            System.out.println("Enter developer first name:");
            String developerFirstName = scanner.nextLine();
            System.out.println("Enter developer last name:");
            String developerLastName = scanner.nextLine();

            System.out.println("Enter task duration (in hours):");
            int taskDuration = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            System.out.println("Choose task status:");
            System.out.println("1) To Do");
            System.out.println("2) Done");
            System.out.println("3) Doing");
            int statusChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            String taskStatus = switch (statusChoice) {
                case 1 -> "To Do";
                case 2 -> "Done";
                case 3 -> "Doing";
                default -> "To Do";
            };

            taskManager.addTask(taskName, i, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
            totalHours += taskDuration;

            Task task = taskManager.getTask(i);
            if (task != null) {
                System.out.println(task.printTaskDetails());
            }
        }

        System.out.println("Total hours across all tasks: " + totalHours);
    }

    private static void showReport(TaskManager taskManager) {
        for (Task task : taskManager.getTasks()) {
            System.out.println(task.printTaskDetails());
        }
    }
}
