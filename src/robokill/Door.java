package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 6/28/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Door extends Object{
    private int room1, room2;
    private int x, y;
    private ArrayList<Image> imgs = new ArrayList<Image>();
    private String[] indexes  = new String[]{"976", "353", "803", "345", "635", "809"};
    public static final String sep = File.separator;

    public Door(boolean isUp, boolean isRight, boolean isDown, boolean isLeft, int room1, int room2)
    {
        super(null, 0, 0);
        this.room1 = room1;
        this.room2 = room2;
        if(isUp)
        {
            x = 360;
            y = 21;
            for(int i = 0;i < 6; i++)
            {
                imgs.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + ".png").getImage());
            }
        }
        else if(isDown)
        {
            x = 360;
            y = 550;
            for(int i = 0;i < 6; i++)
            {
                imgs.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "2.png").getImage());
            }
        }
        else if(isRight)
        {
            x = 737;
            y = 274;
            for(int i = 0;i < 6; i++)
            {
                imgs.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "1.png").getImage());
            }

        }
        else
        {
            x = 10;
            y = 274;
            for(int i = 0;i < 6; i++)
            {
                imgs.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "3.png").getImage());
            }

        }
    }

    public Door(Image img, int i, int j) {
        super(img, i, j);
    }

    public void drawDoor(Graphics g, boolean isOpen)
    {
        if(!isOpen)
            g.drawImage(imgs.get(0), x, y, null);
        else
        {
            for(int i=0;i<6;i++)
            {
                g.drawImage(imgs.get(i), x, y, null);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }
}
