/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import static robokill.LightBlaster.sep;


public class LightShotgun extends Weapon
{

	public LightShotgun(Room room)
	{
		super(1000, 5, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room, 2);
	}

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "lsh.png").getImage();
	}
	
}
