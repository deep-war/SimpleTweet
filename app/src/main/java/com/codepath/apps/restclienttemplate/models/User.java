package com.codepath.apps.restclienttemplate.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
@Entity
public class User {

    @ColumnInfo
    @PrimaryKey
    public long id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String screenName;

    @ColumnInfo
    public String profileImageUrl;

    //Empty constructor for the parceler library
    public User(){
    }

    public static User fromJSON(JSONObject jsonObj) throws JSONException {
        User user = new User();
        user.name = jsonObj.getString("name");
        user.id = jsonObj.getLong("id");
        user.screenName = jsonObj.getString("screen_name");
        user.profileImageUrl = jsonObj.getString("profile_image_url_https");

        return user;
    }

    public static List<User> fromJSONTweetArray(List<Tweet> tweetsFromNetwork) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < tweetsFromNetwork.size() ; i++) {
            users.add(tweetsFromNetwork.get(i).user);
        }
        return users;
    }
}
