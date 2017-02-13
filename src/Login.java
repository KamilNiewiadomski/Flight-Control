
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JButton button, button2;
    JTextField textField;
    JPasswordField passwordField;
    public Login(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createLineBorder
            (Color.black));
        this.setSize(205,130);
        this.setTitle("Login");
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        
        button = new JButton("Log in");
        this.add(button);
        button.addActionListener(this);
        button.setActionCommand("cmdOK");
        button.setBounds(25, 95, 73, 25);
        
        button2 = new JButton("Exit");
        this.add(button2);
        button2.addActionListener(this);
        button2.setActionCommand("cmdEXIT");
        button2.setBounds(101, 95, 73, 25);
        
        JLabel login = new JLabel("Login:");
        login.setBounds(25, 4, 150, 25);
        this.add(login);
        
        textField = new JTextField();
        textField.setBounds(25, 25, 150, 25);
        this.add(textField);
        
        JLabel password = new JLabel("Password:");
        password.setBounds(25, 44, 150, 25);
        this.add(password);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(25, 65, 150, 25);
        this.add(passwordField);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cmdOK")){
            Engine.flightControlIni();
            dispose();
        }
        if(e.getActionCommand().equals("cmdEXIT")){
            dispose();
        }
    }
}