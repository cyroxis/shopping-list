package com.brandenwilson.shoppinglist.core.common.models;

import org.apache.commons.lang3.StringUtils;

public class Credentials {
    public final String email;
    public final String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Credentials) {
            Credentials credentials = (Credentials) obj;
            return StringUtils.equals(email, credentials.email) &&
                    StringUtils.equals(password, credentials.password);
        } else {
            return false;
        }
    }
}
