package robokill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.File;

/**
 * Menu Class which appears at the beginning.
 * 
 * @author ParhamMLK
 * @author pedram
 * 
 * @version 1.0
 */
public class Menu extends JPanel{
    protected ImageIcon button, button1;
    protected Image img;
    protected Font font = new Font("Verdana", Font.BOLD | Font.ITALIC, 15);
    //protected JFrame frame;
    //MainMenu main = new MainMenu();
	
	public static final String sep = File.separator;
	
    public Menu() {
        setSize(800, 600);
        setLayout(null);

        button = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 597.png");
        button1 = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 462.png");

        img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 700.jpg").getImage();

        //frame.add(main);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
        /*credits.repaint();
        options.repaint();
        start.repaint();*/
    }

}
