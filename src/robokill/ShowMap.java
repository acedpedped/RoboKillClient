package robokill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 7/2/15
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShowMap extends JFrame implements KeyListener{
    public static String sep = File.separator;

    public ShowMap()
    {
        setSize(800, 600);
        setUndecorated(true);
        setLocation(150, 70);

        addKeyListener(this);

        setVisible(true);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Image background = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "map.JPG").getImage();
        g.drawImage(background, 0, 0, 800, 600, null);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_M)
            dispose();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
