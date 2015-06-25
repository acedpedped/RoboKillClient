package robokill;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Class Robot. the main character in the game.
 * 
 * @author pedram
 * @author ParhamMLK
 * 
 * @version 1.0
 */
public class Robot
{
	
	private int xPos;
	private int yPos;
    private int health = 100;
    private int curImg;
    private double headDeg = 90;
    private double direction = 90;
    private ArrayList<Weapon> guns = new ArrayList<Weapon>();
    private ArrayList<Image> moveUp = new ArrayList<Image>();
    private ArrayList<Image> moveDown = new ArrayList<Image>();
    private ArrayList<Image> moveRight = new ArrayList<Image>();
    private ArrayList<Image> moveLeft = new ArrayList<Image>();
    private Image img;
    private Image head, body;
    private double degree;
    String indexes[] = new String[]{"413", "653", "413", "102"};
    public static final String sep = File.separator;
	
	public Robot(int x, int y)
    {
        xPos = x;
        yPos = y;
        for(int i=0;i<4;i++)
        {
            img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + ".png").getImage();
            moveUp.add(img);
            img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "1.png").getImage();
            moveRight.add(img);
            img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "2.png").getImage();
            moveDown.add(img);
            img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + "3.png").getImage();
            moveLeft.add(img);

        }
        head = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 286.png").getImage();
        body = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 413.png").getImage();


    }

    public Image getHead()
    {
        return head;
    }

    public Image getBody()
    {
        return body;
    }
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

    /**
     * gets the direction of robot
     *
     * @return the value of directoin
     */
    public double getDir()
    {
        return direction;
    }

    /**
     * sets the direction
     *
     * @param direction new value of direction
     */
    public void setDir(double direction)
    {
        this.direction = direction;
    }

    public int getHealth()
    {
        return health;
    }
    /**
     * sets the health of robot
     * @param health new value of health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * returns the degree of robot's head
     * @return degree
     */
    public double getDeg()
    {
        return degree;
    }

    /**
     * sets the degree of the Robot's head
     * @param degree
     */
    public void setDeg(double degree)
    {
        this.degree = degree;
    }
    public void update(double dir)
    {
        if(dir == 0)
        {
            xPos += 7;
        }
        else if(dir == 90)
        {
            yPos -= 7;
        }
        else if(dir == 180)
        {
            xPos -= 7;
        }
        else
        {
            yPos += 7;
        }
    }

    /**
     * moves the robot, forward
     *
     * @param g for painting the move
     */
    public void moveForward(Graphics g, double dir)
    {
        double difference = degDif(dir, direction);
        direction = dir;
        update(dir);
        if(dir == 0)
            g.drawImage(moveRight.get(curImg), xPos, yPos, null);
        else if(dir == 90)
            g.drawImage(moveUp.get(curImg), xPos, yPos, null);
        else if(dir == 180)
            g.drawImage(moveDown.get(curImg), xPos, yPos, null);
        else if(dir == 270)
            g.drawImage(moveLeft.get(curImg), xPos, yPos, null);
        curImg = (curImg + 1) % 4;
        g.drawImage(head, xPos, yPos, null);


    }

    /**
     * returns the amount of degrees that robot should turn
     * @param dir1
     * @param dir2
     * @return
     */
    public double degDif(double dir1, double dir2)
    {
        return Math.toRadians(dir2 - dir1);
    }
    /**
     * draws the head of robot
     *
     * @param g for drawing head
     * @param curDeg for current degree of robot's head
     */
    public void drawHead(Graphics g, double curDeg)
    {
        Graphics2D g2d = (Graphics2D)g;
        double difference = curDeg - headDeg;
        headDeg = curDeg;
        g2d.rotate(Math.toRadians(difference));
    }

}
