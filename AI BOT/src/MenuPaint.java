import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPaint extends Main
{
    static void paintPlayer(Graphics2D g)
    {
        if(keyOnePlayer)
            g.drawImage(onePlayer, 0, 0, null);
        if(keyTwoPlayer)
            g.drawImage(twoPlayer, 0, 0, null);
    }
    
    static void paintOpen(Graphics2D g)
    {
        g.drawImage(open, 0, 0, null);
    }
    
    static void paintMenu(Graphics2D g)
    {
        if(keyPlay)
            g.drawImage(play,0,0,null);
        else if(keyHelp)
            g.drawImage(help,0,0,null);
        else if(keyAbout)
            g.drawImage(about,0,0,null);
        else if(keyExit)
            g.drawImage(exit,0,0,null);
    }
    
    static void paintConnection(Graphics2D g)
    {
        if(keyServer)
            g.drawImage(server,0,0,null);
        else if(keyClient)
            g.drawImage(client,0,0,null);
    }
}
