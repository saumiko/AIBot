import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClientOne extends Main implements MouseListener, MouseMotionListener {

    static int row, column, i, j, pc = 1;
    long Pre = 0;
    //static boolean attack, defence, knight;

    ClientOne() {

        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        //PaintRect(g);
    }

    public void PaintAndCheck(Graphics2D g) {
        OneDrawRect(g);   
        g.drawImage(background1, 0, 0, null);
        Font fs = new Font("Impact", Font.BOLD, 20);
        Color Sc = new Color(255, 255, 255);
        g.setFont(fs);
        g.setColor(Sc);
        g.drawRect(10, 525, nd1, i);
        String str;
        str = Integer.toString(gold1);
        g.setColor(Color.YELLOW);
        g.drawString("GOLD : " + str, 10, 530);
        str = Integer.toString(na1);
        g.setColor(Color.red);
        g.drawString("Archer : " + str, 10, 550);
        str = Integer.toString(nd1);
        g.setColor(Color.pink);
        g.drawString("Defence : " + str, 10, 570);
        str = Integer.toString(nk1);
        g.setColor(Color.white);
        g.drawString("Knight : " + str, 10, 590);

        str = Integer.toString(gold2);
        g.setColor(Color.YELLOW);
        g.drawString("GOLD : " + str, 700, 530);
        str = Integer.toString(na2);
        g.setColor(Color.red);
        g.drawString("Archer : " + str, 700, 550);
        str = Integer.toString(nd2);
        g.setColor(Color.pink);
        g.drawString("Defence : " + str, 700, 570);
        str = Integer.toString(nk2);
        g.setColor(Color.white);
        g.drawString("Knight : " + str, 700, 590);

        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 13; column++) {
                if (Player[row][column] == 1) {
                    if (Character[row][column] == 1) {
                        if (a1) {
                            g.drawImage(attack1d, X[row][column], Y[row][column], 47, 47, null);
                        } else {
                            g.drawImage(attack1, X[row][column], Y[row][column], 47, 47, null);
                        }
                        long T = System.currentTimeMillis();
                        if (T - PreTime[row][column] >= 3000 && Player[row][column + 1] == 0) {

                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 1;
                            Attack[row][column + 1] = Attack[row][column] - 5;
                            Defence[row][column + 1] = Defence[row][column] - 5;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 2) {
                        if (d1) {
                            g.drawImage(defence1d, X[row][column], Y[row][column], 47, 47, null);
                        } else {
                            g.drawImage(defence1, X[row][column], Y[row][column], 47, 47, null);
                        }
                        long T = System.currentTimeMillis();
                        if (T - PreTime[row][column] >= 3500 && Player[row][column + 1] == 0) {

                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 2;
                            Attack[row][column + 1] = Attack[row][column] - 5;
                            Defence[row][column + 1] = Defence[row][column] - 5;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    } else if (Character[row][column] == 3) {
                        if (k1) {
                            g.drawImage(knight1d, X[row][column], Y[row][column], 47, 47, null);
                        } else {
                            g.drawImage(knight1, X[row][column], Y[row][column], 47, 47, null);
                        }
                        long T = System.currentTimeMillis();
                        if (T - PreTime[row][column] >= 2500 && Player[row][column + 1] == 0) {

                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 3;
                            Attack[row][column + 1] = Attack[row][column] - 5;
                            Defence[row][column + 1] = Defence[row][column] - 5;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    } // This Option is for Arrow
                    else if (Character[row][column] == 4) {
                        g.drawImage(arrowr, X[row][column], Y[row][column], 47, 47, null);
                        long T = System.currentTimeMillis();
                        if (T - PreTime[row][column] >= 1000 && Player[row][column + 1] == 0) {
                            Player[row][column + 1] = 1;
                            Player[row][column] = 0;
                            Character[row][column + 1] = 4;
                            PreTime[row][column + 1] = System.currentTimeMillis();
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
                if (attack && Player[i][1] == 0 && T - pre > 5000 && gold1 - na1 >= 0) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 1;
                    gold1 -= na1;
                    na1++;
                    Attack[i][1] = 100;
                    Defence[i][1] = 60;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (defence && Player[i][1] == 0 && T - pre > 5000 && gold1 - nd1 >= 0) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 2;
                    gold1 -= nd1;
                    nd1++;
                    Attack[i][1] = 50;
                    Defence[i][1] = 100;
                    PreTime[i][1] = System.currentTimeMillis();
                }
                if (knight && Player[i][1] == 0 && T - pre > 5000 && gold1 - nk1 >= 0) {
                    pre = T;
                    Player[i][1] = 1;
                    Character[i][1] = 3;
                    gold1 -= nk1;
                    nk1++;
                    Attack[i][1] = 70;
                    Defence[i][1] = 55;
                    PreTime[i][1] = System.currentTimeMillis();
                }
            }
        }

    }
    
    public void OneDrawRect(Graphics2D g)
    {
        Font fs = new Font("Impact", Font.BOLD, 20);
        Color Sc = new Color(155,155,155);
        g.setFont(fs);
        g.setColor(Sc);
        if(knight){
            g.drawString("KNIGHT", 100, 30);
        }
        else if(attack)
            g.drawString("ARCHER", 100, 30);
        else if(defence)
            g.drawString("DEFENCE", 100, 30);
        g.setColor(Color.RED);
    }
    

    public void mouseDragged(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (pc == 1) {
                attack = true;
                defence = false;
                knight = false;

            }

            if (pc == 2) {
                attack = false;
                defence = true;
                knight = false;
            }

            if (pc == 3) {
                attack = false;
                defence = false;
                knight = true;
            }

            int x = e.getX(), tx;
            int y = e.getY(), ty;
            for (int i = 1; i <= 9; i++) {
                if (x >= X[i][1] && x <= X[i][1] + 47 && y >= Y[i][1] && y <= Y[i][1] + 47) {
                    long T = System.currentTimeMillis();
                    if (attack && Player[i][1] == 0 && T - pre > 5000 && gold1 - na1 >= 0) {
                        pre = T;
                        Player[i][1] = 1;
                        Character[i][1] = 1;
                        gold1 -= na1;
                        na1++;
                        Attack[i][1] = 100;
                        Defence[i][1] = 60;
                        PreTime[i][1] = System.currentTimeMillis();
                    }
                    if (defence && Player[i][1] == 0 && T - pre > 5000 && gold1 - nd1 >= 0) {
                        pre = T;
                        Player[i][1] = 1;
                        Character[i][1] = 2;
                        gold1 -= nd1;
                        nd1++;
                        Attack[i][1] = 50;
                        Defence[i][1] = 100;
                        PreTime[i][1] = System.currentTimeMillis();
                    }
                    if (knight && Player[i][1] == 0 && T - pre > 5000 && gold1 - nk1 >= 0) {
                        pre = T;
                        Player[i][1] = 1;
                        Character[i][1] = 3;
                        gold1 -= nk1;
                        nk1++;
                        Attack[i][1] = 70;
                        Defence[i][1] = 55;
                        PreTime[i][1] = System.currentTimeMillis();
                    }
                }
            }

        } else if (SwingUtilities.isRightMouseButton(e)) {
            pc++;
            if (pc == 4) {
                pc = 1;
            }
        }
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
