import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.lang.*;
import java.util.Scanner;

public class Main implements KeyListener, /*MouseListener, MouseMotionListener*/ Runnable {

    Sword sword;
    Sword2 sword2;

    public static Graphics2D g;
    static public ScreenManager s;
    static public Window w;
    static public OnePlayer op;
    static public OnePlayerAI opAI;
    static public OnePlayerCollision opCOL;
    static public ClientOne C1;
    static public ClientTwo C2;
    static public TwoPlayerCollision tpc;

    static boolean attack = false, defence = false, knight = false;
    static boolean nattack = false, ndefence = false, nknight = false;

    static int[][] Character = new int[32][32];
    static int[][] Adead = new int[32][32];
    static int[][] Player = new int[32][32];
    static long[][] PreTime = new long[32][32];
    static int[][] Attack = new int[32][32];
    static int[][] Defence = new int[32][32];
    static int[][] X = new int[32][32];
    static int[][] Y = new int[32][32];
    int row, column;
    //int nattack = 0, ndefence = 0, nknight = 0;
    static long pre = 0;

    static SoundThread bsound = new SoundThread();

    static public Image open, play, help, about, exit, onePlayer, twoPlayer, background1, background2, server, client, lose, win, aboutm, helpm;
    static public Image knight1, knight2, attack1, attack2, defence1, defence2, arrow, arrowl, arrowr;
    static public Image knight1d, knight2d, attack1d, attack2d, defence1d, defence2d,fight;

    static public boolean keyPlay = true, keyHelp = false, keyAbout = false, keyExit = false, keyOnePlayer = false, keyTwoPlayer = false, keyServer = false, keyClient = false;

    static public boolean About = false, Help = false, Exit = false, Menu = false, Open = true;

    static public boolean a1 = false, a2 = false, d1 = false, d2 = false, k1 = false, k2 = false;

    static public boolean Play = false, oneP = false, twoP = false, Server = false, Client = false, c1 = false, c2 = false;

    static public int X1 = 98, X2 = 650;

    static public int i, j;

    static public int gold1 = 0, gold2 = 0, nk1, nk2, na1, na2, nd1, nd2;

    public static String Encrypt = new String();

    // public static final DisplayMode modes1[]
    //   = {
    //         new DisplayMode(800, 600, 32, 0),};
    public static void main(String args[]) {
        Main main = new Main();
        main.run();
    }

    /**
     * DisplayMode to choose for full screen. Note: This is initiated only for
     * my own pc. Haven't got the opportunity to check if it works on every pc.
     * But in most cases it works fine.
     */
    private static final DisplayMode modes1[]
            = {
                new DisplayMode(800, 600, 32, 0) // new DisplayMode(800,600,24,0),
            //new DisplayMode(800,600,16,0),
            //new DisplayMode(640,480,32,0),
            //new DisplayMode(640,480,24,0),
            //new DisplayMode(640,480,16,0),
            //new DisplayMode(1366, 768, 16, 0),
            };

    /**
     * This method initializes everything
     */
    public void init() {
        open = new ImageIcon("Files/Images/Menu/Open.png").getImage();
        about = new ImageIcon("Files/Images/Menu/About.png").getImage();
        help = new ImageIcon("Files/Images/Menu/Help.png").getImage();
        exit = new ImageIcon("Files/Images/Menu/Exit.png").getImage();
        play = new ImageIcon("Files/Images/Menu/Play.png").getImage();
        aboutm = new ImageIcon("Files/Images/Menu/aboutM.png").getImage();
        helpm = new ImageIcon("Files/Images/Menu/helpM.png").getImage();
        onePlayer = new ImageIcon("Files/Images/Menu/1p.png").getImage();
        twoPlayer = new ImageIcon("Files/Images/Menu/2p.png").getImage();
        background1 = new ImageIcon("Files/Images/Char/BG1.png").getImage();
        background2 = new ImageIcon("Files/Images/Char/BG2.png").getImage();
        knight1 = new ImageIcon("Files/Images/Char/Knight1.png").getImage();
        knight2 = new ImageIcon("Files/Images/Char/Knight2.png").getImage();
        attack1 = new ImageIcon("Files/Images/Char/Attack1.png").getImage();
        attack2 = new ImageIcon("Files/Images/Char/Attack2.png").getImage();
        defence1 = new ImageIcon("Files/Images/Char/Defence1.png").getImage();
        defence2 = new ImageIcon("Files/Images/Char/Defence2.png").getImage();
        arrow = new ImageIcon("Files/Images/Char/Arrow.png").getImage();
        arrowr = new ImageIcon("Files/Images/Play/Arrow1.png").getImage();
        arrowl = new ImageIcon("Files/Images/Play/Arrow2.png").getImage();
        knight1d = new ImageIcon("Files/Images/Char/Dead/Knight1.png").getImage();
        knight2d = new ImageIcon("Files/Images/Char/Dead/Knight2.png").getImage();
        attack1d = new ImageIcon("Files/Images/Char/Dead/Attack1.png").getImage();
        attack2d = new ImageIcon("Files/Images/Char/Dead/Attack2.png").getImage();
        defence1d = new ImageIcon("Files/Images/Char/Dead/Defence1.png").getImage();
        defence2d = new ImageIcon("Files/Images/Char/Dead/Defence2.png").getImage();
        fight = new ImageIcon("Files/Images/Char/Dead/deadfred.png").getImage();
        client = new ImageIcon("Files/Images/Menu/Client.png").getImage();
        server = new ImageIcon("Files/Images/Menu/Server.png").getImage();
        lose = new ImageIcon("Files/Images/Play/YouLose.png").getImage();
        win = new ImageIcon("Files/Images/Play/YouWin.png").getImage();
        nk1 = 0;
        na1 = 0;
        nd1 = 0;
        nk2 = 0;
        na2 = 0;
        nd2 = 0;
        //nattack = 0;
        //ndefence = 0;
        //nknight = 0;
        for (row = 0; row < 32; row++) {
            for (column = 0; column < 32; column++) {
                Player[row][column] = 0;
                Character[row][column] = 0;
                PreTime[row][column] = 0;
                Attack[row][column] = 0;
                Defence[row][column] = 0;

            }
        }
        for (row = 1, j = 65; row <= 9; row++) {
            i = 90;
            for (column = 1; column <= 13; column++) {
                X[row][column] = i;
                Y[row][column] = j;
                i += 47;
            }
            j += 47;

        }
        s = new ScreenManager();
    }

    public void run() {
        init();
        try {
            DisplayMode dm = s.findFirstCompatibleMode(modes1);
            s.setFullScreen(dm);
            w = s.getFullScreenWindow();
            w.addKeyListener(this);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage("Files/Images/Ab.gif");
            Point hotSpot = new Point(16, 16);
            Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Ab");
            w.setCursor(cursor);
            while (Open) {
                Graphics2D g1 = s.getGraphics();
                MenuPaint.paintOpen(g1);
                s.update();
                g1.dispose();
                if (Menu) {
                    while (Menu) {
                        //Play=true;
                        Graphics2D g = s.getGraphics();
                        MenuPaint.paintMenu(g);
                        s.update();
                        g.dispose();
                        if (Exit) {
                            System.exit(0);
                        }
                        if (About) {
                            while (About) {
                                g = s.getGraphics();
                                MenuPaint.paintAbout(g);
                                s.update();
                                g.dispose();
                            }
                        }
                        if (Help) {
                            while (Help) {
                                g = s.getGraphics();
                                MenuPaint.paintHelp(g);
                                s.update();
                                g.dispose();
                            }
                        }
                        if (Play) {
                            while (Play) {

                                //oneP=true; 
                                g = s.getGraphics();
                                MenuPaint.paintPlayer(g);
                                s.update();
                                g.dispose();
                                if (oneP) {
                                    op = new OnePlayer();
                                    opAI = new OnePlayerAI();
                                    opCOL = new OnePlayerCollision();
                                    nk1 = 0;
                                    na1 = 0;
                                    nd1 = 0;
                                    nk2 = 0;
                                    na2 = 0;
                                    nd2 = 0;
                                    for (row = 0; row < 32; row++) {
                                        for (column = 0; column < 32; column++) {
                                            Player[row][column] = 0;
                                            Character[row][column] = 0;
                                            PreTime[row][column] = 0;
                                            Attack[row][column] = 0;
                                            Defence[row][column] = 0;

                                        }
                                    }
                                    while (oneP) {
                                        //  System.out.println(Player[2][1]);
                                        g = s.getGraphics();
                                        op.PaintAndCheck(g);
                                        //EncryptData();
                                        //DecryptData();
                                        opAI.PaintAndCheck(g);
                                        opCOL.Collision(g);
                                        s.update();
                                        g.dispose();
                                    }

                                } else if (twoP) {
                                    C1 = new ClientOne();
                                    C2 = new ClientTwo();
                                    for (row = 0; row < 32; row++) {
                                        for (column = 0; column < 32; column++) {
                                            Player[row][column] = 0;
                                            Character[row][column] = 0;
                                            PreTime[row][column] = 0;
                                            Attack[row][column] = 0;
                                            Defence[row][column] = 0;

                                        }
                                    }
                                    gold1 = 10;
                                    gold2 = 10;
                                    nk1 = 0;
                                    nk2 = 0;
                                    na1 = 0;
                                    na2 = 0;
                                    nd1 = 0;
                                    nd2 = 0;
                                    tpc = new TwoPlayerCollision();
                                    while (twoP) {
                                        g = s.getGraphics();
                                        //MenuPaint.paintConnection(g);
                                        C1.PaintAndCheck(g);
                                        C2.PaintAndCheck(g);
                                        tpc.Collision(g);
                                        s.update();
                                        g.dispose();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            s.restoreScreen();
        }
    }

    public static void paintPlay(Graphics2D g1) {
        if (c1) {
            g1.drawImage(background1, 0, 0, null);
        } else if (c2) {
            g1.drawImage(background2, 0, 0, null);
        }
        if (X1 + 50 <= 750) {
            X1 += 50;
            X2 -= 50;
        }
        g1.drawImage(defence1, X1, 250, 55, 53, null);
        g1.drawImage(defence2, X2, 250, 55, 53, null);
    }

    private void paintPlayOne(Graphics2D g1) {
        g1.drawImage(background1, 0, 0, null);
    }

    public void EncryptData() {
        Encrypt = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 14; j++) {
                //g = s.getGraphics();
                //s.update();
                //g.dispose();
                Encrypt += Integer.toString(Player[i][j]);
                Encrypt += ",";
                Encrypt += Integer.toString(Character[i][j]);
                Encrypt += ",";
                Encrypt += Long.toString(PreTime[i][j]);
                Encrypt += ",";
                Encrypt += Integer.toString(Attack[i][j]);
                Encrypt += ",";
                Encrypt += Integer.toString(Defence[i][j]);
                if (i != 9 || j != 14) {
                    Encrypt += ",";
                }
            }
        }
    }

    public void DecryptData() {
        int l = 0;
        String[] stringArray = Encrypt.split(",");
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 14; j++) {
                //g = s.getGraphics();
                //s.update();
                //g.dispose();
                Player[i][j] = Integer.parseInt(stringArray[l]);
                l++;
                Character[i][j] = Integer.parseInt(stringArray[l]);
                l++;
                PreTime[i][j] = Integer.parseInt(stringArray[l]);
                l++;
                Attack[i][j] = Integer.parseInt(stringArray[l]);
                l++;
                Defence[i][j] = Integer.parseInt(stringArray[l]);
                l++;
            }
        }

    }

    public void keyPressed(KeyEvent e) {
        Menu = true;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //System.exit(0);
            Play = false;
            oneP = false;
            twoP = false;
            Server = false;
            Client = false;
            keyHelp = false;
            keyAbout = false;
            keyExit = false;
            keyOnePlayer = false;
            keyTwoPlayer = false;
            keyServer = false;
            keyClient = false;
            About = false;
            Help = false;
            keyPlay = true;
            Exit = false;
            Menu = true;
            init();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (keyPlay) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyPlay = false;
                keyExit = false;
                keyAbout = false;
                keyHelp = true;
            } else if (keyHelp) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyPlay = false;
                keyExit = false;
                keyHelp = false;
                keyAbout = true;
            } else if (keyAbout) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyPlay = false;
                keyHelp = false;
                keyAbout = false;
                keyExit = true;
            } else if (keyExit) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyHelp = false;
                keyExit = false;
                keyAbout = false;
                keyPlay = true;
            }
            if (keyOnePlayer) {
                sword2 = new Sword2();
                keyOnePlayer = false;
                keyTwoPlayer = true;
            } else if (keyTwoPlayer) {
                sword2 = new Sword2();
                keyTwoPlayer = false;
                keyOnePlayer = true;
            }
            if (keyServer) {
                sword2 = new Sword2();
                keyServer = false;
                keyClient = true;
            } else if (keyClient) {
                sword2 = new Sword2();
                keyClient = false;
                keyServer = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (keyPlay) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyPlay = false;
                keyHelp = false;
                keyAbout = false;
                keyExit = true;
            } else if (keyHelp) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyAbout = false;
                keyExit = false;
                keyHelp = false;
                keyPlay = true;
            } else if (keyAbout) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyPlay = false;
                keyExit = false;
                keyAbout = false;
                keyHelp = true;
            } else if (keyExit) {
                sword2 = new Sword2();
                //keyOnePlayer=false;
                //keyTwoPlayer=false;
                keyHelp = false;
                keyExit = false;
                keyPlay = false;
                keyAbout = true;
            }
            if (keyOnePlayer) {
                sword2 = new Sword2();
                keyOnePlayer = false;
                keyTwoPlayer = true;
            } else if (keyTwoPlayer) {
                sword2 = new Sword2();
                keyTwoPlayer = false;
                keyOnePlayer = true;
            }
            if (keyServer) {
                sword2 = new Sword2();
                keyServer = false;
                keyClient = true;
            } else if (keyClient) {
                sword2 = new Sword2();
                keyClient = false;
                keyServer = true;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (keyServer) {
                sword = new Sword();
                Server = true;
            } else if (keyClient) {
                sword = new Sword();
                Client = true;
            }
            if (keyOnePlayer) {
                sword = new Sword();
                oneP = true;
            } else if (keyTwoPlayer) {
                sword = new Sword();
                keyServer = true;
                keyClient = false;
                twoP = true;
            }
            if (keyPlay) {
                sword = new Sword();
                keyOnePlayer = true;
                keyTwoPlayer = false;
                Play = true;
            } else if (keyHelp) {
                sword = new Sword();
                Help = true;
            } else if (keyAbout) {
                sword = new Sword();
                About = true;
            } else if (keyExit) {
                sword = new Sword();
                Exit = true;
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
