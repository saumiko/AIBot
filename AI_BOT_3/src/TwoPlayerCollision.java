import com.sun.rowset.internal.Row;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TwoPlayerCollision extends Main /*implements MouseListener, MouseMotionListener*/ {

    static int R, C, charach;

    TwoPlayerCollision() {

    }

    void Collision(Graphics2D g) {
        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 13; column++) {
                if (Player[row][0] == 2) {
                    //System.out.println("YES");
                    twoP = false;
                    long T = System.currentTimeMillis();
                    long Pre = T;
                    while(Pre-T<=5000){
                        Pre = System.currentTimeMillis();
                        g = s.getGraphics();
                        g.drawImage(lose,0,0,800,600, null);
                        s.update();
                        g.dispose();
                    }
                    for (row = 0; row < 32; row++) {
                        for (column = 0; column < 32; column++) {
                            Player[row][column] = 0;
                            Character[row][column] = 0;
                            PreTime[row][column] = 0;
                            Attack[row][column] = 0;
                            Defence[row][column] = 0;
                        }
                    }
                    return;
                }
                else if(Player[row][14] == 1){
                    oneP = false;
                    long T = System.currentTimeMillis();
                    long Pre = T;
                    while(Pre-T<=5000){
                        Pre = System.currentTimeMillis();
                        //System.out.println("YES");
                        g = s.getGraphics();
                        g.drawImage(win,0,0,800,600, null);
                        s.update();
                        g.dispose();
                    }
                    for (row = 0; row < 32; row++) {
                        for (column = 0; column < 32; column++) {
                            Player[row][column] = 0;
                            Character[row][column] = 0;
                            PreTime[row][column] = 0;
                            Attack[row][column] = 0;
                            Defence[row][column] = 0;

                        }
                    }
                    return;
                }

                if (Defence[row][column]+Attack[row][column] <= 0) {
                    Player[row][column] = 0;
                }

                if (Player[row][column] == 1 && Player[row][column + 1] == 2) {
                    int sumME = Attack[row][column] + Defence[row][column];
                    int sumAI = Attack[row][column + 1] + Defence[row][column + 1];
                    if (sumME > sumAI) {
                        if (Character[row][column] == 1) {
                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 1;
                            Attack[row][column + 1] = Attack[row][column] - 30;
                            Defence[row][column + 1] = Defence[row][column] - 30;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        } else if (Character[row][column] == 2) {

                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 2;
                            Attack[row][column + 1] = Attack[row][column] - 30;
                            Defence[row][column + 1] = Defence[row][column] - 30;
                            PreTime[row][column + 1] = System.currentTimeMillis();

                        } else if (Character[row][column] == 3) {
                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 3;
                            Attack[row][column + 1] = Attack[row][column] - 30;
                            Defence[row][column + 1] = Defence[row][column] - 30;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    } else {
                        if (Character[row][column + 1] == 1) {
                            Player[row][column] = 2;
                            Player[row][column + 1] = 0;
                            Character[row][column] = 1;
                            Attack[row][column] = Attack[row][column + 1] - 30;
                            Defence[row][column] = Defence[row][column + 1] - 30;
                            PreTime[row][column] = System.currentTimeMillis();
                        } else if (Character[row][column + 1] == 2) {
                            Player[row][column] = 2;
                            Player[row][column + 1] = 0;
                            Character[row][column] = 2;
                            Attack[row][column] = Attack[row][column + 1] - 30;
                            Defence[row][column] = Defence[row][column + 1] - 30;
                            PreTime[row][column + 1] = System.currentTimeMillis();

                        } else if (Character[row][column + 1] == 3) {
                            Player[row][column] = 2;
                            Player[row][column + 1] = 0;
                            Character[row][column] = 3;
                            Attack[row][column] = Attack[row][column + 1] - 30;
                            Defence[row][column] = Defence[row][column + 1] - 30;
                            PreTime[row][column] = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }
    

    /*@Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
