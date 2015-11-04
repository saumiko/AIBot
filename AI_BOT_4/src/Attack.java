import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Attack{
    
    int x,y;
    int gx,gy;
    
    Attack()
    {
        x=0;y=0;
        gx=0;gy=0;
        System.out.println("Inside");
    }
    
    public void update(){
        gx++;
        x+=47;
    }
    
    public void paintAttack1(Graphics2D g)
    {
        g.drawImage(Main.attack1,x, y, 46,47,null);
    }
    
    public void paintAttack2(Graphics2D g)
    {
        g.drawImage(Main.attack2,x, y, 46,47,null);
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
