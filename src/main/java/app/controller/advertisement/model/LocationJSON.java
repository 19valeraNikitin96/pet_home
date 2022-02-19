package app.controller.advertisement.model;

public class LocationJSON {
    private Integer id;
    private String city;
    private String district;
    private String street;

    public LocationJSON() {
    }

    public LocationJSON(Integer id, String city, String district, String street) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

