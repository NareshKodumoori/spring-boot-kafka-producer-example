package com.techprimers.kafka.springbootkafkaproducerexample.model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String userEmail;

    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{ userName='" + userName + '\'' + ", userEmail='" + userEmail + '\'' + '}';
    }
}
