
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
public class Barrier extends Object
{

	public static final String sep = File.separator;

	public Barrier()
	{
		super(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 188.png").getImage());
	}


	
}
