
package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA. User: pedram Date: 6/23/15 Time: 8:31 AM To
 * change this template use File | Settings | File Templates.
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
		Image img = new ImageIcon(getClass().getResource("resourses" + sep + "Image" + sep + "image 3.jpg")).getImage();
		g.drawImage(img, 0, 0, 800, 550, null);
		loading(g);

	}

	public void loading(Graphics g)
	{
		Image img1 = new ImageIcon(getClass().getResource("resourses" + sep + "Image" + sep + "image 1.png")).getImage();
		for (int i = 0; i <= 663; i += 4)
		{
			g.drawImage(img1, 69, 481, i, 17, null);
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
