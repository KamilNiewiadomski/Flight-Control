/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kamil
 */
public class Engine {

    
    public static final ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
    public static final ArrayList<Airport> airports = new ArrayList<Airport>();
    static private FlightControl flightControl;
    private static int linesNumber;
    public static String inputString(String communique){
        String line = null;
        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(communique);
        try{
            line = inbr.readLine();
        }catch(IOException e){
            System.out.println("xxx");
        }
        return line;
    }
    
    public static boolean inputBoolean(String communique){
        String line = null;
        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(communique);
        try{
            line = inbr.readLine();
        }catch(IOException e){
            System.out.println("xxx");
        }
        if(line=="true"){
            return true;
        }else{
            return false;
        }
    }
    
    public static double inputDouble(String communique){
        Reader r = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer inp = new StreamTokenizer(r);
        System.out.print(communique);
        try{
            inp.nextToken();
            return inp.nval;
        }catch(IOException e){
            System.out.println("xxx");
        }
        return -1;
    }
    
    public static void flightControlIni(){
        flightControl = new FlightControl();
    }
    
    public static void main( String args[] )
    {
        Login login = new Login();
    }

    static FlightControl getFlightControl() {
        return flightControl;
    }
    static boolean anyList() {
        return !aircrafts.isEmpty();
    }

    static int aircraftsGetSize() {
        return aircrafts.size();
    }

    static String getAircraftRegistration(int i) {
        return aircrafts.get(i).getRegistration();
    }
    
    static String getAircraftType(int i) {
        return aircrafts.get(i).getType();
    }
    
    static String getAircraftAirLines(int i) {
        return aircrafts.get(i).getAirLines();
    }

    static void addAircraft(String registration, String type, String airLines,
            boolean save) {
        aircrafts.add(new Aircraft(registration, type, airLines));
        if(save){
            aircraftsSave(registration, type, airLines);
        }
        flightControl.setAddFlightEnable(true);
    }
    static void addAirport(String name, String nameIATA, String city,
            String state, short numberOfRunways, double lat, double longi, 
                double alt, boolean save){
        airports.add(new Airport(name, nameIATA, city, state, numberOfRunways, 
        new Coordinates(lat, longi, alt)));
        if(save){
            airportSave(name, nameIATA, city, state, numberOfRunways, lat, 
                    longi, alt);
        }
        flightControl.setAddFlightEnable(true);
    }

    static void editAircraft(String text, String text0, String text1, int index) {
        aircrafts.get(index).setRegistration(text);
        aircrafts.get(index).setType(text0);
        aircrafts.get(index).setAirLines(text1);
    }

    static void sync() {
        aircraftsSync();
        airportsSync();
    }

    private static void aircraftsSync() {
        String line = "", line1 ="", line2 ="", line3 ="";
        int i = 0;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream("Aircrafts.txt");
        }catch(FileNotFoundException e){
            
        }
        DataInputStream out = new DataInputStream(fin);
        BufferedReader inbr = new BufferedReader(new InputStreamReader(fin));
        try{
            while((line = inbr.readLine()) != null){
                switch(i%3){
                    case 0:
                        line1 = line;
                        break;
                    case 1:
                        line2 = line;
                        break;
                    case 2:
                        line3 = line;
                        break;
                }
                i++;
                if(i%3==0 && i>0){
                    addAircraft(line1, line2, line3, false);
                }
            }
        }catch(IOException e){
            
        }
    }
    private static void aircraftsSave(String registration, String type, String airLines){
        String  line1 = registration, line2 = type, line3 = airLines;
        BufferedWriter output = null;
        try{
            output = new BufferedWriter(new FileWriter("Aircrafts.txt", true));
            output.append(line1);
            output.newLine();
            output.append(line2);
            output.newLine();
            output.append(line3);
            output.newLine();
            output.close();
        }catch(IOException e){
        }
        
    }

    static int airportsGetSize() {
        return airports.size();
    }

    static String getAirportName(int i) {
        return airports.get(i).getName();
    }

    private static void airportSave(String name, String nameIATA, String city, 
            String state, short numberOfRunways, double lat, double longi, double alt) {
        String  line1 = name, line2 = nameIATA, line3 = city, line4 = state,
                line5 = String.valueOf(numberOfRunways), line6 = String.valueOf(lat), 
                line7 = String.valueOf(longi), line8 = String.valueOf(alt);
        BufferedWriter output = null;
        try{
            output = new BufferedWriter(new FileWriter("Airports.txt", true));
            output.append(line1);
            output.newLine();
            output.append(line2);
            output.newLine();
            output.append(line3);
            output.newLine();
            output.append(line4);
            output.newLine();
            output.append(line5);
            output.newLine();
            output.append(line6);
            output.newLine();
            output.append(line7);
            output.newLine();
            output.append(line8);
            output.newLine();
            output.close();
        }catch(IOException e){
        }
    }

    private static void airportsSync() {
        String line = "", line1 ="", line2 ="", line3 ="", line4 ="", 
                line5 ="", line6 ="", line7 ="", line8 ="";
        int i = 0;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream("Airports.txt");
        }catch(FileNotFoundException e){
            
        }
        DataInputStream out = new DataInputStream(fin);
        BufferedReader inbr = new BufferedReader(new InputStreamReader(fin));
        try{
            while((line = inbr.readLine()) != null){
                switch(i%8){
                    case 0:
                        line1 = line;
                        break;
                    case 1:
                        line2 = line;
                        break;
                    case 2:
                        line3 = line;
                        break;
                    case 3:
                        line4 = line;
                        break;
                    case 4:
                        line5 = line;
                        break;
                    case 5:
                        line6 = line;
                        break;
                    case 6:
                        line7 = line;
                        break;
                    case 7:
                        line8 = line;
                        break;
                }
                i++;
                if(i%8==0 && i>0){
                    addAirport(line1, line2, line3, line4, 
                            Short.parseShort(line5),  
                            Double.parseDouble(line6), 
                            Double.parseDouble(line7), 
                            Double.parseDouble(line5),false);
                }
            }
        }catch(IOException e){
            
        }
    }
    
    void addLinesNumber(int i){
        linesNumber+=i;
    }
    int getLinesNumber(){
        return linesNumber;
    }
}