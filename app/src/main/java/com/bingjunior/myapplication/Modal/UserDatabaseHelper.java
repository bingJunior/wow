package com.bingjunior.myapplication.Modal;

public class UserDatabaseHelper {
    String name,mobilenumber,email,password;

    public UserDatabaseHelper() {
    }

    public UserDatabaseHelper(String name, String mobilenumber, String email, String password) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
