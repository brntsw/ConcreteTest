package com.concrete.bruno.concretetest.model;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class Owner {

    //TODO Utilizar o Jackson

    private long id;
    private String name;
    private String avatarUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
