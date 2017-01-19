
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
class Flight {
    private Tower tower;
    private short flightNumber;
    private Controller controller;
    private Runway runway;
    public Airport origin, destination;
    public double distance;
    private Payload payload;
    private Path path;
    
    public Flight(Airport origin, Airport destination){
        this.origin = origin;
        this.destination = destination;
        this.distance = Distance(origin, destination);
    }

    private static class Payload {

        public Payload() {
        }
    }
    double Distance(Airport ori, Airport des){
        double distance = sqrt(abs((ori.getLocation().getLongitude()-
                    des.getLocation().getLongitude())+(ori.getLocation().getLatitude()-
                            des.getLocation().getLatitude())));
        return distance;
    }
}
