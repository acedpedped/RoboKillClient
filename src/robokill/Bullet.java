package robokill;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author ParhamMLK
 * @author pedram
 *
 * @version 1.0
 */
public class Bullet
{
    private int damage;
    private int x;
    private int y;
    private double angle;
    private Image img;
    private boolean who;

    public Bullet(int damage, int x, int y, double angle, Image img, boolean who)
    {
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.img = img;
        this.who = who;
    }

    public boolean getWho()
    {
        return who;
    }
    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

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

    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }

    public Image getImg()
    {
        return img;
    }

    public void setImg(Image img)
    {
        this.img = img;
    }

    void move(int index, Room room)
    {
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes = room.getBox();
        ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
        barriers = room.getBarriers();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies = room.getEnemies();
        ArrayList<Door>  doors = new ArrayList<Door>();
        doors = room.getDoor();
        ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        bullets = room.getBullets();
        Robot robot = room.getRobot();

        double sin = Math.sin(Math.toRadians(angle));
        double cos = Math.cos(Math.toRadians(angle));

        double newx = x - sin*10;
        double newy = y + cos*10;
        setX((int)newx);
        setY((int)newy);

        if(x < 0 || x > 800 || y < 0 || y > 600)
            bullets.remove(index);

        for(int i=0;i<barriers.size();i++)
        {
            if(x >= barriers.get(i).getCell().getxPos() && x <= barriers.get(i).getCell().getxPos() + barriers.get(i).getWidth())
                if(y >= barriers.get(i).getCell().getyPos() && y <= barriers.get(i).getCell().getyPos() + barriers.get(i).getHeight())
                    bullets.remove(index);
        }
        for(int i=0;i<boxes.size();i++)
        {
            if(x >= boxes.get(i).getCell().getxPos() && x <= boxes.get(i).getCell().getxPos() + boxes.get(i).getWidth())
                if(y >= boxes.get(i).getCell().getyPos() && y <= boxes.get(i).getCell().getyPos() + boxes.get(i).getHeight())
                {
                    bullets.remove(index);
                    boxes.remove(i);
                    //return;
                    //room.repaint();
                }
        }
        for(int i=0;i<enemies.size();i++)
        {
            if(x >= enemies.get(i).getxPos() && x <= enemies.get(i).getxPos() + enemies.get(i).getWidth())
                if(y >= enemies.get(i).getyPos() && y <= enemies.get(i).getyPos() + enemies.get(i).getHeight())
                {
                    int k = 10;
                    //k = enemies.get(i).getHealth();
                    if(!who)
                        k -= damage;
                    if(k <= 0)
                        enemies.remove(i);
                    else;
                    //enemies.get(i).setHealth(k);
                    bullets.remove(index);
                }
        }
        if(x >= robot.getxPos() - robot.getWidth() / 2 && x <= robot.getxPos() + robot.getWidth() / 2)
            if(y >= robot.getyPos() - robot.getHeight() / 2 && y <= robot.getyPos() + robot.getHeight() / 2)
            {
                if(robot.hasSheild())
                    robot.setSheild(false);
                else if(!who)
                {
                    int t = robot.getHealth();
                    t -= damage;
                    if(t <= 0)
                        Robokill.frame.dispose();
                    else
                        robot.setHealth(t);
                }

            }
    }




}
