/*
 * in the name of God
 */
package robokill;

import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author ParhamMLK
 */
public class RoomTest extends JFrame
{
	public static final String sep = File.separator;

	public RoomTest()
	{
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocation(150, 70);
		setResizable(false);
		setVisible(true);
		
		Room r = new Room();
		Cell c = new Cell(new Barrier());
		r.setCell(4, 5, c);
		
		add(r);

	}

}
