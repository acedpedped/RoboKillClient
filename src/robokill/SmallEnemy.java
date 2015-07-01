/*
 * in the name of God
 */
package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author ParhamMLK
 */
public class SmallEnemy extends Enemy
{

    private static final String imgs[] = {"1", "2", "3", "4", "5", "4", "3", "2", "1", "6", "7", "8", "9", "8", "7", "6"};
    public static final String sep = File.separator;
    private int index = 0;

	public SmallEnemy(int i, int j)
	{
        super(i, j);
        for(int k=0;k<16;k++)
            img.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image " + imgs[k] + ".png").getImage());
    }
	@Override
    public void move(Graphics g, int x, int y)
    {
        update(x, y);
        //dir = Math.atan2((double)x, (double)y);
        g.drawImage(img.get(index), xPos, yPos, img.get(index).getWidth(null), img.get(index).getHeight(null), null);
        index = (index + 1) % 16;
    }

    /**
     *
     * @param x robot x position
     * @param y robot y position
     */
    public void update(int x, int y)
    {
        int d = 1;
        int deltaX = x - xPos;
        int deltaY = y - yPos;

        if(Math.abs(deltaX) > Math.abs(deltaY))
        {
            if(deltaX > 0)
                xPos++;
            else
                xPos--;
        }
        else
        {
            if(deltaY > 0)
                yPos++;
            else
                yPos--;
        }
    }
	
}
