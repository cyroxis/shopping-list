package com.brandenwilson.shoppinglist.core.common.models;

public class TestUser extends User {
    public TestUser() {
        super("::testToken::",new TestUserProfileInformation());
    }
}
