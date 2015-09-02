import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientOne extends Main implements MouseListener, MouseMotionListener {

    int row, column , i ,j;
    long  Pre=0;
    //static boolean attack, defence, knight;


    ClientOne() {

        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        //PaintRect(g);
    }

    public void PaintAndCheck(Graphics2D g) {
        g.drawImage(background1, 0, 0, null);
        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 13; column++) {
                if (Player[row][column] == 1) {
                    if (Character[row][column] == 1) {
                        g.drawImage(attack1, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 3000 && Player[row][column+1]==0){
                           
                            Player[row][column+1] = 1;
                            Player[row][column] = 0;
                            Character[row][column+1] = 1;
                            Attack[row][column+1] = Attack[row][column]-5;
                            Defence[row][column+1] = Defence[row][column]-5;
                            PreTime[row][column+1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 2) {
                        g.drawImage(defence1, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 3500 && Player[row][column+1]==0){
                            
                            Player[row][column+1] = 1;
                            Player[row][column] = 0;
                            Character[row][column+1] = 2;
                            Attack[row][column+1] = Attack[row][column]-5;
                            Defence[row][column+1] = Defence[row][column]-5;
                            PreTime[row][column+1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 3) {
                        g.drawImage(knight1, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 2500 && Player[row][column+1]==0){
                            
                            Player[row][column+1] = 1;
                            Player[row][column] = 0;
                            Character[row][column+1] = 3;
                            Attack[row][column+1] = Attack[row][column]-5;
                            Defence[row][column+1] = Defence[row][column]-5;
                            PreTime[row][column+1] = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }
    
         public void mouseClicked(MouseEvent e) {

        //System.out.println("X: " + e.getX() + " Y: " + e.getY());
        int x = e.getX(), tx;
        int y = e.getY(), ty;

        if (x >= 200 && x <= 280 && y >= 515 && y <= 595) {
            attack = true;
            defence = false;
            knight = false;

        }

        if (x >= 350 && x <= 420 && y >= 515 && y <= 595) {
            attack = false;
            defence = true;
            knight = false;
        }

        if (x >= 485 && x <= 585 && y >= 515 && y <= 595) {
            attack = false;
            defence = false;
            knight = true;
        }

        for (int i = 1; i <= 9; i++) {

            if (x >= X[i][1] && x <= X[i][1] + 47 && y >= Y[i][1] && y <= Y[i][1] + 47) {
                long T = System.currentTimeMillis();
                if (attack && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 1;
                    Attack[i][1] = 100;
                    Defence[i][1] = 60;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (defence && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 2;
                    Attack[i][1] = 50;
                    Defence[i][1] = 100;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (knight && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 3;
                    Attack[i][1] = 70;
                    Defence[i][1] = 55;
                    PreTime[i][1] = System.currentTimeMillis();
                }
            }
        }

    }
    public void mouseDragged(MouseEvent e) 
    {

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}
