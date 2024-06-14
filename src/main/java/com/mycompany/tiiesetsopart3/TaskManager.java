/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiiesetsopart3;

/**
 *
 * @author Lethabo Molate
 */
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        tasks.add(new Task(taskName, taskNumber, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }

    public List<String> displayTasksByStatus(String status) {
        List<String> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskStatus().equalsIgnoreCase(status)) {
                result.add("Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + ", Task Name: " + task.getTaskName() + ", Task Duration: " + task.getTaskDuration());
            }
        }
        return result;
    }

    public String getLongestTask() {
        if (tasks.isEmpty()) {
            return "No tasks available";
        }
        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }
        return "Developer: " + longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName() + ", Duration: " + longestTask.getTaskDuration();
    }

    public String searchTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return "Task Name: " + task.getTaskName() + ", Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + ", Task Status: " + task.getTaskStatus();
            }
        }
        return "Task not found";
    }

    public List<String> searchTasksByDeveloper(String developerFirstName, String developerLastName) {
        List<String> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDeveloperFirstName().equalsIgnoreCase(developerFirstName) && task.getDeveloperLastName().equalsIgnoreCase(developerLastName)) {
                result.add("Task Name: " + task.getTaskName() + ", Task Status: " + task.getTaskStatus());
            }
        }
        return result;
    }

    public boolean deleteTaskByName(String taskName) {
        return tasks.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
    }

    public List<String> displayAllTasks() {
        List<String> result = new ArrayList<>();
        for (Task task : tasks) {
            result.add("Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + ", Task Name: " + task.getTaskName() + ", Task ID: " + task.createTaskID() + ", Task Duration: " + task.getTaskDuration() + ", Task Status: " + task.getTaskStatus());
        }
        return result;
    }
}

