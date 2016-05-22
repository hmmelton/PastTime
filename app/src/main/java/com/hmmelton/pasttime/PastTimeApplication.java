package com.hmmelton.pasttime;

import android.app.Application;

import com.hmmelton.pasttime.Models.User;

/**
 * Created by harrisonmelton on 5/21/16.
 */
public class PastTimeApplication extends Application {

    private static PastTimeApplication instance;
    private static User user;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    /**
     * This method returns the current instance of the application file.
     * @return current instance of PastTimeApplication
     */
    public static PastTimeApplication getInstance() {
        return instance;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User newUser) {
        user = newUser;
    }
}
