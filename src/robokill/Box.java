/*
 * in the name of God
 */
package robokill;

import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author ParhamMLK
 */
public class Box extends Object
{
	private static final String imgs[] = {"371", "638", "712", "897"};
	public static final String sep = File.separator;
	

	public Box(int i)
	{
		super(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + imgs[i%imgs.length] + ".png").getImage());
	}
	
	
	
}
