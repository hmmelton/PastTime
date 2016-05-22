package com.hmmelton.pasttime.Models;

import android.util.Base64;

/**
 * Created by harrisonmelton on 5/22/16.
 * Each instance of this class holds the information for one user.
 */
public class User {

    private String id;
    private String name;
    private String profilePicData;

    public User(String id, String name, String profilePicData) {
        this.id = id;
        this.name = name;
        this.profilePicData = profilePicData;
    }

    /**
     * This method returns the user's login ID.
     * @return user's login ID
     */
    public String getId() {
        return id;
    }

    /**
     * This method returns the user's name.
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns a byte array holding the data used to make the user's profile picture.
     * @return byte array of data about user's profile picture
     */
    public byte[] getProfilePicData() {
        return Base64.decode(profilePicData, Base64.DEFAULT);
    }
}
