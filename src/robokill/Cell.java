/*
 * in the name of God
 */
package robokill;

import java.awt.Image;

/**
 *
 * @author ParhamMLK
 */
public class Cell
{
	private Object thing;
	private int x, y;
    private int xPos, yPos;
	private int state;

	
	public Cell(Object thing, int x, int y)
	{
		this.thing = thing;
		state = 0;
        xPos = x == 0 ? 0 : 62 + (x-1) * 52;
        yPos = y == 0 ? 0 : 66 + (y-1) * 52;
	}	

	public Image getImage()
	{
		return thing.getImage();
	}

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getxPos()
    {
        return  xPos;
    }

    public int getyPos()
    {
        return yPos;
    }
	
	
}
