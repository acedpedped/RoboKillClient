/*
 * in the name of God
 */
package robokill;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author ParhamMLK
 */
public class BigBarrier extends Object
{
	public static final String sep = File.separator;
	private static final String imgs[] = {"105", "268", "311", "312", "550", "579", "585", "504"};
    private int i, j;

	public BigBarrier(int index, int i, int j)
	{
		super(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + imgs[index%imgs.length] + ".png").getImage(), i, j);
	}


	
	
	
}
