package robokill;

import javax.swing.*;
import java.awt.*;
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
public class Robot extends JPanel
{

	private int xPos;
	private int yPos;

	private int health = 100;
	private int curImg;
	private double headDeg = 90;
	private double direction = 90;
	private ArrayList<Weapon> guns = new ArrayList<Weapon>();

	public ArrayList<Weapon> getGuns()
	{
		return guns;
	}

	public void setGuns(ArrayList<Weapon> guns)
	{
		this.guns = guns;
	}
	
	public void addGun(Weapon w)
	{
		guns.add(w);
		Thread t = new Thread(w);
		Map.curRoom.addThread(t);
		t.start();
	}
	
	private Image body;
	private static Image head;
	private Image tmphead;
	private double degree;
	
	private static Image moves[][][] = new Image[3][3][40];
	private static int ind[][] = new int[3][3];
	
	public static final String sep = File.separator;

	public Robot(int x, int y)
	{
		super(true);
		xPos = x;
		yPos = y;
		
		
		for(int i=1; i<=40; i++)
			moves[1][0][i-1] = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "robot" + sep + String.valueOf(i) + ".png").getImage();

		for(int i=1; i<=40; i++)
			moves[2][0][i-1] = ImageTool.rotate(moves[1][0][i-1], 45);

		for(int i=1; i<=40; i++)
			moves[2][1][i-1] = ImageTool.rotate(moves[1][0][i-1], 90);
		
		for(int i=1; i<=40; i++)
			moves[2][2][i-1] = ImageTool.rotate(moves[2][1][i-1], 45);
		
		for(int i=1; i<=40; i++)
			moves[1][2][i-1] = ImageTool.rotate(moves[2][2][i-1], 45);
		
		for(int i=1; i<=40; i++)
			moves[0][2][i-1] = ImageTool.rotate(moves[1][2][i-1], 45);
		
		for(int i=1; i<=40; i++)
			moves[0][1][i-1] = ImageTool.rotate(moves[0][2][i-1], 45);
		
		for(int i=1; i<=40; i++)
			moves[0][0][i-1] = ImageTool.rotate(moves[0][1][i-1], 45);
		
		
		body = moves[1][0][0];
		
		head = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 771.png").getImage();
		tmphead = head;
	}

	public Image getBody()
	{
		return body;
	}

	public Image getHead(Point p)
	{
		Point dif = p;
		dif.x -= xPos;
		dif.y -= yPos;
		
//		System.err.println(dif.x + " " + dif.y);
		if(dif.x == 0 && dif.y == 0)
		{
			return tmphead;
		}
		else if(dif.x == 0 && dif.y > 0)
		{
			tmphead = head;
		}
		else if(dif.x == 0 && dif.y < 0)
		{
			tmphead = ImageTool.rotate(head, 180);
		}
		else if(dif.x > 0 && dif.y == 0)
		{
			tmphead = ImageTool.rotate(head, 270);
		}
		else if(dif.x < 0 && dif.y == 0)
		{
			tmphead = ImageTool.rotate(head, 90);
		}
		else// if(dif.x > 0 && dif.y > 0)
		{
			
			double theta = 180.0 / Math.PI * Math.atan2(-dif.x, dif.y);
			tmphead = ImageTool.rotate(head, theta);
		}
		
		return tmphead;
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

	public int getHealth()
	{
		return health;
	}

	/**
	 * sets the health of robot
	 *
	 * @param health new value of health
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}

	/**
	 *
	 * @param up
	 * @param down
	 * @param left
	 * @param right
	 */
	public void move(boolean up, boolean down, boolean left, boolean right)
	{
		if(up && down)
			up = down = false;
		if(left && right)
			left = right = false;	
		
		int d = 2;
		if (up)
		{
			setyPos(yPos - d);
		}
		if (down)
		{
			setyPos(yPos + d);
		}
		if (left)
		{
			setxPos(xPos - d);
		}
		if (right)
		{
			setxPos(xPos + d);
		}
		
		if(left && up)
		{
			update(-1, -1);
		}
		else if(up && right)
		{
			update(+1, -1);
		}
		else if(right && down)
		{
			update(+1, +1);
		}
		else if(down && left)
		{
			update(-1, +1);
		}
		else if(up)
		{
			update(0, -1);
		}
		else if(down)
		{
			update(0, +1);
		}
		else if(left)
		{
			update(-1, 0);
		}
		else if(right)
		{
			update(+1, 0);
		}
		else
		{
			//nothing changes.
		}
		
	}
	
	void update(int dx, int dy)
	{
		dx++;
		dy++;
		
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(i != dx || j != dy)
					ind[i][j] = 0;
		
		body = moves[dx][dy][ind[dx][dy]];
		ind[dx][dy] = (ind[dx][dy]+1)%moves[dx][dy].length;
	}

}
