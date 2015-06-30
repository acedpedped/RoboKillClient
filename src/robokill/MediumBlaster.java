/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import javax.swing.ImageIcon;
import static robokill.LightBlaster.sep;


public class MediumBlaster extends Weapon
{

	public MediumBlaster(Room room)
	{
		super(250, 10, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room, 1);
	}

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "mb.png").getImage();
	}	
}
