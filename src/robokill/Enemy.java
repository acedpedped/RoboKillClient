package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class Enemy. Base class for different enemies.
 *
 * @author ParhamMLK
 * @author pedram
 *
 * @version 1.0
 */
public abstract class Enemy extends JPanel
{

	private int xPos;
	private int yPos;

	private static final int[] dx =
	{
		-1, -1, -1, 0, 0, 0, 1, 1, 1
	};
	private static final int[] dy =
	{
		-1, 0, 1, -1, 0, 1, -1, 0, 1
	};

	public static final String sep = File.separator;

	public void move()
	{
		Random rnd = new Random();

		xPos += dx[rnd.nextInt(dx.length)];
		yPos += dy[rnd.nextInt(dy.length)];
	}

	/**
	 * Get the value of xPos
	 *
	 * @return the value of xPos
	 */
	public int getxPos()
	{
		return xPos;
	}

	/**
	 * Set the value of xPos
	 *
	 * @param xPos new value of xPos
	 */
	public void setxPos(int xPos)
	{
		this.xPos = xPos;
	}

	/**
	 * Get the value of yPos
	 *
	 * @return the value of yPos
	 */
	public int getyPos()
	{
		return yPos;
	}

	/**
	 * Set the value of yPos
	 *
	 * @param yPos new value of yPos
	 */
	public void setyPos(int yPos)
	{
		this.yPos = yPos;
	}

	public Image getImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 413.png").getImage();
	}
}
