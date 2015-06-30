/*
 * in the name of God
 */
package robokill;

import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ParhamMLK
 */
public class SmallEnemy extends Enemy
{

    private static final String imgs[] = {"1", "2", "3", "4", "5", "4", "3", "2", "1", "6", "7", "8", "9", "8", "7", "6"};
    public static final String sep = File.separator;
    private int index = 0;
    private int tmp1, tmp2;

	public SmallEnemy(int i, int j)
	{
        super(i, j);
        tmp1 = xPos;
        tmp2 = yPos;
        for(int k=0;k<16;k++)
            img.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image " + imgs[k] + ".png").getImage());

        head = (new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image 971.png").getImage());
        //rect = new Rectangle(img.get(0).getHeight())

    }
	@Override
    public void move(Graphics g, int x, int y, Room room)
    {
        makeRect();
        update(x, y, room);
        //dir = Math.atan2((double)x, (double)y);
        //Image tmp = ImageTool.rotate(img.get(index), degDif * 90);
        //g.drawImage(tmp, xPos, yPos, tmp.getWidth(null), tmp.getHeight(null), null);
        g.drawImage(img.get(index), xPos, yPos, img.get(index).getWidth(null), img.get(index).getHeight(null), null);
        g.drawImage(head, xPos, yPos, head.getWidth(null), head.getHeight(null), null);
        index = (index + 1) % 16;
    }

    /**
     *
     * @param x robot x position
     * @param y robot y position
     */
    public void update(int x, int y, Room room)
    {
        int d = 1;
        int deltaX = x - xPos;
        int deltaY = y - yPos;
        tmp1 = xPos;
        tmp2 = yPos;

        if(Math.abs(deltaX) > Math.abs(deltaY))
        {
            if(deltaX > 0)
            {
                xPos++;
                degDif = 1 - dir;
                dir = 1;
            }
            else
            {
                xPos--;
                degDif = 3 - dir;
                dir = 3;
            }
        }
        else
        {
            if(deltaY > 0)
            {
                yPos++;
                degDif = 4 - dir;
                dir = 4;
            }
            else
            {
                yPos--;
                degDif = 2 - dir;
                dir = 2;
            }
        }
        if(!canMove(room))
        {
            xPos = tmp1;
            yPos = tmp2;
        }
    }
    public boolean canMove(Room room)
    {
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes = room.getBox();
        ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
        barriers = room.getBarriers();

        for(int i=0;i<boxes.size();i++)
            if(getRect().intersects(boxes.get(i).getRect()))
                return false;
        for(int i=0;i<barriers.size();i++)
            if(getRect().intersects(barriers.get(i).getRect()))
                return false;
        return true;
    }

	
}
