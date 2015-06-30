package robokill;

import java.awt.Image;

/**
 * 
 * @author ParhamMLK
 * @author pedram
 * 
 * @version 1.0
 */
public class Bullet
{
	private int damage;
	private int x;
	private int y;
	private double angle;
	private Image img;
	
	public Bullet(int damage, int x, int y, double angle, Image img)
	{
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.img = img;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public double getAngle()
	{
		return angle;
	}

	public void setAngle(double angle)
	{
		this.angle = angle;
	}

	public Image getImg()
	{
		return img;
	}

	public void setImg(Image img)
	{
		this.img = img;
	}

	void move()
	{		
		double sin = Math.sin(Math.toRadians(angle));
//		System.err.println(sin);
//		System.err.println("" + angle + " : " + Math.sin(angle));
		double cos = Math.cos(Math.toRadians(angle));
		
		double newx = x - sin*10;
		double newy = y + cos*10;
		setX((int)newx);
		setY((int)newy);
	}
	
	
	

}
