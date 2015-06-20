import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import java.io.File;
//import java.util.Random;
import javax.swing.*;

public class Main implements KeyListener,MouseListener
{
    ScreenManager screen;
    Image background, knight1, knight2, exit;
    boolean GameRunning = true;
    int X1=98,X2=650;
     
    public static void main(String args[])
    {
        Main objmain= new Main();
        objmain.run();
    }
    
    private static final DisplayMode modes1[]=
    {
        new DisplayMode(800,600,32,0),
        // new DisplayMode(800,600,24,0),
        //new DisplayMode(800,600,16,0),
        //new DisplayMode(640,480,32,0),
        //new DisplayMode(640,480,24,0),
        //new DisplayMode(640,480,16,0),
        //new DisplayMode(1366,768,16,0),
    };
    
    /*THIS METHOD INITIALIZE ALL THE ELEMENTS*/
    
    void init()
    {
        background= new ImageIcon("Background.png").getImage(); 
        knight1 = new ImageIcon("K1org.png").getImage();
        knight2 = new ImageIcon("K2org.png").getImage();
        exit = new ImageIcon("Exit.png").getImage();
       
        screen= new ScreenManager();
        
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Rome.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            catch(Exception ex){}
    }
    
    /*MAIN RUN METHOD*/
    
    public void run()
    {
        init();
        
        try
        {
            DisplayMode dm= screen.findFirstCompatibleMode(modes1);
            screen.setFullScreen(dm);
            Window w=screen.getFullScreenWindow();
            w.addKeyListener(this);
            w.addMouseListener(this);
            Toolkit toolkit = Toolkit.getDefaultToolkit(); 
             Image image = toolkit.getImage("Ab.gif"); 
             Point hotSpot = new Point(0,0); 
             Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Ab");
             w.setCursor(cursor); 
            while(GameRunning==true){
                
                Graphics2D g3 = screen.getGraphics();
                paintOpeningScreen(g3);
                screen.update();
                g3.dispose();
                try{
                    Thread.sleep(500);
                }
                catch(Exception e){}
            }

        }

        finally
        {
            screen.restoreScreen();
        }
    }
    
    /* Paint openning screen*/
    
    public void paintOpeningScreen(Graphics2D g1)
    {
        g1.drawImage(background,0,0,null);
        if(X1+50<=750){
            X1+=50;
            X2-=50;
        }
        g1.drawImage(knight2,X1,250,55,53,null);
        g1.drawImage(knight1,X2,250,55,53,null);
        //g1.setColor(Color.red);
        //g1.drawRect(320, 550 , 120 , 30);
        g1.drawImage(exit, 320, 550, null);
    }
   
    public void keyPressed(KeyEvent ke)
    {
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
    }
    
    public  void keyReleased(KeyEvent ke)
    {
    
    }
    public  void keyTyped(KeyEvent ke)
    {
       
    }
    /* handle mouse click*/
    public void mouseClicked(MouseEvent me)
    {   
       System.out.println(me.getX()+"   "+me.getY());
       if(me.getX()>320 && me.getX()<440 && me.getY()>550 && me.getY()<580){
           
               GameRunning = false;
           
       }
    }
    public void mouseEntered(MouseEvent me)
    {
    
    }
    public void mouseExited(MouseEvent me)
    {

    }
    public void mousePressed(MouseEvent me)
    {

    }
    public void mouseReleased(MouseEvent me)
    {
    
    }

}