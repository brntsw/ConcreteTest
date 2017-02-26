package com.concrete.bruno.concretetest.model;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class Repository {

    //TODO Utilizar o Jackson

    private long id;
    private String name;
    private String description;
    private int numberForks;
    private int starGazersCount;
    private Owner owner;

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

    public int getNumberForks() {
        return numberForks;
    }

    public void setNumberForks(int numberForks) {
        this.numberForks = numberForks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarGazersCount() {
        return starGazersCount;
    }

    public void setStarGazersCount(int starGazersCount) {
        this.starGazersCount = starGazersCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
