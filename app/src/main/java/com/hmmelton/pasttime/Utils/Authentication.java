package com.hmmelton.pasttime.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.hmmelton.pasttime.Models.User;
import com.hmmelton.pasttime.PastTimeApplication;

/**
 * Created by harrisonmelton on 5/21/16.
 * This class is used to check the user's login credentials.
 */
public class Authentication {

    // keys used to access locally stored files
    private static final String PREFS_FILE = "UserPreferences";
    private static final String USER_NAME = "com.pasttime.username";
    private static final String USER_ID = "com.pasttime.user_id";
    private static final String USER_PROFILE_PIC = "com.pasttime.user_profile";

    private static final Context CONTEXT =
            PastTimeApplication.getInstance().getApplicationContext();

    @SuppressWarnings("unused")
    private final String TAG = this.getClass().getSimpleName();

    /**
     * This method checks whether or not the user's credentials have been stored on the device.
     * @return true if the user has already logged in on this device, false if the user has not
     * logged in yet, or has logged out
     */
    public static boolean areCredentialsStored() {
        SharedPreferences preferences = CONTEXT.getSharedPreferences(PREFS_FILE, 0);

        // retrieve user's information from local storage
        String id = preferences.getString(USER_ID, null);
        String username = preferences.getString(USER_NAME, null);
        String profilePic = preferences.getString(USER_PROFILE_PIC, null);

        if (username == null || id == null || profilePic == null) {
            // user has missing or incomplete credentials
            return false;
        }

        // store user's information to be globally accessible
        PastTimeApplication.setUser(new User(id, username, profilePic));

        return true;
    }

    /**
     * This method is used to save user login information to local storage.
     * @param id user's ID
     * @param name user's name
     * @param profilePicData byte array of user's profile picture data
     */
    public static void setUser(String id, String name, byte[] profilePicData) {
        // Initiate global User object, so information does not have to be drawn from local storage
        // each time the app needs user info.
        PastTimeApplication.setUser(new User(id, name,
                Base64.encodeToString(profilePicData, Base64.DEFAULT)));

        SharedPreferences preferences = CONTEXT.getSharedPreferences(PREFS_FILE, 0);
        SharedPreferences.Editor editor = preferences.edit();

        // set all the user's login info
        editor.putString(USER_ID, id);
        editor.putString(USER_NAME, name);
        editor.putString(USER_PROFILE_PIC, Base64.encodeToString(profilePicData, Base64.DEFAULT));

        editor.commit();

    }

    public static void unauthorize() {
        PastTimeApplication.setUser(null);
        setUser(null, null, null);
    }
}
