/**
 * Class Weapon.
 *
 * @author ParhamMLK
 * @author pedram
 * @version 1.0
 */
package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public abstract class Weapon implements Runnable
{

	private int delay;
	private int requiredLevel;
	private int damage;
	private int cost;
	private Image img;
	private Room room;
	private volatile boolean running = false;

	public void terminate()
	{
		running = false;
	}

	public void begin()
	{
		running = true;
	}

	public Room getRoom()
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	public Weapon(int delay, int requiredLevel, int damage, int cost, Image img, Room room)
	{
		this.delay = delay;
		this.requiredLevel = requiredLevel;
		this.damage = damage;
		this.cost = cost;
		this.img = img;
		this.room = room;

	}

	public abstract Image getFireImage();

	public double getDelay()
	{
		return delay;
	}

	public void setDelay(int delay)
	{
		this.delay = delay;
	}

	public int getRequiredLevel()
	{
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel)
	{
		this.requiredLevel = requiredLevel;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	@Override
	public void run()
	{
		while (true)
		{
			if (!running)
			{
				continue;
			}

			try
			{
				Point dif = MouseInfo.getPointerInfo().getLocation();
				SwingUtilities.convertPointFromScreen(dif, room);
//				System.err.println(dif);
				addBullet(dif);
				Thread.sleep(delay);
			}
			catch (InterruptedException ex)
			{
				Logger.getLogger(Weapon.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public abstract void addBullet(Point dif);
}
