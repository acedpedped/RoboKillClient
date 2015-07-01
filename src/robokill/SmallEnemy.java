/*
 * in the name of God
 */
package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import static robokill.Robot.sep;

/**
 *
 * @author ParhamMLK
 */
public class SmallEnemy extends Enemy
{

	private static Image moves[][][] = new Image[3][3][34];

	private static final String imgs[] =
	{
		"1", "2", "3", "4", "5", "4", "3", "2", "1", "6", "7", "8", "9", "8", "7", "6"
	};
	public static final String sep = File.separator;

	Image getMoves(int dx, int dy, int ind)
	{
		return moves[dx][dy][ind];
	}
	
	int getMovesSize(int dx, int dy)
	{
		return moves[dx][dy].length;
	}

	public SmallEnemy(int k, int j)
	{
		super(k, j);
		tmp1 = xPos;
		tmp2 = yPos;

		for (int i = 1; i <= 34; i++)
		{
			moves[1][0][i - 1] = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + String.valueOf(i) + ".png").getImage();
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[2][0][i - 1] = ImageTool.rotate(moves[1][0][i - 1], 45);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[2][1][i - 1] = ImageTool.rotate(moves[1][0][i - 1], 90);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[2][2][i - 1] = ImageTool.rotate(moves[2][1][i - 1], 45);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[1][2][i - 1] = ImageTool.rotate(moves[2][2][i - 1], 45);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[0][2][i - 1] = ImageTool.rotate(moves[1][2][i - 1], 45);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[0][1][i - 1] = ImageTool.rotate(moves[0][2][i - 1], 45);
		}

		for (int i = 1; i <= 34; i++)
		{
			moves[0][0][i - 1] = ImageTool.rotate(moves[0][1][i - 1], 45);
		}

		body = moves[1][0][0];

		head = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 971.png").getImage();
		tmphead = head;

		for (int index = 0; index < 16; index++)
		{
			img.add(new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "enemy1" + sep + "image " + imgs[index] + ".png").getImage());
		}

	//rect = new Rectangle(img.get(0).getHeight())

	}

}
