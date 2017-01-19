
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
class AirportEdit extends JFrame implements ActionListener {
    JTextField jTextField, jTextField1, jTextField2, jTextField3, 
            jTextField4, jTextField5, jTextField6, jTextField7;
    AirportEdit(){
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setSize(300,390);
        this.setTitle("AirportEdit");
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setAlwaysOnTop(true);
        
        JLabel jLabel = new JLabel("Airport");
        jLabel.setBounds(50, 20, 200, 20);
        add(jLabel);
        
        JLabel jLabel1 = new JLabel("Name:");
        jLabel1.setBounds(50, 45, 200, 20);
        add(jLabel1);
        
        jTextField = new JTextField();
        jTextField.setBounds(50, 70, 200, 20);
        add(jTextField);
        
        JLabel jLabel2 = new JLabel("IATA name:");
        jLabel2.setBounds(50, 95, 200, 20);
        add(jLabel2);
        
        jTextField1 = new JTextField();
        jTextField1.setBounds(50, 120, 200, 20);
        add(jTextField1);
        
        JLabel jLabel3 = new JLabel("City:");
        jLabel3.setBounds(50, 145, 200, 20);
        add(jLabel3);
        
        jTextField2 = new JTextField();
        jTextField2.setBounds(50, 170, 200, 20);
        add(jTextField2);
        
        JLabel jLabel4 = new JLabel("State:");
        jLabel4.setBounds(50, 195, 200, 20);
        add(jLabel4);
        
        jTextField3 = new JTextField();
        jTextField3.setBounds(50, 220, 200, 20);
        add(jTextField3);
        
        JLabel jLabel5 = new JLabel("Number of runways:");
        jLabel5.setBounds(50, 245, 200, 20);
        add(jLabel5);
        
        jTextField4 = new JTextField();
        jTextField4.setBounds(50, 270, 200, 20);
        add(jTextField4);
        
        JLabel jLabel6 = new JLabel("Location:");
        jLabel6.setBounds(50, 295, 200, 20);
        add(jLabel6);
        
        jTextField5 = new JTextField("LAT");
        jTextField5.setBounds(50, 320, 66, 20);
        add(jTextField5);
        
        jTextField6 = new JTextField("LONG");
        jTextField6.setBounds(117, 320, 66, 20);
        add(jTextField6);
        
        jTextField7 = new JTextField("ALT");
        jTextField7.setBounds(183, 320, 66, 20);
        add(jTextField7);
        
        JButton button = new JButton("Cancel");
        button.setBounds(155, 345, 75, 30);
        button.addActionListener(this);
        this.add(button);
        
        JButton button1 = new JButton("Save");
        button1.setBounds(70, 345, 75, 30);
        button1.addActionListener(this);
        this.add(button1);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if("Save".equals(cmd)){
            Engine.addAirport(jTextField.getText(), jTextField1.getText(), 
                    jTextField2.getText(), jTextField3.getText(), 
                    Short.parseShort(jTextField4.getText()), 
                    Double.parseDouble(jTextField5.getText()), 
                    Double.parseDouble(jTextField6.getText()), 
                    Double.parseDouble(jTextField7.getText()), true);
        }
        Engine.getFlightControl().edit();
        dispose();
    }
}
