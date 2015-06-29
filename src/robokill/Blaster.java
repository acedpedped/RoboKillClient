/*
 * in the name of God
 */
package robokill;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author ParhamMLK
 */
public abstract class Blaster extends Weapon
{

	public Blaster(int delay, int requiredLevel, int damage, int cost, Image img, Room room)
	{
		super(delay, requiredLevel, damage, cost, img, room);
	}
	

	
}
