/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Aircraft {
    private Coordinates location;
    public double speed = 0, speedX = 0, speedY = 0, speedZ = 0, acceleration = 0,
            fuelConsumption = 0, fuelLevel = 0, weight = 0;
    public double direction = 0.0;
    private String type, airLines, registration, status;
    public Flight flight;
    Aircraft(){
        this.setLocation(new Coordinates());
        this.setWeight(Engine.inputDouble(" "));
        this.setType(Engine.inputString(" "));
        this.setAirLines(Engine.inputString(" "));
        this.setRegistration(Engine.inputString(" "));
    }

    Aircraft(String registration, String type, String airLines) {
        this.setType(type);
        this.setAirLines(airLines);
        this.setRegistration(registration);
    }
    void setLocation(Coordinates location){
        this.location = location;
    }
    void setSpeed(double speed){
        this.speed = speed;
    }
    void setAcceleration(double acceleration){
        this.acceleration = acceleration;
    }
    void setSpeedZ(double speedZ){
        this.speedZ = speedZ;
    }
    void setFuelConsumption(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    void setFuelLevel(double fuelLevel){
        this.fuelLevel = fuelLevel;
    }
    void setWeight(double weight){
        this.weight = weight;
    }
    void setDirection(double direction){
        this.direction = direction;
    }
    void setType(String type){
        this.type = type;
    }
    void setAirLines(String airLines){
        this.airLines = airLines;
    }
    void setRegistration(String registration){
        this.registration = registration;
    }
    void setStatus(String status){
        this.status = status;
    }
    void setFlight(Flight flight){
        this.flight = flight;
    }
    Coordinates getLocation(){
        return this.location;
    }
    double getSpeed(){
        return this.speed;
    }
    double getAcceleration(){
        return this.acceleration;
    }
    double getSpeedZ(){
        return this.speedZ;
    }
    double getFuelConumption(){
        return this.fuelConsumption;
    }
    double getFuelLevel(){
        return this.fuelLevel;
    }
    double getWeight(){
        return this.weight;
    }
    double getDirection(){
        return this.direction;
    }
    String getType(){
        return this.type;
    }
    String getAirLines(){
        return this.airLines;
    }
    String getRegistration(){
        return this.registration;
    }
    String getStatus(){
        return this.status;
    }
    Flight getFlight(){
        return this.flight;
    }
}