/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import static robokill.LightBlaster.sep;


public class HeavyShotgun extends Weapon
{

	public HeavyShotgun(Room room)
	{
		super(800, 15, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room, 4);
	}

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "hsh.png").getImage();
	}
	
}
