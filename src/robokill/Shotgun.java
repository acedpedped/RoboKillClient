/*
 * in the name of God
 */
package robokill;

import java.awt.*;

/**
 *
 * @author ParhamMLK
 */
public abstract class Shotgun extends Weapon
{

	public Shotgun(int delay, int requiredLevel, int damage, int cost, Image img, Room room)
	{
		super(delay, requiredLevel, damage, cost, img, room);
	}
	
	
}
