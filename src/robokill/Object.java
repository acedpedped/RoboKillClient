/*
 * in the name of God
 */
package robokill;


import java.awt.*;

/**
 *
 * @author ParhamMLK
 */
public abstract class Object 
{
	protected Image img;
    protected int i, j;
    protected Cell cell;
    protected Rectangle rect;

	public Object(Image img, int i, int j)
	{
		this.img = img;
        this.i = i;
        this.j = j;
        Cell cell = new Cell(null, i, j);
        rect = new Rectangle(cell.getxPos(), cell.getyPos(), img.getWidth(null), img.getHeight(null));

	}

    public int getWidth()
    {
        return img.getWidth(null);
    }
    public int getHeight()
    {
        return img.getHeight(null);
    }
     public Cell getCell()
     {
         return cell;
     }
    /**
     *
     * @return the image of Object
     */
	public Image getImage()
	{
		return img;
	}

    /**
     *
     * @return the i index of cell of the object
     */
    public int iCell()
    {
        return i;
    }

    /**
     *
     * @return the rectangle around object
     */
    public Rectangle getRect()
    {
        return rect;
    }

    /**
     *
     * @return the j index of the object's cell
     */
    public int jCell()
    {
        return j;
    }

}
