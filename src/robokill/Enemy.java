package robokill;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class Enemy. Base class for different enemies.
 *
 * @author ParhamMLK
 * @author pedram
 *
 * @version 1.0
 */
public abstract class Enemy extends JPanel
{

	protected int xPos;
	protected int yPos;
	protected double dir = 1;
	protected double degDif;
	protected int health;
	protected Rectangle rect;
	protected ArrayList<Image> img = new ArrayList<Image>();
	protected Image head;
	public Image body;
	Image tmphead;
	int index = 0;
	int tmp1, tmp2;
	double degree;

	public static final String sep = File.separator;

	public Enemy(int i, int j)
	{
		//this.dir = -Math.PI / 2;
		health = 15;
		Cell cell = new Cell(null, i, j);
		xPos = cell.getxPos();
		yPos = cell.getyPos();

	}

	/**
	 * makes rectangle around enemy
	 */
	public Rectangle getRect()
	{
//		rect = new Rectangle(xPos, yPos, img.get(0).getWidth(null), img.get(0).getHeight(null));
		rect = new Rectangle(xPos, yPos, 1, 1);
		return rect;
	}

	public void die()
	{

	}

	public void move(Room room)
	{
		update(Map.robot.getxPos(), Map.robot.getyPos(), room);
	}

	/**
	 *
	 * @return the angle that enemy shoud turn
	 */
	public double degDif()
	{
		return degDif;
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

	public void setDir(double dir)
	{
		this.dir = dir;
	}

	/**
	 *
	 * @return the value of dir
	 */
	public double getDir()
	{
		return dir;
	}

	public Image getImage()
	{
		return new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 413.png").getImage();
	}

	private int ind[][] = new int[3][3];

	void work(int dx, int dy)
	{
		xPos += dx;
		yPos += dy;
		
		dx++;
		dy++;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i != dx || j != dy)
				{
					ind[i][j] = 0;
				}
			}
		}

		body = getMoves(dx, dy, ind[dx][dy]);
//		body = moves[dx][dy][ind[dx][dy]];
		ind[dx][dy] = (ind[dx][dy] + 1) % getMovesSize(dx, dy);
	}

	private void update(int x, int y, Room room)
	{
		int d = 1;
		int dx = x - xPos;
		int dy = y - yPos;
		tmp1 = xPos;
		tmp2 = yPos;

		if (dx == 0 && dy > 0)
		{
			work(0, +1);
		}
		else if (dx == 0 && dy < 0)
		{
			work(0, -1);
		}
		else if (dy == 0 && dx > 0)
		{
			work(+1, 0);
		}
		else if (dy == 0 && dx < 0)
		{
			work(-1, 0);
		}
		else if (dy < 0 && dx < 0)
		{
			work(-1, -1);
		}
		else if (dy < 0 && dx > 0)
		{
			work(+1, -1);
		}
		else if (dy > 0 && dx < 0)
		{
			work(-1, +1);
		}
		else if (dy > 0 && dx > 0)
		{
			work(+1, +1);
		}
//
//		if (Math.abs(dx) > Math.abs(dy))
//		{
//			if (dx > 0)
//			{
//				xPos++;
//				degDif = 1 - dir;
//				dir = 1;
//			}
//			else
//			{
//				xPos--;
//				degDif = 3 - dir;
//				dir = 3;
//			}
//		}
//		else
//		{
//			if (dy > 0)
//			{
//				yPos++;
//				degDif = 4 - dir;
//				dir = 4;
//			}
//			else
//			{
//				yPos--;
//				degDif = 2 - dir;
//				dir = 2;
//			}
//		}
		if (!canMove(room))
		{
			xPos = tmp1;
			yPos = tmp2;
		}

	}

	private boolean canMove(Room room)
	{
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes = room.getBox();
		ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
		barriers = room.getBarriers();

		for (int i = 0; i < boxes.size(); i++)
		{
			if (getRect().intersects(boxes.get(i).getRect()))
			{
				return false;
			}
		}
		for (int i = 0; i < barriers.size(); i++)
		{
			if (getRect().intersects(barriers.get(i).getRect()))
			{
				return false;
			}
		}
		return true;

	}

	Image getBody()
	{
		return body;
	}

	abstract Image getMoves(int dx, int dy, int ind);

	abstract int getMovesSize(int dx, int dy);

	Image getHead()
	{
		Point p = new Point(Map.robot.getxPos(), Map.robot.getyPos());
		Point dif = p;
		dif.x -= xPos;
		dif.y -= yPos;

//		System.err.println(dif.x + " " + dif.y);
		if (dif.x == 0 && dif.y == 0)
		{
			return tmphead;
		}
		else if (dif.x == 0 && dif.y > 0)
		{
			tmphead = head;
		}
		else if (dif.x == 0 && dif.y < 0)
		{
			tmphead = ImageTool.rotate(head, 180);
		}
		else if (dif.x > 0 && dif.y == 0)
		{
			tmphead = ImageTool.rotate(head, 270);
		}
		else if (dif.x < 0 && dif.y == 0)
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
}
