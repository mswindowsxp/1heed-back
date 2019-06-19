package io.uetunited.oneheed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.uetunited.oneheed.constant.UserType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
    private String name;
    private Picture picture;
    private String id;
    private UserType userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
