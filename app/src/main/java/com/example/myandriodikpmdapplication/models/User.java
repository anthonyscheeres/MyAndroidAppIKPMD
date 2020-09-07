package com.example.myandriodikpmdapplication.models;

public class User {
    private String profilePicture;
    private String userID;

    public User(String profilePicture, String userID) {
        this.profilePicture = profilePicture;
        this.userID = userID;
    }

    public User(String userID) {
        this.userID = userID;
    }

    public User() {
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
