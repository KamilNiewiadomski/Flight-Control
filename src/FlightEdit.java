
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
class FlightEdit extends JFrame implements ActionListener{

    static double checkDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JTextField jTextField1, jTextField2, jTextField3;
    private JComboBox select , select1, select2;
 
    FlightEdit(){
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setSize(300,340);
        this.setTitle("AircraftEdit");
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setAlwaysOnTop(true);
        
        JLabel jLabel1 = new JLabel("Flight editor");
        jLabel1.setBounds(50, 20, 200, 20);
        add(jLabel1);
        
        JLabel jLabel2 = new JLabel("Aircraft:");
        jLabel2.setBounds(50, 45, 200, 20);
        add(jLabel2);
        
        select = new JComboBox();
        select.setBounds(50, 70, 200, 20);
        for(int i=0; i<Engine.aircraftsGetSize(); i++){
//            if(Engine.aircrafts.get(i).flight==null){
//                select.addItem(Engine.getAircraftRegistration(i));
//            }
            select.addItem(Engine.getAircraftRegistration(i));
        }
        add(select);
        
        JLabel jLabel3 = new JLabel("Flight number:");
        jLabel3.setBounds(50, 95, 200, 20);
        add(jLabel3);
        
        jTextField2 = new JTextField();
        jTextField2.setBounds(50, 120, 200, 20);
        add(jTextField2);
        
        JLabel jLabel4 = new JLabel("Origin:");
        jLabel4.setBounds(50, 145, 200, 20);
        add(jLabel4);
        
        select1 = new JComboBox();
        select1.setBounds(50, 170, 200, 20);
        for(int i=0; i<Engine.airportsGetSize(); i++){
                    select1.addItem(Engine.getAirportName(i));
                }
        add(select1);
        
        JLabel jLabel5 = new JLabel("Destination:");
        jLabel5.setBounds(50, 195, 200, 20);
        add(jLabel5);
        
        select2 = new JComboBox();
        select2.setBounds(50, 220, 200, 20);
        for(int i=0; i<Engine.airportsGetSize(); i++){
                    select2.addItem(Engine.getAirportName(i));
                }
        add(select2);
        
        JButton button2 = new JButton("Add payload");
        button2.setBounds(50, 245, 200, 30);
        button2.addActionListener(this);
        this.add(button2);
        
        JButton button = new JButton("Cancel");
        button.setBounds(155, 280, 75, 30);
        button.addActionListener(this);
        this.add(button);
        
        JButton button1 = new JButton("Add");
        button1.setBounds(70, 280, 75, 30);
        button1.addActionListener(this);
        this.add(button1);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if("Save".equals(cmd)){
            
        }
        if("Add".equals(cmd)){
            int var = select.getSelectedIndex(), var1 = select1.getSelectedIndex(),
                    var2 = select2.getSelectedIndex();
            Airport ori = Engine.airports.get(var1), 
                    des = Engine.airports.get(var2);
            double distance = sqrt(abs((ori.getLocation().getLongitude()-
                    des.getLocation().getLongitude())+(ori.getLocation().getLatitude()-
                            des.getLocation().getLatitude())));
            Engine.aircrafts.get(var).flight = new Flight(ori, des);
            Engine.aircrafts.get(var).setLocation(new Coordinates(ori.getLocation()));
            Engine.aircrafts.get(var).setDirection(checkDirection(ori, des));
            Engine.aircrafts.get(var).speed = 0.6;
        }
        Engine.getFlightControl().setEnabled(true);
        dispose();
    }

    static public double checkDirection(Airport ori, Airport des) {
        double x;
        x = (ori.getLocation().getLongitude()-des.getLocation().getLongitude())/
                (ori.getLocation().getLatitude()-des.getLocation().getLatitude());
        if((ori.getLocation().getLatitude()-des.getLocation().getLatitude())>=0){
            double h = toDegrees(atan(x));
            h+=180;
            return toRadians(h);
        }
        return atan(x);
    }
    
}
