package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public static JFrame frame;

	public static final String sep = File.separator;

	public static MainMenu mainMenu;
	private JPanel panel;

	public boolean voiceOn = true;
	
	
	public Robokill()
	{
		this.frame = new JFrame();
//		setUndecorated(true);

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocation(150, 70);
		frame.setResizable(false);

		panel = new JPanel(true)
		{

			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);

				Image img1 = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 3.jpg").getImage();
				g.drawImage(img1, 0, 0, 800, 600, null);
			}

		};

		frame.add(panel);
		frame.setVisible(true);
		loading();
		mainMenu = new MainMenu();
        frame.remove(panel);
		frame.add(mainMenu);
		frame.repaint();
		//frame.repaint();

	}

	private void loading()
	{
		final Graphics g = frame.getGraphics();
		Thread t = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
				for (int i = 0; i <= 664; i += 2)
				{
					g.drawImage(img, 72, 550, i, 18, null);
					try
					{
						Thread.sleep(5);
					}
					catch (InterruptedException e)
					{
					}
				}

			}
		});
		t.start();
		try
		{
			t.join();
		}
		catch (InterruptedException ex)
		{
			Logger.getLogger(Robokill.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	public static void main(String args[])
	{
		new Robokill();
	}

}
