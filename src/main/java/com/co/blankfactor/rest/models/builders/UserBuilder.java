package com.co.blankfactor.rest.models.builders;

import com.co.blankfactor.rest.models.User;
import lombok.*;
@Data

public class UserBuilder {
    private String name;
    private String jobTitle;

    public UserBuilder(){
        this.name = "";
        this.jobTitle = "";
    }

    public static UserBuilder with(){
        return new UserBuilder();
    }

    public UserBuilder theName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder andJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
        return this;
    }

    public User build(){
        return new User(this);
    }
}
