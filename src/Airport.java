
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Airport {
    private String name, nameIATA, city, state, status;
    private short numberOfRunways, timeZone;
    private Coordinates location;
    private Weather weather;
    private Systems systems;
    private Tower tower;
    private ArrayList runways = new ArrayList();
    
    Airport(){
//        this.setName(Engine.inputString(Strings.setNameCom));
//        this.setNameIATA(Engine.inputString(Strings.setNameIATACom));
//        this.setCity(Engine.inputString(Strings.setCityCom));
//        this.setState(Engine.inputString(Strings.setStateCom));
//        this.setLocation(new Coordinates());
//        this.setSystems(new Systems((short) 
//                Engine.inputDouble("Type number of systems: ")));
//        this.setNumberOfRunways((short) 
//                Engine.inputDouble(Strings.setNumberOfRunwaysCom));
//        for(int i=0; i<numberOfRunways; i++){
//            System.out.println(i+1+". RUNWAY");
//            runways.add(new Runway());
//        }
    }

    Airport(String name, String nameIATA, String city, String state, short numberOfRunways, Coordinates coordinates) {
        this.name = name;
        this.nameIATA = nameIATA;
        this.city = city;
        this.state = state;
        this.numberOfRunways = numberOfRunways;
        this.location = coordinates;
    }
    
    void setName(String name){
        this.name = name;
    }
    void setNameIATA(String nameIATA){
        this.nameIATA = nameIATA;
    }
    void setCity(String city){
        this.city = city;
    }
    void setState(String state){
        this.state = state;
    }
    void setStatus(String status){
        this.status = status;
    }
    void setNumberOfRunways(short numberOfRunways){
        this.numberOfRunways = numberOfRunways;
    }
    void setLocation(Coordinates location){
        this.location = location;
    }
    void setWeather(Weather weather){
        this.weather = weather;
    }
    void setTower(Tower tower){
        this.tower = tower;
    }
    void setSystems(Systems systems){
        this.systems = systems;
    }
    void addRunway(Runway runway){
        this.runways.add(runway);
    }
    void removeRunway(Runway runway){
        this.runways.remove(runway);
    }
    String getName(){
        return this.name;
    }
    String getNameIATA(){
        return this.nameIATA;
    }
    String getCity(){
        return this.city;
    }
    String getState(){
        return this.state;
    }
    String getStatus(){
        return this.status;
    }
    Short getNumberOfRunways(){
        return this.numberOfRunways;
    }
    Coordinates getLocation(){
        return this.location;
    }
    Weather getWeather(){
        return this.weather;
    }
    Tower getTower(){
        return this.tower;
    }
    Systems getSystems(){
        return this.systems;
    }
    Runway getRunway(int index){
        return (Runway) this.runways.get(index);
    }
    void printInformations(){
        System.out.println("AIRPORT");
        System.out.println("Name: " + name);
        System.out.println("IATA name: " + nameIATA);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Location(lat,lon,alt): "+location.getLatitude()+" "
                +location.getLongitude()+" "+location.getAltitude()+"m");
        System.out.println("Number of runways: " + numberOfRunways);
          systems.getSystems();
    } 
}