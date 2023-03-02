package com.co.blankfactor.rest.models.builders;

import com.co.blankfactor.rest.models.User;
import lombok.*;

@Data
public class UserBuilder {
    private String name;
    private String jobTitle;
    private String email;
    private String password;

    public static UserBuilder with() {
        return new UserBuilder();
    }

    public UserBuilder theName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder theEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder andThePassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder andJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
