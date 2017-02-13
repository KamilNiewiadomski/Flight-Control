
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
public class FlightControl extends JFrame implements ActionListener, KeyListener
{
    Font name;
    Font title;
    JMenu program;
    JMenuItem edit, addFlight, sync, close;
    public Renderer renderer;
    public Simulation sim = new Simulation();
    Timer timer;
    int mainX = 0, mainY = 0, scale = 1, time = 0;
    

    public FlightControl()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        
        timer = new Timer(10, this);
        renderer = new Renderer();
        add(renderer);
        
        addKeyListener(this);

        this.setTitle("Flight Control");
        this.setResizable(false);
        this.setFocusable(true);
        this.setLocation(this.getX() - (this.getWidth() / 2), this.getY() -            
                (this.getHeight() / 2));
        this.setVisible(true);
        timer.start();
    }

    public JMenuBar createMenuBar()
    {
        JMenuBar menuBar  = new JMenuBar();;
        program = new JMenu("Program");
        menuBar.add(program);
        edit = new JMenuItem("Edit");
        program.add(edit);
        edit.addActionListener(this);
        sync = new JMenuItem("Sync");
        program.add(sync);
        sync.addActionListener(this);
        close = new JMenuItem("Close");
        program.add(close);
        close.addActionListener(this);

         JMenu user = new JMenu("User");
        menuBar.add(user);
        addFlight = new JMenuItem("Add flight");
        addFlight.setEnabled(false);
        user.add(addFlight);
        addFlight.addActionListener(this);
        
        JMenu view = new JMenu("View");
        menuBar.add(view);
        
        JMenu settings = new JMenu("Settings");
        menuBar.add(settings);
        
        JMenu help = new JMenu("Help");
        menuBar.add(help);
        
        JMenu simulation = new JMenu("Simulation");
        menuBar.add(simulation);
        JMenuItem start = new JMenuItem("Start");
        simulation.add(start);
        start.addActionListener(this);
        JMenuItem pause = new JMenuItem("Pause");
        simulation.add(pause);
        pause.addActionListener(this);
        JMenuItem create = new JMenuItem("Create");
        simulation.add(create);
        create.addActionListener(this);
        
        return menuBar;
    }

    public void edit(){
        Edit edit = new Edit();
    }
    
    public void setAddFlightEnable(boolean bool){
        addFlight.setEnabled(bool);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
        if(sim.isRunning){
            sim.update(); 
        }
        String cmd = e.getActionCommand();
        if("Close".equals(cmd)){
            dispose();
            timer.stop();
        }
        if("Edit".equals(cmd)){
            this.setEnabled(false);
            edit();
        }
        if("Sync".equals(cmd)){
            Engine.sync();
        }
        if("Add flight".equals(cmd)){
            this.setEnabled(false);
            flighEdit();
        }
        if("Start".equals(cmd)){
            sim.start();
        }
        if("Pause".equals(cmd)){
            sim.pause();
        }
        if("Create".equals(cmd)){
            sim.createFlight();
        }
                
    }

    private void flighEdit() {
        FlightEdit flightEdit = new FlightEdit();
    }
    
    void repaint(Graphics g) {
        Date date = new Date();
        Graphics2D g2 = (Graphics2D)g;
        
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        
        g2.setColor(new Color(70,70,70));
        g2.fillRect(mainX, mainY, 3000, 3000);
        g2.setColor(Color.white);
        for(int i = 0; i<100; i++){
            g2.drawLine((100*i+mainX), mainY, (100*i+mainX), 3000);
            g2.drawLine(mainX, (100*i+mainY), 3000 , (100*i+mainY));
        }
        g2.setColor(Color.YELLOW);
        for(Airport airport : Engine.airports){
            g2.drawRect((int)(mainX+airport.getLocation().getLatitude()-10),
                    (int)(mainY+airport.getLocation().getLongitude()-10),20,20);
            g2.drawLine((int)(mainX+airport.getLocation().getLatitude()),
                    (int)(mainY+airport.getLocation().getLongitude()),
                    (int)(mainX+airport.getLocation().getLatitude()),
                    (int)(mainY+airport.getLocation().getLongitude()));
            g2.drawString(airport.getName(), 
                    (int)(mainX+airport.getLocation().getLatitude()+15),
                    (int)(mainY+airport.getLocation().getLongitude()));
            g2.drawString((airport.getCity()+", "+airport.getState()), 
                    (int)(mainX+airport.getLocation().getLatitude()+15),
                    (int)(mainY+airport.getLocation().getLongitude()+15));
        }
        for(Aircraft aircraft : Engine.aircrafts){
            if(aircraft.flight!=null){
                drawAirplane(g2, aircraft);
            }
        }
        g2.setColor(Color.green);
        g2.drawString(date.toString(),this.getBounds().width-200,
                this.getBounds().height-50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        int keyCode = e.getKeyCode();
        if(c=='w'){
            if(mainY<0)
                mainY+=50;
        }
        if(c=='s'){
            if((mainY-this.getBounds().height)>-3000)
                mainY-=50;
        }
        if(c=='a'){
           if(mainX<0)
                mainX+=50; 
        }
        if(c=='d'){
            if((mainX-this.getBounds().width)>-3000)
                mainX-=50;
        }
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                    scale++;
                break;
            case KeyEvent.VK_DOWN:
                    scale--;
                break;
            case KeyEvent.VK_LEFT:
                if(mainX<0)
                    mainX+=10; 
                break;
            case KeyEvent.VK_RIGHT :
                if(mainX<3000)
                    mainX-=10;
                break;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    private void drawAirplane(Graphics2D g2, Aircraft aircraft) {
        int x = (int) (mainX+aircraft.getLocation().getLatitude()),
                    y = (int) (mainY+aircraft.getLocation().getLongitude());
        DecimalFormat df = new DecimalFormat("#.##");
        g2.setColor(Color.green);
        g2.drawString("Reg: "+aircraft.getRegistration(), x+10, y);
        g2.drawString("Speed: "+df.format(aircraft.speed), x+10, y+11);
        g2.drawString("Des: "+aircraft.getFlight().destination.getName(), x+10, y+22);
        g2.rotate(aircraft.direction, x, y);
        g2.fillPolygon(new int[]{(x-5),(x-10),(x+5),(x-10)},
                new int[]{y,(y+7),y,(y-7)}, 4);
        g2.rotate(-aircraft.direction, x, y);
    }
    
}