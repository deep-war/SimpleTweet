package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    public String name;
    public String screenName;
    public String profileImageUrl;

    public static User fromJSON(JSONObject jsonObj) throws JSONException {
        User user = new User();
        user.name = jsonObj.getString("name");
        user.screenName = jsonObj.getString("screen_name");
        user.profileImageUrl = jsonObj.getString("profile_image_url_https");

        return user;
    }
}
