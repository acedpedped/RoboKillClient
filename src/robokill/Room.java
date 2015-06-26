package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class for each room of the map.
 *
 * @author ParhamMLK
 * @author pedram
 *
 * @version 1.0
 */
public class Room extends JPanel
{

	private Cell[][] cells;
	private boolean isCleaned;
	private int robX, robY;
	private int i;
	private Robot rob;
	private ArrayList<Enemy> enemies = new  ArrayList<>();

	public static final String sep = File.separator;

	public Room()
	{
		super(true);

		setDoubleBuffered(true);

		cells = new Cell[11][15];
		for (Cell[] row : cells)
		{
			for (Cell cell : row)
			{
				cell = new Cell(null);
			}
		}

		rob = new Robot(500, 500);
		setRob();
		isCleaned = false;
		setVisible(true);
		
//		while(true)
//		{
//			for(Enemy e : enemies)
//				e.move();
//			
//			repaint();
//		}
		
	}

	public void setRob()
	{
		robX = rob.getxPos();
		robY = rob.getyPos();
	}

	public void setCell(int i, int j, Cell c)
	{
		if (isValid(i, j))
		{
			cells[i][j] = c;
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image background = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 187.png").getImage();
		g.drawImage(background, 0, 0, 800, 600, null);
		for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				Cell c = cells[i][j];

				if (c == null)
				{
					continue;
				}

				g.drawImage(c.getImage(), 10 + j * 52, 13 + i * 52, c.getImage().getWidth(null), c.getImage().getHeight(null), null);
				//g.drawImage(rob.getBody(), robX, robY, null);
				//g.drawImage(rob.getHead(), robX, robY, null);

			}
		}

		for(Enemy e : enemies)
		{
			e.move();
			g.drawImage(e.getImage(), e.getyPos(), e.getxPos(), e.getImage().getWidth(null), e.getImage().getHeight(null), null);
		}
		
		try
		{
			Thread.sleep(50);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		repaint();

	}

	private boolean isValid(int i, int j)
	{
		return (i >= 0 && i <= 10) && (j >= 0 && j <= 14);
	}


	void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}

}
