package com.brandenwilson.shoppinglist.tests.common.models;

public class TestUser extends User {
    public TestUser() {
        super("::testToken::",new TestUserProfileInformation());
    }
}
