/**
 * Location.java
 */
package com.goeuro.location.bean;

/**
 * Feb 20, 201612:56:26 PM
 *
 * @author vibhorr
 */
public class Location {

    private Long _id;

    private String key;

    private String name;

    private String fullName;

    private String iata_airport_code;

    private String type;

    private String country;

    private String locationId;

    private String countryCode;

    private boolean coreCountry;

    private boolean inEurope;

    private Long distance;

    private GeoPosition geo_position;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public GeoPosition getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(GeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    @Override
    public String toString() {
        return "Location [_id=" + _id + ", key=" + key + ", name=" + name + ", fullName=" + fullName
                + ", iata_airport_code=" + iata_airport_code + ", type=" + type + ", country="
                + country + ", locationId=" + locationId + ", countryCode=" + countryCode
                + ", coreCountry=" + coreCountry + ", inEurope=" + inEurope + ", distance="
                + distance + ", geo_position=" + geo_position + "]";
    }

}
