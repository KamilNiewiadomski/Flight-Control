
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
class Controller extends User {
    private Tower tower;
    private ArrayList aircrafts = new ArrayList();
    void setTower(Tower tower){
        this.tower = tower;
    }
    void addAircraft(Aircraft aircraft){
        this.aircrafts.add(aircraft);
    }
    void removeAircraft(Aircraft aircraft){
        this.aircrafts.remove(aircraft);
    }
    Aircraft getAircraft(int index){
        return (Aircraft) this.aircrafts.get(index);
    }
    Tower getTower(){
        return this.tower;
    }
}