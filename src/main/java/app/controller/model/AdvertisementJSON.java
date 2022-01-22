package app.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AdvertisementJSON {
    private Integer id;
    @JsonProperty("pet-name")
    private String petName;
    private List<String> signs;
    private Integer age;
    private String type;
    private LocationJSON location;
    private DateJSON date;
    @JsonProperty("owner-id")
    private Integer ownerId;

    public AdvertisementJSON() {
    }

    public AdvertisementJSON(Integer id, String petName, List<String> signs, Integer age, String type, LocationJSON location, DateJSON date, Integer ownerId) {
        this.id = id;
        this.petName = petName;
        this.signs = signs;
        this.age = age;
        this.type = type;
        this.location = location;
        this.date = date;
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public List<String> getSigns() {
        return signs;
    }

    public void setSigns(List<String> signs) {
        this.signs = signs;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocationJSON getLocation() {
        return location;
    }

    public void setLocation(LocationJSON location) {
        this.location = location;
    }

    public DateJSON getDate() {
        return date;
    }

    public void setDate(DateJSON date) {
        this.date = date;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}