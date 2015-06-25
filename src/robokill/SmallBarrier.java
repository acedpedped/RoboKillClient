
package robokill;

import java.io.File;
import javax.swing.ImageIcon;


/**
 * 
 * @author pedram
 * @author ParhamMLK
 * 
 * @version 1.0
 */
public class SmallBarrier extends Object
{
	private static String imgs[] = {"188", "194", "198", "292", "497"};

	public static final String sep = File.separator;

	public SmallBarrier(int i)
	{
		super(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + imgs[i%imgs.length] + ".png").getImage());
	}


	
}
