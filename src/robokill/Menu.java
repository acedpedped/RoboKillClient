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
public class Menu extends JFrame implements ActionListener {
    private JButton credits, start, options;
    private ImageIcon button;
	
	public static final String sep = File.separator;
	
    public Menu() {
        super("Robokill");
		setUndecorated(true);
        setSize(800, 600);
        setResizable(false);
        setLocation(150, 70);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 850.png");

        start = new JButton(button);
        start.setBounds(280, 200, 130, 40);
        start.addActionListener(this);

        options = new JButton(button);
        options.addActionListener(this);
        options.setBounds(280, 250, 130, 40 );


        credits = new JButton("credits", button);
        credits.addActionListener(this);
        credits.setBounds(280, 300, 130, 40);
        credits.setFocusable(false);
        credits.setContentAreaFilled(false);
        credits.setBorderPainted(false);
        credits.setOpaque(false);

        add(start);
        add(options);
        add(credits);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
		
        Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 700.jpg").getImage();
        g.drawImage(img, 0, 0, 800, 550, null);
        g.drawImage(button.getImage(), 250, 250, 130, 30, null);
        /*credits.repaint();
        options.repaint();
        start.repaint();*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
