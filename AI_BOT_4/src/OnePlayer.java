import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class OnePlayer extends Main implements MouseListener, MouseMotionListener {

    int row, column , i ,j;
    long  Pre=0,T=0,TS=0;


    OnePlayer() {

        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        //PaintRect(g);
    }

    public void PaintAndCheck(Graphics2D g) {
        //g=s.getGraphics();
        //System.out.println("Abort1");
        g.drawImage(background1, 0, 0, null);
        //System.out.println("Abort2");
        //g.setColor(Color.red);
        //System.out.println("Abort3");
        //g.drawRect(200, 515, 80, 80);
        //g.drawRect(350, 515, 70, 80);
       // g.drawRect(485, 515, 100, 80);
//        g.drawRect(88, 69, 46, 47);
//        g.drawRect(88, 115, 46, 47);
//        g.drawRect(88, 161, 46, 47);
//        g.drawRect(88, 207, 46, 47);
//        g.drawRect(88, 253, 46, 47);
//        g.drawRect(88, 299, 46, 47);
//        g.drawRect(88, 345, 46, 47);
//        g.drawRect(88, 391, 46, 47);
//        g.drawRect(88, 438, 46, 47);
        
        /*
        for (check = 0, i = 88, j = 69; check <= 8; check++) {
            g.drawRect(i, j, 51, 47);
            g.drawRect(657, j, 51, 47);
            j += 46;
        }
        */
        
        Font fs = new Font("Impact", Font.BOLD, 20);
        Color Sc = new Color(255, 255, 255);
        g.setFont(fs);
        g.setColor(Sc);
        String str;
        
        T = System.currentTimeMillis();
        TS = ((T-pre)/1000);
        TS = 5-TS;
        if(TS<=0) TS = 0;
        if(TS==0) g.setColor(Color.green);
        else g.setColor(Color.red);
        
        str = Long.toString(TS);
        g.drawString("Time : " + str, 10, 530);
        g.setColor(Sc);
        str = Integer.toString(na1);
        g.drawString("Archer : " + str, 10, 550);
        str = Integer.toString(nd1);
        g.drawString("Defence : " + str, 10, 570);
        str = Integer.toString(nk1);
        g.drawString("Knight : " + str, 10, 590);

        str = Integer.toString(na2);
        g.drawString("Archer : " + str, 700, 550);
        str = Integer.toString(nd2);
        g.drawString("Defence : " + str, 700, 570);
        str = Integer.toString(nk2);
        g.drawString("Knight : " + str, 700, 590);
        
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
                    // This Option is for Arrow
                    else if (Character[row][column] == 4) {
                        g.drawImage(arrowr, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if(T-PreTime[row][column]>= 1000 && Player[row][column+1]==0){
                            Player[row][column+1] = 1;
                            Player[row][column] = 0;
                            Character[row][column+1] = 4;
                            PreTime[row][column+1] = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }
    
 /*
        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 11; column++) {
                /*
                if (CellOP[row][column] == 1) {
                   // A[PlayerNo[row][column]].paintAttack1(g);
                }
                if (CellOP[row][column] == 2) {
                   // D[PlayerNo[row][column]].paintDefence1(g);
                }
                if (CellOP[row][column] == 3) {
                    //g.drawImage(Main.knight1,K[PlayerNo[row][column]].x, K[PlayerNo[row][column]].y, 46,47,null);
                    System.out.println( K[PlayerNo[row][column]].x + "  +++   "+ K[PlayerNo[row][column]].y);
                    System.out.println(PlayerNo[row][column]);
                   // K[PlayerNo[row][column]].paintKnight1(g);
                }
                

            }
}
*/
   

/*
    public void mouseClicked(MouseEvent e) {

        //System.out.println("X: " + e.getX() + " Y: " + e.getY());
        int x = e.getX();
        int y = e.getY();

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

        for (int i = 1; i < 9; i++) {
            if (x >=88  && x <= 88+51 && y >= 69*(i) && y <= 69*(i) + 47) {
                if (attack && CellOP[i][1] == 0) {
                    nattack++;
                    A[nattack].x=x;
                    A[nattack].y=y;
                    CellOP[i][1] = 1;
                    PlayerNo[i][1]=nattack;
                }
                if (defence && CellOP[i][1] == 0) {
                    ndefence++;
                    D[ndefence].x=x;
                    D[ndefence].y=y;
                    CellOP[i][1] = 2;
                    PlayerNo[i][1]=ndefence;
                }
                if (knight && CellOP[i][1] == 0) {
                    nknight++;
                    A[nknight].x=x;
                    A[nknight].y=y;
                    CellOP[i][1] = 3;
                    PlayerNo[i][1]=nknight;
                }
            }
        }

    }
*/
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
                T = System.currentTimeMillis();
                
                if (attack && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 1;
                    na1++;
                    Attack[i][1] = 100;
                    Defence[i][1] = 60;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (defence && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 2;
                    nd1++;
                    Attack[i][1] = 50;
                    Defence[i][1] = 100;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (knight && Player[i][1] == 0 && T - pre > 5000) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 3;
                    nk1++;
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
