package robokill;

/**
 * Class Enemy. Base class for different enemies.
 * 
 * @author ParhamMLK
 * @author pedram
 * 
 * @version 1.0
 */
public class Enemy
{
	private int xPos;
	private int yPos;
	
	

	/**
	 * Get the value of xPos
	 *
	 * @return the value of xPos
	 */
	public int getxPos()
	{
		return xPos;
	}

	/**
	 * Set the value of xPos
	 *
	 * @param xPos new value of xPos
	 */
	public void setxPos(int xPos)
	{
		this.xPos = xPos;
	}


	/**
	 * Get the value of yPos
	 *
	 * @return the value of yPos
	 */
	public int getyPos()
	{
		return yPos;
	}

	/**
	 * Set the value of yPos
	 *
	 * @param yPos new value of yPos
	 */
	public void setyPos(int yPos)
	{
		this.yPos = yPos;
	}
}
