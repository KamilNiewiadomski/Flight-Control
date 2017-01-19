/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Runway {
    private double length, width;
    private short landingQueue, takingOffQueue, direction;
    private String surface;
    Runway(){
        this.setLength(Engine.inputDouble("Length: "));
        this.setWidth(Engine.inputDouble("Width: "));
        this.setDirection((short)Engine.inputDouble("Direction: "));
        this.setSurface(Engine.inputString("Surface: "));
    }
    void setLength(double length){
        this.length = length;
    }
    void setWidth(double width){
        this.width = width;
    }
    void setLandingQueue(short landingQueue){
        this.landingQueue = landingQueue;
    }
    void setTakingOffQueue(short takingOffQueue){
        this.takingOffQueue = takingOffQueue;
    }
    void setDirection(short direction){
        this.direction = direction;
    }
    void setSurface(String surface){
        this.surface = surface;
    }
    
    double getLength(){
        return this.length;
    }
    double getWidth(){
        return this.width;
    }
    short getLandingQueue(){
        return this.landingQueue;
    }
    short getTakingOffQueue(){
        return this.takingOffQueue;
    }
    short getDirection(){
        return this.direction;
    }
    String getSurface(){
        return this.surface;
    }
}