package app.repository.advertisement.model;

import app.repository.DateEntity;
import app.repository.location.model.LocationEntity;

import java.util.List;

public class AdvertisementEntity {
    private Integer id;
    private String petName;
    private List<String> signs;
    private Integer age;
    private String type;
    private Integer locationId;
    private DateEntity date;
    private Integer ownerId;

    public AdvertisementEntity() {
    }

    public AdvertisementEntity(Integer id, String petName, List<String> signs, Integer age, String type, Integer locationId, DateEntity date, Integer ownerId) {
        this.id = id;
        this.petName = petName;
        this.signs = signs;
        this.age = age;
        this.type = type;
        this.locationId = locationId;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public DateEntity getDate() {
        return date;
    }

    public void setDate(DateEntity date) {
        this.date = date;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
