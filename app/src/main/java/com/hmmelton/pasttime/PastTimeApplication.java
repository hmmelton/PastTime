package com.hmmelton.pasttime;

import android.app.Application;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.hmmelton.pasttime.Models.User;

/**
 * Created by harrisonmelton on 5/21/16.
 */
public class PastTimeApplication extends Application {

    private static final String TAG = "PastTimeApplication";

    private static PastTimeApplication instance; // global context
    private static User user; // global user information

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, instance + "");
        instance = this;
        Log.e(TAG, instance + "");
        // initialize Facebook SDK and Facebook analytics
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
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
