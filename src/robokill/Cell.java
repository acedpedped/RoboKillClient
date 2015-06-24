/*
 * in the name of God
 */
package robokill;

import java.awt.Image;

/**
 *
 * @author ParhamMLK
 */
public class Cell
{
	private Object thing;
	private int x, y;
	private int state;

	
	public Cell(Object thing)
	{
		this.thing = thing;
		state = 0;
	}	

	public Image getImage()
	{
		return thing.getImage();
	}
	
	
}
