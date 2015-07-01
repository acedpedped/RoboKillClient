package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
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

	protected int xPos;
	protected int yPos;
    protected double dir;
    protected double degDif;
    protected int health;

	public static final String sep = File.separator;

    public Enemy(int i, int j)
    {
        this.dir = -Math.PI / 2;
        health = 3;
    }

	public void move(int x, int y)
	{
        double shib = (Math.atan2((double)x, (double)y) - Math.atan2((double)xPos, (double)yPos));

	}

    public void die(ArrayList<Enemy> enemies, int index)
    {

    }

    /**
     *
     * @return the angle that enemy shoud turn
     */
    public double degDif()
    {
        return degDif;
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

    public void setDir(double dir)
    {
        this.dir = dir;
    }

    /**
     *
     * @return the value of dir
     */
    public double getDir()
    {
        return dir;
    }
	public Image getImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 413.png").getImage();
	}
}
