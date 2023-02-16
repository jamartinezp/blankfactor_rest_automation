package com.co.blankfactor.rest.models;

import com.co.blankfactor.rest.models.builders.UserBuilder;
import lombok.*;

@Data
public class User {
    private String name;
    private String jobTitle;

    public User(UserBuilder userBuilder){
        this.name = userBuilder.getName();
        this.jobTitle = userBuilder.getJobTitle();
    }
}
