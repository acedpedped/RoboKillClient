
package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Class Robokill. start point of program.
 * 
 * @author pedram
 * @author ParhamMLK
 * 
 * @version 1.0
 */
public class Robokill
{
    public static JFrame frame = new JFrame();

	public static final String sep = File.separator;

    public static MainMenu mainMenu;
    private JPanel panel;

    public boolean voiceOn = true;

	public Robokill()
	{
		//setUndecorated(true);
        panel = new SetBack();
        frame.setLayout(new CardLayout());
//        frame.setLayout(new CardLayout());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocation(150, 70);
	    frame.setResizable(false);
		//frame.setLayout(null);


        frame.getContentPane().add(panel);
		frame.setVisible(true);

	}



	public static void main(String args[])
	{
        new Robokill();
	}
    private class SetBack extends JPanel
    {
        public SetBack()
        {
            setSize(800, 600);
            setVisible(true);
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 3.jpg").getImage();
            g.drawImage(img, 0, 0, null);
            loading(g);
        }


        public void loading(Graphics g)
        {
            /*Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
            for (int i = 0; i <= 663; i+=3)
            {
                g.drawImage(img, 70, 526, i, 16, null);
                //repaint();
                try
                {
                    Thread.sleep(20);
                }
                catch (InterruptedException e)
                {
                }
            } */
            //dispose();
            //new RoomTest();
            frame.remove(panel);
            mainMenu = new MainMenu();
            frame.add(mainMenu);

        }
    }




}
