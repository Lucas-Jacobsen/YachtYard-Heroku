package com.yacht.model;

public class UserModel {
    
    private int id; 
    private String username;
    private String password; 
    private String role; 
    private int enabled;
   
    public UserModel()
     {
        id = 0; 
        username = "";
        password = ""; 
        role = "ROLE_USER";
        enabled = 1;
    }

    public UserModel(int id, String username, String password, String role, int enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    } 


    

}
