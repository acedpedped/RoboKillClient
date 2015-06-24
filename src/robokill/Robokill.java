
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
public class Robokill extends JFrame
{

	public static final String sep = File.separator;

	public Robokill()
	{
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 550);
		setLocation(150, 70);
		setResizable(false);
		setLayout(null);

		setVisible(true);

	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 3.jpg").getImage();
		g.drawImage(img, 0, 0, 800, 550, null);
		loading(g);

	}

	public void loading(Graphics g)
	{
		Image img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 1.png").getImage();
		for (int i = 0; i <= 663; i += 4)
		{
			g.drawImage(img, 69, 481, i, 17, null);
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
			}
		}
		dispose();
		new Menu();
	}

	public static void main(String args[])
	{
		new Robokill();
	}
}
