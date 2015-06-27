package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

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
	private Robot robot;
	private ArrayList<Enemy> enemies = new ArrayList<>();

	private boolean up = false, down = false, right = false, left = false;

	public static final String sep = File.separator;

	public Room()
	{
		super(true);

		cells = new Cell[11][15];
		for (Cell[] row : cells)
		{
			for (Cell cell : row)
			{
				cell = new Cell(null);
			}
		}

		robot = new Robot(400, 300);

		//WASD + Arrow Keys
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "up");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
		getActionMap().put("up", new MoveAction("up", true));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "nup");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"), "nup");
		getActionMap().put("nup", new MoveAction("up", false));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "down");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
		getActionMap().put("down", new MoveAction("down", true));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "ndown");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released DOWN"), "ndown");
		getActionMap().put("ndown", new MoveAction("down", false));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "left");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
		getActionMap().put("left", new MoveAction("left", true));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "nleft");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "nleft");
		getActionMap().put("nleft", new MoveAction("left", false));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "right");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
		getActionMap().put("right", new MoveAction("right", true));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "nright");
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "nright");
		getActionMap().put("nright", new MoveAction("right", false));

		isCleaned = false;
		setVisible(true);
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
			}
		}

		robot.move(up, down, left, right);

//		System.err.println(" u:" + up + " d:" + down + " l:" + left + " r:" + right);
		
		g.drawImage(robot.getBody(), robot.getxPos()-robot.getBody().getWidth(null)/2, robot.getyPos()-robot.getBody().getHeight(null)/2, robot.getBody().getWidth(null), robot.getBody().getHeight(null), null);
		
		System.err.println(robot.getxPos() + " " + robot.getyPos());
		
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, this);
		
		Image head = robot.getHead(p);
		g.drawImage(head, robot.getxPos()-head.getWidth(null)/2, robot.getyPos()-head.getHeight(null)/2, head.getWidth(null), head.getHeight(null), null);

		for (Enemy e : enemies)
		{
			e.move();
			g.drawImage(e.getImage(), e.getxPos(), e.getyPos(), e.getImage().getWidth(null), e.getImage().getHeight(null), null);
		}

		try
		{
			Thread.sleep(8);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
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

	private class MoveAction extends AbstractAction
	{

		String dir;
		boolean d;

		public MoveAction(String dir, boolean d)
		{
			this.dir = dir;
			this.d = d;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			switch (dir)
			{
				case "up":
					up = d;
					break;
				case "down":
					down = d;
					break;
				case "left":
					left = d;
					break;
				case "right":
					right = d;
					break;
			}

		}
	}

}
