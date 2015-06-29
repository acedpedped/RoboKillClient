/*
 * in the name of God
 */
package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import static robokill.Robot.sep;


public class LightBlaster extends Blaster
{
	public static final String sep = File.separator;

	public LightBlaster(Room room)
	{
		super(300, 4, 5, 5, new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 206.png").getImage(), room);
	}

	

	@Override
	public Image getFireImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "bullets" + sep + "lb.png").getImage();
	}

	@Override
	public void addBullet(Point dif)
	{
		dif.x -= getRoom().getRobot().getxPos();
		dif.y -= getRoom().getRobot().getyPos();
//		System.err.println(dif);
		double angle = 180.0 / Math.PI * Math.atan2(-dif.x, dif.y);
//		System.err.println(angle);
//		System.err.println(angle);
		getRoom().addBullet(new Bullet(5, getRoom().getRobot().getxPos(), getRoom().getRobot().getyPos(), angle, getFireImage()));
	}
	
}
