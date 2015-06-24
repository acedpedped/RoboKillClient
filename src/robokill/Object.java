/*
 * in the name of God
 */
package robokill;

import java.awt.Image;

/**
 *
 * @author ParhamMLK
 */
public abstract class Object 
{
	private Image img;

	public Object(Image img)
	{
		this.img = img;
	}

	public Image getImage()
	{
		return img;
	}

}
