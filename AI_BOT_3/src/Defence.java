import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
//import static Main.knight1;
import java.awt.Graphics2D;


public class Defence {
    int x=0,y=0;
    int gx=0,gy=0;
    
    /*Defence(){
        
    }*/
    
    public void paintDefence1(Graphics2D g)
    {
        g.drawImage(Main.defence1,x, y, 46,47,null);
    }
    
    public void paintDefence2(Graphics2D g)
    {
        g.drawImage(Main.defence2,x, y, 46,47,null);
    }
     
    public void update(){
        gx++;
        x+=47;
    }
    
    int getX()
    {
        return x;
    }
     
    int getY()
    {
        return y;
    }
    void SetX(int tx){
        x=tx;
    }
    
    void SetY(int ty){
        y=ty;
    }
}
