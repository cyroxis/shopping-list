package com.brandenwilson.shoppinglist.core.common.models;

public class User {

    public final String authToken;
    public final UserProfileInformation userProfileInformation;

    public User(String authToken, UserProfileInformation userProfileInformation) {
        this.authToken = authToken;
        this.userProfileInformation = userProfileInformation;
    }
}
