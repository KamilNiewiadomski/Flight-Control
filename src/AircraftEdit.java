
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
class AircraftEdit  extends JFrame implements ActionListener {
    JTextField jTextField1, jTextField2, jTextField3;
    int index;
    AircraftEdit(){
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setSize(300,250);
        this.setTitle("AircraftEdit");
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setAlwaysOnTop(true);
        
        JLabel jLabel1 = new JLabel("Aircraft");
        jLabel1.setBounds(50, 20, 200, 20);
        add(jLabel1);
        
        JLabel jLabel2 = new JLabel("Registration:");
        jLabel2.setBounds(50, 45, 200, 20);
        add(jLabel2);
        
        jTextField1 = new JTextField();
        jTextField1.setBounds(50, 70, 200, 20);
        add(jTextField1);
        
        JLabel jLabel3 = new JLabel("Type:");
        jLabel3.setBounds(50, 95, 200, 20);
        add(jLabel3);
        
        jTextField2 = new JTextField();
        jTextField2.setBounds(50, 120, 200, 20);
        add(jTextField2);
        
        JLabel jLabel4 = new JLabel("Air Lines:");
        jLabel4.setBounds(50, 145, 200, 20);
        add(jLabel4);
        
        jTextField3 = new JTextField();
        jTextField3.setBounds(50, 170, 200, 20);
        add(jTextField3);
        
        JButton button = new JButton("Cancel");
        button.setBounds(155, 200, 75, 30);
        button.addActionListener(this);
        button.setActionCommand("cmdEXIT");
        this.add(button);
        
        JButton button1 = new JButton("Save");
        button1.setBounds(70, 200, 75, 30);
        button1.addActionListener(this);
        button1.setActionCommand("cmdSAVE");
        this.add(button1);
        
        this.setVisible(true);
    }
    
    AircraftEdit(String registration, String type, String airLines, int index1){
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setSize(300,250);
        this.setTitle("AircraftEdit");
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setAlwaysOnTop(true);
        
        index = index1;
        
        JLabel jLabel1 = new JLabel("Aircraft");
        jLabel1.setBounds(50, 20, 200, 20);
        add(jLabel1);
        
        JLabel jLabel2 = new JLabel("Registration:");
        jLabel2.setBounds(50, 45, 200, 20);
        add(jLabel2);
        
        jTextField1 = new JTextField(registration);
        jTextField1.setBounds(50, 70, 200, 20);
        add(jTextField1);
        
        JLabel jLabel3 = new JLabel("Type:");
        jLabel3.setBounds(50, 95, 200, 20);
        add(jLabel3);
        
        jTextField2 = new JTextField(type);
        jTextField2.setBounds(50, 120, 200, 20);
        add(jTextField2);
        
        JLabel jLabel4 = new JLabel("Air Lines:");
        jLabel4.setBounds(50, 145, 200, 20);
        add(jLabel4);
        
        jTextField3 = new JTextField(airLines);
        jTextField3.setBounds(50, 170, 200, 20);
        add(jTextField3);
        
        JButton button = new JButton("Cancel");
        button.setBounds(155, 200, 75, 30);
        button.addActionListener(this);
        this.add(button);
        
        JButton button1 = new JButton("Edit");
        button1.setBounds(70, 200, 75, 30);
        button1.addActionListener(this);
        this.add(button1);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if("Save".equals(cmd)){
            Engine.addAircraft(jTextField1.getText(), jTextField2.getText(), 
                    jTextField3.getText(), true);
        }
        if("Edit".equals(cmd)){
            Engine.editAircraft(jTextField1.getText(), jTextField2.getText(), 
                    jTextField3.getText(), index);
        }
        Engine.getFlightControl().edit();
        dispose();
    }
    
}
