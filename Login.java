/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiiesetsopart3;

/**
 *
 * @author Lethabo Molate
 */
public class Login {
    public boolean returnLoginStatus(User user, String enteredUsername, String enteredPassword) {
        return user.loginUser(enteredUsername, enteredPassword);
    }

    public User createDefaultUser() {
        return new User("test_user", "Test@123", "John", "Doe");
    }    
}

