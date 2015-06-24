
package robokill;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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

	public static final String sep = File.separator;

	public Room()
	{
		super(true);
		
		cells = new Cell[11][15];
		for(Cell[] row : cells)
			for(Cell cell : row)
				cell = new Cell(null);
		
		isCleaned = false;		
		setVisible(true);
	}
	
	public void setCell(int i, int j, Cell c)
	{
		if(isValid(i, j))
			cells[i][j] = c;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image background = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 187.png").getImage();		
		g.drawImage(background, 0, 0, 800, 600, null);
		
		for(int i=0; i<11; i++)
			for(int j=0; j<15; j++)
			{
				Cell c = cells[i][j];
				
				if(c == null)
					continue;
				
				g.drawImage(c.getImage(), 10+i*52, 13+j*52, c.getImage().getHeight(null), c.getImage().getWidth(null), null);
				
			}
		
	}

	private boolean isValid(int i, int j)
	{
		return (i >= 0 && i <= 10) && (j >= 0 && j <=14);
	}
	
		
	
	
}
