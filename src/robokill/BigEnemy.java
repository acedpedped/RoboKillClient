/*
 * in the name of God
 */
package robokill;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author ParhamMLK
 */
public class BigEnemy extends Enemy
{

    private static final String imgs[] = {"1", "2", "3", "4", "5", "4", "3", "2", "1", "6", "7", "8", "9", "8", "7", "6"};
    public static final String sep = File.separator;
    private int index = 0;

    public BigEnemy(int i, int j)
    {
        super(i, j);
        for(int k=0;k<16;k++)
            img.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image " + imgs[k] + ".png").getImage());

        img.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image " + sep + "971.png").getImage());

    }
	
}
