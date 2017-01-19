
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
class Systems {
    private List<String> systems = new ArrayList();
    Systems(short numberOfSystems){
        for(short i = numberOfSystems; i>0; i--){
            systems.add(Engine.inputString("Type system: "));
        }
    }
    void addSystems(String system){
        systems.add(system);
    }
    void getSystem(int index){
        System.out.println(systems.get(index-1).toString());
    }
    void getSystems(){
        System.out.print("Systems:[");
        for(int i=systems.size(); i>0; i--){
            System.out.print(systems.get(i-1).toString());
            if(i>1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}