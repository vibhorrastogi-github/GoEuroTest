/**
 * GeoPosition.java
 */
package com.goeuro.location.bean;

/**
 * Feb 20, 201612:59:53 PM
 *
 * @author vibhorr
 */
public class GeoPosition {

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude + "]";
    }

}
