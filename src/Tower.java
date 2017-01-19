
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
public class Tower {
    private double range;
    private Coordinates location;
    private ArrayList airports = new ArrayList();
    private ArrayList controllers = new ArrayList();
    private ArrayList aircrafts = new ArrayList();
    Tower(){
        this.setLocation(new Coordinates());
        this.setRange(Engine.inputDouble(" "));
    }
    void addAirport(Airport airport){
        this.airports.add(airport);
    }
    void addController(Controller controller){
        this.controllers.add(controller);
    }
    void addAircraft(Aircraft aircraft){
        this.aircrafts.add(aircraft);
    }
    void setRange(double range){
        this.range = range;
    }
    void setLocation(Coordinates location){
        this.location = location;
    }
    void removeAirport(Airport airport){
        this.airports.remove(airport);
    }
    void removeController(Controller controller){
        this.controllers.remove(controller);
    }
    void removeAircraft(Aircraft aircraft){
        this.aircrafts.remove(aircraft);
    }
    Airport getAirport(int index){
        return (Airport) this.airports.get(index);
    }
    Controller getController(int index){
        return (Controller) this.controllers.get(index);
    }
    Aircraft getAircraft(int index){
        return (Aircraft) this.aircrafts.get(index);
    }
    double getRange(){
        return this.range;
    }
    Coordinates getLocation()   {
        return this.location;
    }
    
}