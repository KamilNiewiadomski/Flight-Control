
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public class Edit extends JFrame implements ActionListener{
    JComboBox operations, objects, select;
    Edit(){
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setSize(300,230);
        this.setTitle("Edit");
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setAlwaysOnTop(true);
        
        JLabel jLabel1 = new JLabel("Operations:");
        add(jLabel1);
        jLabel1.setBounds(50, 20, 200, 20);
        
        operations = new JComboBox();
        operations.setBounds(50, 45, 200, 20);
        operations.addItem("New");
        operations.setActionCommand("cmdOPER");
        operations.addActionListener(this);
        if(Engine.anyList()){
            operations.addItem("Edit");
            operations.addItem("Remove");
        }
        operations.setEnabled(true);
        this.add(operations);
        
        JLabel jLabel2 = new JLabel("Object type:");
        add(jLabel2);
        jLabel2.setBounds(50, 70, 200, 20);
        
        objects = new JComboBox();
        objects.setBounds(50, 95, 200, 20);
        objects.addItem("Aircraft");
        objects.addItem("Airport");
        objects.addItem("Tower");
        objects.addItem("User");
        objects.addActionListener(this);
        objects.setActionCommand("OBJ");
        add(objects);
        
        JLabel jLabel3 = new JLabel("Select:");
        add(jLabel3);
        jLabel3.setBounds(50, 120, 200, 20);
        
        select = new JComboBox();
        select.setBounds(50, 145, 200, 20);
        select.setEnabled(false);
        add(select);
        
        JButton button1 = new JButton("Next");
        button1.setBounds(70, 180, 75, 30);
        button1.addActionListener(this);
        this.add(button1);
        
        JButton button = new JButton("Cancel");
        button.setBounds(155, 180, 75, 30);
        button.addActionListener(this);
        this.add(button);
        
        this.setVisible(true);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if("Cancel".equals(cmd)){
            Engine.getFlightControl().setEnabled(true);
            dispose();
        }
        if(operations.getSelectedItem()=="Edit" || 
                operations.getSelectedItem()=="Remove"){
            select.setEnabled(true);
            select.removeAllItems();
            if(objects.getSelectedItem()=="Aircraft"){
                select.removeAllItems();
                for(int i=0; i<Engine.aircraftsGetSize(); i++){
                    select.addItem(Engine.getAircraftRegistration(i));
                }
            }
            if(objects.getSelectedItem()=="Airport"){
                select.removeAllItems();
                for(int i=0; i<Engine.airportsGetSize(); i++){
                    select.addItem(Engine.getAirportName(i));
                }
            }
        }else{
            select.setEnabled(false);
            select.removeAllItems();
        }
        if("Next".equals(cmd)){
            if(operations.getSelectedItem()=="New"){
                if(objects.getSelectedItem()=="Aircraft"){
                    AircraftEdit aircraftEdit = new AircraftEdit();
                }
                if(objects.getSelectedItem()=="Airport"){
                    AirportEdit airportEdit = new AirportEdit();
                }
            }
            if(operations.getSelectedItem()=="Edit"){
                if(objects.getSelectedItem()=="Aircraft"){
                    int var = select.getSelectedIndex();
                    AircraftEdit aircraftEdit = new AircraftEdit(Engine.getAircraftRegistration(var),
                    Engine.getAircraftType(var), Engine.getAircraftAirLines(var), var);
                }
                if(objects.getSelectedItem()=="Airport"){
                    int var = select.getSelectedIndex();
                    AirportEdit airportEdit = new AirportEdit();
                }
            }
            dispose();
        }
    }
    
    
    
}
