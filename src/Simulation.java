
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Simulation {
    static long lastUpdateTime, lastCreateTime;
    private Random rand = new Random();
    public boolean isRunning = false;
    public void start(){
        lastUpdateTime = System.currentTimeMillis();
        isRunning = true;
    }
    public void pause(){
        isRunning = false;
    }
    public void update(){
        if((System.currentTimeMillis()-lastUpdateTime)>5){
            lastUpdateTime = System.currentTimeMillis();
            if(System.currentTimeMillis()-lastCreateTime>1000){
                lastCreateTime = System.currentTimeMillis();
                System.out.println("AAA");
                createFlight();
            }
            for(Aircraft aircraft : Engine.aircrafts){
                if(aircraft.flight != null){
                    if(checkArival(aircraft)){
                        aircraft.flight = null;
                    }
                    if(aircraft.acceleration!=0){
                        aircraft.speed += aircraft.acceleration;
                    }
                    if(aircraft.speed!=0){
                        speedDecomposition(aircraft, aircraft.speed);
                    }
                    if(aircraft.speedX!=0){
                        aircraft.getLocation().setLatitude(aircraft.getLocation().getLatitude()+
                                aircraft.speedX);
                    }
                    if(aircraft.speedY!=0){
                        aircraft.getLocation().setLongitude(aircraft.getLocation().getLongitude()+
                                aircraft.speedY);
                    }
                }
                
            }
        }
    }

    private void speedDecomposition(Aircraft aircraft, double speed) {
        double x = aircraft.getDirection();
        aircraft.speedX = cos(x)*speed;
        aircraft.speedY = sin(x)*speed;
    }

    private boolean checkArival(Aircraft aircraft) {
      double distance = sqrt(abs((aircraft.getLocation().getLongitude()-
                    aircraft.flight.destination.getLocation().getLongitude())+
                        (aircraft.getLocation().getLatitude()-
                            aircraft.flight.destination.getLocation().getLatitude())));
      
      if(distance<=aircraft.getFlight().distance){
          aircraft.getFlight().distance=distance;
          return false;
      }else{
          return true;
      }
    }
    void createFlight(){
        int z = rand.nextInt(Engine.aircraftsGetSize());
        Aircraft aircraft = Engine.aircrafts.get(z);
        if(aircraft.flight == null){
            int x = rand.nextInt(Engine.airportsGetSize()), y;
            do{
                y = rand.nextInt(Engine.airportsGetSize());
            }while(x==y);
            Airport ori = Engine.airports.get(x),
                    des = Engine.airports.get(y);
            aircraft.flight = new Flight(ori, des);
            aircraft.setLocation(new Coordinates(ori.getLocation()));
            aircraft.setDirection(FlightEdit.checkDirection(ori, des));
            aircraft.speed = (rand.nextDouble() + 0.8)/8.0;
        }
    }
    
}
