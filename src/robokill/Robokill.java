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

	public static JFrame frame;

	public static final String sep = File.separator;

	public static MainMenu mainMenu;
	private JPanel panel;

	public boolean voiceOn = true;

	public Robokill()
	{
		//setUndecorated(true);
//		SplashScreen scr = new SplashScreen();


		panel = new SetBack();
//        frame.setLayout(new CardLayout());
//        frame.setLayout(new CardLayout());
		frame = new JFrame();

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocation(150, 70);
		frame.setResizable(false);
		//frame.setLayout(null);

		frame.add(panel);
//		frame.setVisible(true);

	}

	public void loading(Graphics g)
	{
		Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
		for (int i = 0; i <= 663; i += 3)
		{
			g.drawImage(img, 70, 526, i, 16, null);
			//repaint();
			try
			{
				Thread.sleep(5);
			}
			catch (InterruptedException e)
			{
			}
		}

//            frame.remove(panel);
//            mainMenu = new MainMenu();
//            frame.add(mainMenu);
	}

	public static void main(String args[])
	{
		new Robokill();
		frame.setVisible(true);
	}

	private class SetBack extends JPanel
	{

		public SetBack()
		{
			setSize(800, 600);
			setVisible(true);
		}

		@Override
		public void paintComponent(final Graphics g)
		{
			super.paintComponent(g);
			Image bck = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 3.jpg").getImage();
			g.drawImage(bck, 0, 0, 800, 600, null);
//            loading(g);

			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
					for (int i = 0; i <= 663; i += 3)
					{
						g.drawImage(img, 70, 526, i, 16, null);
						//repaint();
						try
						{
							Thread.sleep(5);
						}
						catch (InterruptedException e)
						{
						}
					}
				}
			}).start();

		}

//		public void loading(Graphics g)
//		{
//			Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
//			for (int i = 0; i <= 663; i += 3)
//			{
//				g.drawImage(img, 70, 526, i, 16, null);
//				//repaint();
//				try
//				{
//					Thread.sleep(5);
//				}
//				catch (InterruptedException e)
//				{
//				}
//			}
//
////            frame.remove(panel);
////            mainMenu = new MainMenu();
////            frame.add(mainMenu);
//		}
	}

}
