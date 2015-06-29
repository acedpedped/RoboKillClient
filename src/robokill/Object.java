/*
 * in the name of God
 */
package robokill;

import java.awt.Image;

/**
 *
 * @author ParhamMLK
 */
public abstract class Object 
{
	protected Image img;
    protected int i, j;

	public Object(Image img, int i, int j)
	{
		this.img = img;
        this.i = i;
        this.j = j;
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
     * @return the j index of the object's cell
     */
    public int jCell()
    {
        return j;
    }

}
