import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Knight{
    
    int x,y;
    int gx,gy;
    
   /* Knight()
    {
        
    }*/
    
    public void paintKnight1(Graphics2D g)
    {
        g.drawImage(Main.knight1,x, y, 46,47,null);
    }
    
    public void paintKnight2(Graphics2D g)
    {
        g.drawImage(Main.knight2,x, y, 46,47,null);
    }
    
    public void update(){
        gx++;
        x+=47;
    }
    
    void SetX(int tx){
        x=tx;
    }
    
    int getX()
    {
        return x;
    }
    
    void SetY(int ty){
        y=ty;
    }
    
    int getY()
    {
        return y;
    }
}
