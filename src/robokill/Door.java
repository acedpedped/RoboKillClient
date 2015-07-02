package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Door class. creates doors in rooms.
 *
 * @author ParhamMLK
 * @author pedram
 *
 * @version 1.0
 */
public class Door
{
    private int to;
    private int x, y;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public static final String sep = File.separator;
    private Image[] imgs;
    private Image open;
    private int ind = 0;
    private boolean isUp, isDown, isLeft, isRight;
    private boolean alwaysOpen = false;

    private double angle;

    public Door(boolean isUp, boolean isRight, boolean isDown, boolean isLeft, int to)
    {
        this.isDown = isDown;
        this.isLeft = isLeft;
        this.isUp = isUp;
        this.isRight = isRight;
        this.to = to;
        if (isUp)
        {
            x = 360;
            y = 0;
            angle = 0;
        }
        else if (isDown)
        {
            x = 360;
            y = 525;
            angle = 180;
        }
        else if (isRight)
        {
            angle = 90;
            x = 800 - 55;
            y = 274;
        }
        else
        {
            angle = 270;
            x = -1;
            y = 274;
        }

        imgs = new Image[30];
        for (int i = 1; i <= 30; i++)
        {
            imgs[i - 1] = ImageTool.rotate(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "door" + sep + String.valueOf(i) + ".png").getImage(), angle);
        }

        open = ImageTool.rotate(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "door" + sep + "open.png").getImage(), angle);
    }

    public Image getOpen()
    {
        return open;
    }

    public Image getImage(boolean openit)
    {
        if (openit)
        {
            ind = Math.max(ind - 1, 0);
        }
        else
        {
            ind = Math.min(ind + 1, 29);
        }

        return imgs[ind];
    }

    public int toWhere()
    {
        return to;
    }
    public Rectangle getRect()
    {
        return new Rectangle(x, y, open.getWidth(null), open.getHeight(null));
    }

    public  boolean isAlwaysOpen()
    {
        return alwaysOpen;
    }

    public void setOpen(boolean flag)
    {
        alwaysOpen = flag;
    }
    public int dir()
    {
        if(isUp)
            return 1;
        else if(isDown)
            return 3;
        else if(isLeft)
            return 2;
        else
            return 4;
    }
}
