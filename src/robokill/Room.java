package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	private Cell[][] cells = new Cell[11][15];
	private boolean isCleaned;
	//private Robot robot;
	private String dir;
    private int l;
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private boolean isFin = false;
	private Robot robot;

	public Robot getRobot()
	{
		return robot;
	}

	public void setRobot(Robot robot)
	{
		this.robot = robot;
	}
	private final ArrayList<Bullet> bullets;
	private ArrayList<Thread> threads;

	private boolean up = false, down = false, right = false, left = false, fire = false;

	public static final String sep = File.separator;

	public Room(ArrayList<Box> boxes, ArrayList<SmallBarrier> barriers, ArrayList<Enemy> enemies, ArrayList<Door> doors)
	{
		super();
		this.threads = new ArrayList<Thread>();
		this.enemies = new ArrayList<Enemy>();
		this.bullets = new ArrayList<Bullet>();

        for(int i=0;i<doors.size();i++)
            this.doors.add(doors.get(i));
        for(int i=0;i<boxes.size();i++)
            this.boxes.add(boxes.get(i));
        for(int i=0;i<barriers.size();i++)
            this.barriers.add(barriers.get(i));
        for(int i=0;i<enemies.size();i++)
            this.enemies.add(enemies.get(i));
		/*this.boxes = boxes;
		this.barriers = barriers;
		this.enemies = enemies;
		this.doors = doors;   */

        System.out.print(doors.size());

        setSize(800, 600);
        //setLayout(null);
		setDoubleBuffered(true);

		init();

        //System.out.print(doors.size());
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


		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{

				for (Weapon w : robot.getGuns())
				{
					w.begin();
				}
//				setFire(true);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				for (Weapon w : robot.getGuns())
				{
					w.terminate();
				}
//				setFire(false);
			}

		});

        System.out.println(doors.size());
		isCleaned = false;
		setVisible(true);
		//init();
        //repaint();
	}

	void setFire(boolean b)
	{
		fire = b;
	}

	public void init()
	{
        //System.out.print(doors.size());
		robot = new Robot(400, 300);
		robot.addGun(new LightBlaster(this));

		for (Weapon w : robot.getGuns())
		{
			threads.add(new Thread(w));
		}
		/*for (Thread t : threads)
		{
			t.start();
		} */

        //System.out.print(doors.size());
		for (int i = 0; i < boxes.size(); i++)
		{
			cells[boxes.get(i).iCell()][boxes.get(i).jCell()] = new Cell(boxes.get(i), boxes.get(i).iCell(), boxes.get(i).jCell());
		}
		for (int i = 0; i < barriers.size(); i++)
		{
			int x = barriers.get(i).iCell(), y = barriers.get(i).jCell();
			cells[x][y] = new Cell(barriers.get(i), x, y);
		}
        for(int i = 0; i < enemies.size(); i++)
        {

        }
        //System.out.print(doors.size());

	}

	public void setCell(int i, int j, Cell c)
	{
		if (isValid(i, j))
		{
			cells[i][j] = c;
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
        System.out.print(doors.size());
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

				g.drawImage(c.getImage(), c.getxPos(), c.getyPos(), c.getImage().getWidth(null), c.getImage().getHeight(null), null);

			}
		}
		for (int i = 0; i < doors.size(); i++)
		{
            //System.out.print(doors.get(i).iCell());
            if(l == 100)
                isFin = true;
			doors.get(i).drawDoor(g, isFin);
		}
		robot.move(up, down, left, right);

//		System.err.println(" u:" + up + " d:" + down + " l:" + left + " r:" + right);
		g.drawImage(robot.getBody(), robot.getxPos() - robot.getBody().getWidth(null) / 2, robot.getyPos() - robot.getBody().getHeight(null) / 2, robot.getBody().getWidth(null), robot.getBody().getHeight(null), null);

//		System.err.println(robot.getxPos() + " " + robot.getyPos());
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, this);

		Image head = robot.getHead(p);
		g.drawImage(head, robot.getxPos() - head.getWidth(null) / 2, robot.getyPos() - head.getHeight(null) / 2, head.getWidth(null), head.getHeight(null), null);

//		System.err.println(bullets.size());
		synchronized (bullets)
		{
			for (Bullet b : bullets)
			{
				//bekesh
				Image bul = ImageTool.rotate(b.getImg(), b.getAngle());
				g.drawImage(bul, b.getX() - bul.getWidth(null) / 2, b.getY() - bul.getHeight(null) / 2, bul.getWidth(null), bul.getHeight(null), null);
				b.move();

			}
		}

        l++;

		for (Enemy e : enemies)
		{
            System.out.print(e.getxPos() + " ");
            System.out.println(e.getyPos() + " ");
			e.move(g, robot.getxPos(), robot.getyPos());
			//g.drawImage(e.getImage(), e.getxPos(), e.getyPos(), e.getImage().getWidth(null), e.getImage().getHeight(null), null);
            //g.drawImage(ImageTool.rotate(e.getImage(), e.degDif()), e.getxPos(), e.getyPos(), e.getImage().getWidth(null), e.getImage().getHeight(null), null);
		}

		try
		{
			Thread.sleep(15);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		repaint();
	}

	public boolean isFin()
	{
		return isFin;
	}

	public void setIsFin(boolean isFin)
	{
		this.isFin = isFin;
	}

	private boolean isValid(int i, int j)
	{
		return (i >= 0 && i <= 10) && (j >= 0 && j <= 14);
	}

    public ArrayList<Box> getBox()
    {
        return boxes;
    }

	/*void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	} */

	void addBullet(Bullet bullet)
	{
		synchronized (bullets)
		{
			bullets.add(bullet);
		}
    }

	private class MoveAction extends AbstractAction
	{

		String dir;
		boolean d;

		public MoveAction(String dir, boolean d)
		{
			this.dir = dir;
			this.d = d;
			int a;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (dir == "up")
			{
				up = d;
			}
			else if (dir == "down")
			{
				down = d;
			}
			else if (dir == "left")
			{
				left = d;
			}
			else if (dir == "right")
			{
				right = d;
			}

		}
	}

}
