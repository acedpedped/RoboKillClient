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
    private Image img;
    private Image head;
    private double degree;
    String indexes[] = new String[]{"413", "653", "413", "102"};
    public static final String sep = File.separator;
	
	public Robot()
    {
        for(int i=0;i<4;i++)
        {
            img = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image " + indexes[i] + ".png").getImage();
            moveUp.add(img);

        }
        head = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 286.png").getImage();
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
    /**
     * moves the robot, forward
     *
     * @param g for painting the move
     */
    public void moveForward(Graphics g, double dir)
    {
        double difference = degDif(dir, direction);
        direction = dir;
        if(difference == 0)
        {
            g.drawImage(moveUp.get(curImg), xPos, yPos, null);
            curImg = (curImg + 1) % 4;
        }
        else
        {
           Graphics2D g2d = (Graphics2D)g;
            g2d.rotate(difference);
        }
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
