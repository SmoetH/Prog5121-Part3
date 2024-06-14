/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiiesetsopart3;

/**
 *
 * @author Lethabo Molate
 */
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Static method to create a default user
    public static User createDefaultUser() {
        return new User("test_user", "Test@123", "John", "Doe");
    }

    // Method for checking username validity
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Method for checking password complexity
    public boolean checkPasswordComplexity() {
        // Check if password is null or too short
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, lowercase letter, digit, and special character
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            } else {
                containsSpecialChar = true;
            }
        }

        return containsUpperCase && containsLowerCase && containsDigit && containsSpecialChar;
    }

    // Method for registering user
    public String registerUser() {
        if (checkUserName() && checkPasswordComplexity()) {
            return "User " + firstName + " " + lastName + " registered successfully";
        } else {
            return "Registration unsuccessful. Please check username and password requirements.";
        }
    }

    // Method for login
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }  
}

