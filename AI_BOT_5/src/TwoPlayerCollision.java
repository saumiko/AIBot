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
                    while (Pre - T <= 5000) {
                        Pre = System.currentTimeMillis();
                        g = s.getGraphics();
                        g.drawImage(lose, 0, 0, 800, 600, null);
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
                } else if (Player[row][14] == 1) {
                    oneP = false;
                    long T = System.currentTimeMillis();
                    long Pre = T;
                    while (Pre - T <= 5000) {
                        Pre = System.currentTimeMillis();
                        //System.out.println("YES");
                        g = s.getGraphics();
                        g.drawImage(win, 0, 0, 800, 600, null);
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

               // if (Defence[row][column]+Attack[row][column] <= 0) {
                //   Player[row][column] = 0;
                //}
                // ARROW ME
                if (column + 4 <= 13 && Player[row][column] == 1 && Character[row][column] == 1 && Player[row][column + 4] == 2) {
                    if (Player[row][column + 1] == 0 && Player[row][column + 2] == 0 && Player[row][column + 3] == 0) {
                        int sumME = Attack[row][column] + Defence[row][column];
                        int sumAI = Attack[row][column + 4] + Defence[row][column + 4];
                        if (sumME > sumAI) {
                            Player[row][column + 1] = 1;
                            Character[row][column + 1] = 4;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                            
                        }
                    }
                }
                if (column + 3 <= 13 && Player[row][column] == 1 && Character[row][column] == 1 && Player[row][column + 3] == 2) {
                    if (Player[row][column + 1] == 0 && Player[row][column + 2] == 0) {
                        int sumME = Attack[row][column] + Defence[row][column];
                        int sumAI = Attack[row][column + 3] + Defence[row][column + 3];
                        if (sumME > sumAI) {
                            Player[row][column + 1] = 1;
                            Character[row][column + 1] = 4;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    }
                }
                if (column + 2 <= 13 && Player[row][column] == 1 && Character[row][column] == 1 && Player[row][column + 2] == 2) {
                    if (Player[row][column + 1] == 0) {
                        int sumME = Attack[row][column] + Defence[row][column];
                        int sumAI = Attack[row][column + 2] + Defence[row][column + 2];
                        if (sumME > sumAI) {
                            Player[row][column + 1] = 1;
                            Character[row][column + 1] = 4;
                            PreTime[row][column + 1] = System.currentTimeMillis();
                        }
                    }
                }

                // ARROW AI
                if (column - 4 >= 1 && Player[row][column] == 2 && Character[row][column] == 1 && Player[row][column - 4] == 1) {
                    if (Player[row][column - 1] == 0 && Player[row][column - 2] == 0 && Player[row][column - 3] == 0) {
                        int sumAI = Attack[row][column] + Defence[row][column];
                        int sumME = Attack[row][column - 4] + Defence[row][column - 4];
                        if (sumME <= sumAI) {
                            Player[row][column - 1] = 2;
                            Character[row][column - 1] = 4;
                            PreTime[row][column - 1] = System.currentTimeMillis();
                        }
                    }
                }
                if (column - 3 >= 1 && Player[row][column] == 2 && Character[row][column] == 1 && Player[row][column - 3] == 1) {
                    if (Player[row][column - 1] == 0 && Player[row][column - 2] == 0) {
                        int sumAI = Attack[row][column] + Defence[row][column];
                        int sumME = Attack[row][column - 3] + Defence[row][column - 3];
                        if (sumME <= sumAI) {
                            Player[row][column - 1] = 2;
                            Character[row][column - 1] = 4;
                            PreTime[row][column - 1] = System.currentTimeMillis();
                        }
                    }
                }
                if (column - 2 >= 1 && Player[row][column] == 2 && Character[row][column] == 1 && Player[row][column - 2] == 1) {
                    if (Player[row][column + 1] == 0) {
                        int sumAI = Attack[row][column] + Defence[row][column];
                        int sumME = Attack[row][column - 2] + Defence[row][column - 2];
                        if (sumME > sumAI) {
                            Player[row][column - 1] = 2;
                            Character[row][column - 1] = 4;
                            PreTime[row][column - 1] = System.currentTimeMillis();
                        }
                    }
                }

                if (Player[row][column] == 1 && Player[row][column + 1] == 2) {
                    if (Character[row][column] == 4 && Player[row][column + 1] == 2) {
                        Player[row][column + 1] = 0;
                        Player[row][column] = 0;
//                        gold1 += 3;
                    } else if (Character[row][column + 1] == 4 && Player[row][column] == 1) {
                        Player[row][column + 1] = 0;
                        Player[row][column] = 0;
//                        gold2 += 3;
                    } else {
                        int sumME = Attack[row][column] + Defence[row][column];
                        int sumAI = Attack[row][column + 1] + Defence[row][column + 1];
                        if (sumME > sumAI) {
                            new Slash();
                            gold1 += 3;
//                        if(Character[row][column+1] == 1)
//                            g.drawImage(attack2d,X[row][column+1],Y[row][column+1],null);
//                        else if(Character[row][column+1] == 2)
//                            g.drawImage(defence2d,X[row][column+1],Y[row][column+1],null);
//                        else if(Character[row][column+1] == 3)
//                            g.drawImage(knight2d,X[row][column+1],Y[row][column+1],null);
//                        try
//                        {
//                            Thread.sleep(9000);
//                        }
//                        catch(Exception e){}
                            if (Character[row][column] == 1) {
                                Player[row][column + 1] = 1;
                                a2 = true;

                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    a2 = false;
                                }
                                Player[row][column] = 0;
                                Character[row][column + 1] = 1;
                                Attack[row][column + 1] = Attack[row][column] - 30;
                                Defence[row][column + 1] = Defence[row][column] - 30;
                                PreTime[row][column + 1] = System.currentTimeMillis();
                            } else if (Character[row][column] == 2) {

                                Player[row][column + 1] = 1;
                                d2 = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    d2 = false;
                                }
                                Player[row][column] = 0;
                                Character[row][column + 1] = 2;
                                Attack[row][column + 1] = Attack[row][column] - 30;
                                Defence[row][column + 1] = Defence[row][column] - 30;
                                PreTime[row][column + 1] = System.currentTimeMillis();

                            } else if (Character[row][column] == 3) {
                                Player[row][column + 1] = 1;
                                k2 = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    k2 = false;
                                }
                                Player[row][column] = 0;
                                Character[row][column + 1] = 3;
                                Attack[row][column + 1] = Attack[row][column] - 30;
                                Defence[row][column + 1] = Defence[row][column] - 30;
                                PreTime[row][column + 1] = System.currentTimeMillis();
                            }

                        } else {
                            new Slash();
                            gold2 += 3;
//                        if(Character[row][column] == 1)
//                            g.drawImage(attack1d,X[row][column],Y[row][column],null);
//                        else if(Character[row][column] == 2)
//                            g.drawImage(defence1d,X[row][column],Y[row][column],null);
//                        else if(Character[row][column-1] == 3)
//                            g.drawImage(knight1d,X[row][column],Y[row][column],null);
//                        try
//                        {
//                            Thread.sleep(9000);
//                        }
//                        catch(Exception e){}
                            if (Character[row][column + 1] == 1) {
                                Player[row][column] = 2;
                                a1 = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    a1 = false;
                                }
                                Player[row][column + 1] = 0;
                                Character[row][column] = 1;
                                Attack[row][column] = Attack[row][column + 1] - 30;
                                Defence[row][column] = Defence[row][column + 1] - 30;
                                PreTime[row][column] = System.currentTimeMillis();
                            } else if (Character[row][column + 1] == 2) {
                                Player[row][column] = 2;
                                d1 = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    d1 = false;
                                }
                                Player[row][column + 1] = 0;
                                Character[row][column] = 2;
                                Attack[row][column] = Attack[row][column + 1] - 30;
                                Defence[row][column] = Defence[row][column + 1] - 30;
                                PreTime[row][column + 1] = System.currentTimeMillis();

                            } else if (Character[row][column + 1] == 3) {
                                Player[row][column] = 2;
                                k1 = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                } finally {
                                    k1 = false;
                                }
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
    }
}
