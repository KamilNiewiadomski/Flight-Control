/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
final class Coordinates {
    private double latitude, longitude, altitude;
    Coordinates(){
        this.setLatitude(Engine.inputDouble(Strings.setLatitudeCom));
        this.setLongitude(Engine.inputDouble(Strings.setLongitudeCom));
        this.setAltitude(Engine.inputDouble(Strings.setAltitudeCom));
    }
    Coordinates(double latitude, double longitude, double altitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    Coordinates(Coordinates location) {
        this.altitude = location.altitude;
        this.latitude = location.latitude;
        this.longitude = location.longitude;
    }
    
    void setLatitude(double latitude){
        this.latitude = latitude;
    }
    void setLongitude(double longitude){
        this.longitude = longitude;
    }
    void setAltitude(double altitude){
        this.altitude = altitude;
    }
    double getLatitude(){
        return latitude;
    }
    double getLongitude(){
        return longitude;
    }
    double getAltitude(){
        return altitude;
    }
}