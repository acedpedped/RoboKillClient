/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import static robokill.LightBlaster.sep;


public class MediumShotgun extends Weapon
{

	public MediumShotgun(Room room)
	{
		super(900, 10, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room, 3);
	}

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "msh.png").getImage();
	}
	
}
