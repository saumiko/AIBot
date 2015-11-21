import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientTwo extends Main implements KeyListener {

    int row, column , i ,j, c;
    long  Pre=0;
    //static boolean nattack, ndefence, nknight;

    ClientTwo() {

        //w.addMouseListener(this);
        //w.addMouseMotionListener(this);
        //PaintRect(g);
        c = 1;
        w.addKeyListener(this);
    }

    public void PaintAndCheck(Graphics2D g){
        //g.drawImage(background2, 0, 0, null);
        TwoDrawRect(g);
        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 13; column++) {
                if (Player[row][column] == 2) {
                    if (Character[row][column] == 1) {
                        if(a2)
                            g.drawImage(attack2d, X[row][column], Y[row][column], 47, 47, null);
                        else
                            g.drawImage(attack2, X[row][column], Y[row][column], 47, 47, null);
                        
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 3000 && Player[row][column-1]==0){
                           
                            Player[row][column-1] = 2;
                            Player[row][column] = 0;
                            Character[row][column-1] = 1;
                            Attack[row][column-1] = Attack[row][column]-4;
                            Defence[row][column-1] = Defence[row][column]-5;
                            PreTime[row][column-1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 2) {
                        if(d2)
                            g.drawImage(defence2d, X[row][column], Y[row][column], 47, 47, null);
                        else
                            g.drawImage(defence2, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 3500 && Player[row][column-1]==0){
                            
                            Player[row][column-1] = 2;
                            Player[row][column] = 0;
                            Character[row][column-1] = 2;
                            Attack[row][column-1] = Attack[row][column]-4;
                            Defence[row][column-1] = Defence[row][column]-5;
                            PreTime[row][column-1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 3) {
                        if(k2)
                            g.drawImage(knight2d, X[row][column], Y[row][column], 47, 47, null);
                        else
                            g.drawImage(knight2, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 2500 && Player[row][column-1]==0){
                            
                            Player[row][column-1] = 2;
                            Player[row][column] = 0;
                            Character[row][column-1] = 3;
                            Attack[row][column-1] = Attack[row][column]-4;
                            Defence[row][column-1] = Defence[row][column]-5;
                            PreTime[row][column-1] = System.currentTimeMillis();
                        }
                        
                    }
                    // This Option is for Arrow
                    else if (Character[row][column] == 4) {
                        g.drawImage(arrowl, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 1000 && Player[row][column-1]==0){
                            Player[row][column-1] = 2;
                            Player[row][column] = 0;
                            Character[row][column-1] = 4;
                            PreTime[row][column-1] = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }
    
    public void TwoDrawRect(Graphics2D g)
    {
        Font fs = new Font("Impact", Font.BOLD, 20);
        Color Sc = new Color(155,155,155);
        g.setFont(fs);
        g.setColor(Sc);
        if(nknight)
            g.drawString("KNIGHT", 600, 30);
        else if(nattack)
            g.drawString("ARCHER", 600, 30);
        else if(ndefence)
            g.drawString("DEFENCE", 600, 30);
        
        if(ClientOne.knight){
            g.drawString("KNIGHT", 100, 30);
        }
        else if(ClientOne.attack)
            g.drawString("ARCHER", 100, 30);
        else if(ClientOne.defence)
            g.drawString("DEFENCE", 100, 30);
        
        
        
        g.setColor(Color.RED);
        g.drawRect(X[c][13]+5, Y[c][13]+2, 47, 45);
    }
    
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_B)
        {
            ndefence = false;
            nknight = false;
            nattack = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_N)
        {
            nattack = false;
            nknight = false;
            ndefence = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_M)
        {
            nattack = false;
            ndefence = false;
            nknight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            c--;
            if(c==0)
                c = 9;
            
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            c++;
            if(c==10)
                c = 1;
  
        }
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            long T = System.currentTimeMillis();
            if (nattack && Player[c][13] == 0 && T - pre > 5000 && gold2-na2>=0) 
            {
                pre = T;
                Player[c][13] = 2;
                Character[c][13] = 1;
                gold2-=na2;
                na2++;
                Attack[c][13] = 100;
                Defence[c][13] = 60;
                PreTime[c][13] = System.currentTimeMillis();
            }
            if (ndefence && Player[c][13] == 0 && T - pre > 5000 && gold2-nd2>=0) 
            {
                pre = T;
                Player[c][13] = 2;
                Character[c][13] = 2;
                gold2-=nd2;
                nd2++;
                Attack[c][13] = 50;
                Defence[c][13] = 100;
                PreTime[c][13] = System.currentTimeMillis();
            }
            if (nknight && Player[c][13] == 0 && T - pre > 5000 && gold2-nk2>=0) 
            {
                pre = T;
                Player[c][13] = 2;
                Character[c][13] = 3;
                gold2-=nk2;
                nk2++;
                Attack[c][13] = 70;
                Defence[c][13] = 55;
                PreTime[c][13] = System.currentTimeMillis();
            }
        }
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
}