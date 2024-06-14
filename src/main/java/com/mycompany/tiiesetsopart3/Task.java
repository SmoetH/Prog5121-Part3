/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiiesetsopart3;

/**
 *
 * @author Lethabo Molate
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return (taskName.substring(0, 2) + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3)).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerFirstName + " " + developerLastName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + createTaskID() + "\n" +
                "Task Duration: " + taskDuration + " hours";
    }

    public int returnTotalHours() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskName() {
        return taskName;
    }
}

