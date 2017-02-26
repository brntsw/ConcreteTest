package com.concrete.bruno.concretetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BRUNO on 23/02/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    //TODO Utilizar o Jackson
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("forks_count")
    private int numberForks;
    @JsonProperty("stargazers_count")
    private int starGazersCount;
    @JsonProperty("owner")
    private Owner owner;

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
