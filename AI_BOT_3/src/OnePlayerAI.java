import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class OnePlayerAI extends OnePlayer implements MouseListener, MouseMotionListener{

    public static long preAI = 0;
    static int row, column,charach;
    static int nattack = 0, ndefence = 0, nknight = 0;
    
    OnePlayerAI(){
        
    }
    
    public void PaintAndCheck(Graphics2D g){
        for (row = 1; row <= 9; row++) {
            for (column = 1; column <= 13; column++) {
                if (Player[row][column] == 2) {
                    if (Character[row][column] == 1) {
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
                }
            }
        }
        long T = System.currentTimeMillis();
        if(T-preAI >= 4000){
            Random rand = new Random();
            int row = rand.nextInt(9) + 1;
            while(Player[row][1]!=0){
                row = rand.nextInt(9) + 1;
            }
            column=13;
            Player[row][column] = 2;
            charach = rand.nextInt(3) + 1;
            if(charach==1){
                Character[row][column] = 1;
                Attack[row][column] = 100;
                Defence[row][column] = 60;
                PreTime[row][column] = preAI = System.currentTimeMillis();
            }
            else if(charach==2){
                Character[row][column] = 2;
                Attack[row][column] = 50;
                Defence[row][column] = 100;
                PreTime[row][column] = preAI = System.currentTimeMillis();
            }
            else if(charach==3){
                Character[row][column] = 3;
                Attack[row][column] = 70;
                Defence[row][column] = 55;
                PreTime[row][column] = preAI =  System.currentTimeMillis();
            }
        }
    }

    
}
