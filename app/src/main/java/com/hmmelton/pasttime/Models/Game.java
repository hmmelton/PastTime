package com.hmmelton.pasttime.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

/**
 * Created by harrisonmelton on 6/7/16.
 */
public class Game {

    private JSONObject mGame; // JSON object holding information of game instance

    /**
     * Constructor for Game object.
     * @param json String of JSON data used to create object instance
     */
    public Game(String json) throws JSONException {
        mGame = new JSONObject(json);
    }

    /**
     * This method returns the name of the away team associated with this game.
     * @return name of away team
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public String getAwayTeam() throws JSONException {
        return mGame.getString("away_team");
    }

    /**
     * This method returns the name of the home team associated with this game.
     * @return name of home team
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public String getHomeTeam() throws JSONException {
        return mGame.getString("home_team");
    }

    /**
     * This method returns the date on which this game is played.
     * @return date of game
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public Date getDate() throws JSONException {
        // TODO: create date object from
        return null;
    }

    /**
     * This method returns the average user rating for this game.
     * @return average rating of game
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public double getRating() throws JSONException {
        return mGame.getDouble("rating");
    }

    /**
     * This method returns the number of votes for this game that have been submitted by users.
     * @return number of votes submitted by users
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public int getVotes() throws JSONException {
        return mGame.getInt("votes");
    }

    /**
     * This method returns all the comments for this game that have been submitted by users.
     * @return users' comments on this game
     * @throws JSONException thrown if exception is raised while searching JSON
     */
    public String[] getComments() throws JSONException {
        // pull array from JSON object
        JSONArray comments =  mGame.getJSONArray("comments");

        return comments
                .toString() // convert to a String
                .replace("[", "") // replace opening and closing brackets
                .split(","); // split into array at each comma
    }


}
