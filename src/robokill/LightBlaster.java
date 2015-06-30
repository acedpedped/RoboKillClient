/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import javax.swing.ImageIcon;


public class LightBlaster extends Weapon
{
	public static final String sep = File.separator;

	public LightBlaster(Room room)
	{
		super(300, 5, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room, 1);
	}

	

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "lb.png").getImage();
	}
	
}
