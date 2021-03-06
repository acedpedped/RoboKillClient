/**
 * Created with IntelliJ IDEA. User: pedram Date: 6/23/15 Time: 10:15 PM To
 * change this template use File | Settings | File Templates.
 */
package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Map
{

	public static String sep = File.separator;

	ArrayList<Box> boxes = new ArrayList<Box>();
	ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Door> doors = new ArrayList<Door>();

	public static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static Robot robot;
	public static Room curRoom;
	
	protected Image background = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 187.png").getImage();
	

	public Map()
	{
		
		robot = new Robot(400, 300);
		
		build();
		
		curRoom = rooms.get(0);

//		System.err.println(curRoom.getEnemies().size());

		robot.addGun(new LightBlaster(curRoom));
		robot.addGun(new HeavyBlaster(curRoom));
		robot.addGun(new HeavyShotgun(curRoom));
		
		Robokill.frame.add(curRoom);
		Robokill.frame.repaint();
	}

	/**
	 * shows the situation of the rooms
	 */
	public void showMap()
	{

	}

	/**
	 * for building the rooms
	 *
	 * @param
	 */
	private void build()
	{

//		doors.add(new Door(true, false, false, false, 0, 1));
		enemies.add(new SmallEnemy(1, 1));
		enemies.add(new SmallEnemy(8, 1));
		enemies.add(new BigEnemy(1, 2));
		enemies.add(new SmallEnemy(6, 6));
        boxes.add(new Box(0, 5, 8));
        boxes.add(new Box(1, 6, 7));
        boxes.add(new Box(3, 5, 7));
        barriers.add(new SmallBarrier(0, 6, 6));
        barriers.add(new SmallBarrier(0, 5, 6));
        barriers.add(new SmallBarrier(0, 6, 5));

        doors.add(new Door(true, false, false, false, 1));
		rooms.add(new Room(0,boxes, barriers, enemies, doors));
		//Robokill.frame.add(rooms.get(0));
		doors.clear();

        /////////////////0000000000///////////////////
		boxes.add(new Box(0, 2, 3));
		boxes.add(new Box(1, 3, 3));
		boxes.add(new Box(2, 4, 4));
		boxes.add(new Box(3, 3, 4));
//		doors.add(new Door(true, false, false, false, 1, 2));
//		doors.add(new Door(false, false, true, false, 0, 1));
		rooms.add(new Room(1,boxes, barriers, enemies, doors));
		doors.clear();
		boxes.clear();

        //////////////111111111111////////////////
		boxes.add(new Box(0, 2, 3));
		boxes.add(new Box(1, 3, 3));
		boxes.add(new Box(2, 4, 4));
		boxes.add(new Box(3, 3, 4));
		barriers.add(new SmallBarrier(0, 7, 7));
		barriers.add(new SmallBarrier(4, 5, 5));
		barriers.add(new SmallBarrier(3, 10, 8));
//		doors.add(new Door(false, true, false, false, 2, 8));
//		doors.add(new Door(false, false, false, true, 3, 2));
		rooms.add(new Room(2,boxes, barriers, enemies, doors));
		doors.clear();
		boxes.clear();
		barriers.clear();

        ////////////2222222222222//////////////
		boxes.add(new Box(2, 2, 8));
		boxes.add(new Box(1, 2, 2));
		boxes.add(new Box(2, 2, 9));
		boxes.add(new Box(3, 3, 8));
		boxes.add(new Box(2, 2, 7));
		boxes.add(new Box(0, 3, 9));
		barriers.add(new SmallBarrier(1, 8, 2));
		barriers.add(new SmallBarrier(2, 9, 2));
		barriers.add(new SmallBarrier(2, 9, 3));
//		doors.add(new Door(false, true, false, false, 2, 3));
//		doors.add(new Door(false, false, false, true, 3, 4));
		rooms.add(new Room(3,boxes, barriers, enemies, doors));
		//System.out.print(rooms.get(3).getBox().size());
		boxes.clear();
		doors.clear();
		barriers.clear();

        ///////////////////333333333333//////////////////
		boxes.add(new Box(2, 2, 8));
		boxes.add(new Box(0, 3, 8));
		boxes.add(new Box(0, 4, 8));
		boxes.add(new Box(0, 5, 8));
		boxes.add(new Box(1, 6, 7));
		boxes.add(new Box(3, 5, 7));
		barriers.add(new SmallBarrier(0, 6, 6));
		barriers.add(new SmallBarrier(0, 5, 6));
		barriers.add(new SmallBarrier(0, 6, 5));
		barriers.add(new SmallBarrier(0, 5, 5));
		doors.add(new Door(true, false, false, false, 7));
		doors.add(new Door(false, false, true, false, 6));
		doors.add(new Door(false, false, false, true, 5));
		doors.add(new Door(false, true, false, false, 3));
		rooms.add(new Room(4,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        /////////////444444444////////////////
		barriers.add(new SmallBarrier(1, 6, 6));
		barriers.add(new SmallBarrier(1, 5, 6));
		barriers.add(new SmallBarrier(1, 6, 5));
		barriers.add(new SmallBarrier(1, 5, 5));
		barriers.add(new SmallBarrier(1, 6, 7));
		barriers.add(new SmallBarrier(2, 4, 9));
		boxes.add(new Box(2, 4, 8));
		boxes.add(new Box(1, 3, 4));
		boxes.add(new Box(2, 4, 1));
		boxes.add(new Box(3, 5, 7));
		boxes.add(new Box(3, 3, 3));
		boxes.add(new Box(3, 5, 7));
//		doors.add(new Door(false, true, false, false, 4, 5));
		rooms.add(new Room(5,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        //////////////555555555555/////////////////
		barriers.add(new SmallBarrier(0, 1, 6));
		barriers.add(new SmallBarrier(0, 5, 6));
		barriers.add(new SmallBarrier(2, 8, 4));
		barriers.add(new SmallBarrier(3, 3, 2));
		barriers.add(new SmallBarrier(3, 9, 5));
		barriers.add(new SmallBarrier(2, 7, 3));
		boxes.add(new Box(2, 4, 8));
		boxes.add(new Box(1, 3, 4));
		boxes.add(new Box(1, 9, 1));
		boxes.add(new Box(1, 5, 7));
		boxes.add(new Box(0, 3, 3));
		boxes.add(new Box(0, 7, 4));
		boxes.add(new Box(2, 4, 1));
		boxes.add(new Box(3, 5, 7));
		boxes.add(new Box(3, 3, 3));
		boxes.add(new Box(3, 3, 7));
//		doors.add(new Door(true, false, false, false, 4, 6));
		rooms.add(new Room(6,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        /////////////6666666666////////////
		barriers.add(new SmallBarrier(4, 4, 4));
		barriers.add(new SmallBarrier(4, 5, 3));
		barriers.add(new SmallBarrier(2, 8, 4));
		barriers.add(new SmallBarrier(3, 9, 9));
		barriers.add(new SmallBarrier(3, 9, 5));
		barriers.add(new SmallBarrier(2, 7, 1));
		boxes.add(new Box(2, 3, 6));
		boxes.add(new Box(1, 3, 4));
		boxes.add(new Box(3, 1, 11));
		boxes.add(new Box(3, 3, 11));
		boxes.add(new Box(0, 8, 12));
		boxes.add(new Box(0, 5, 10));
//		doors.add(new Door(false, false, true, false, 7, 4));
		rooms.add(new Room(7,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        //////////////777777777777777/////////////
		barriers.add(new SmallBarrier(0, 4, 10));
		barriers.add(new SmallBarrier(4, 5, 11));
		barriers.add(new SmallBarrier(1, 8, 12));
		barriers.add(new SmallBarrier(1, 9, 10));
		barriers.add(new SmallBarrier(3, 9, 11));
		barriers.add(new SmallBarrier(2, 7, 12));
		boxes.add(new Box(2, 3, 10));
		boxes.add(new Box(1, 3, 9));
		boxes.add(new Box(3, 1, 11));
		boxes.add(new Box(3, 3, 11));
		boxes.add(new Box(0, 8, 12));
		boxes.add(new Box(0, 5, 3));
		boxes.add(new Box(3, 1, 4));
		boxes.add(new Box(3, 3, 5));
		boxes.add(new Box(0, 8, 3));
		boxes.add(new Box(0, 5, 4));
//		doors.add(new Door(false, false, true, false, 7, 4));
		rooms.add(new Room(8,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

		//////////////////8888888888888////////////////
		barriers.add(new SmallBarrier(0, 3, 10));
		barriers.add(new SmallBarrier(4, 5, 11));
		barriers.add(new SmallBarrier(1, 8, 8));
		barriers.add(new SmallBarrier(1, 6, 4));
		barriers.add(new SmallBarrier(3, 2, 11));
		barriers.add(new SmallBarrier(2, 2, 12));
		boxes.add(new Box(2, 3, 10));
		boxes.add(new Box(1, 3, 7));
		boxes.add(new Box(3, 6, 4));
		boxes.add(new Box(3, 9, 11));
		boxes.add(new Box(0, 8, 12));
		boxes.add(new Box(0, 4, 13));
		boxes.add(new Box(3, 1, 7));
		boxes.add(new Box(3, 4, 5));
		boxes.add(new Box(0, 8, 6));
		boxes.add(new Box(0, 5, 1));
//		doors.add(new Door(false, false, false, true, 2, 8));
//		doors.add(new Door(true, false, false, true, 8, 9));
		rooms.add(new Room(9,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        /////////////9999999999///////////
		barriers.add(new SmallBarrier(1, 4, 10));
		barriers.add(new SmallBarrier(1, 5, 11));
		barriers.add(new SmallBarrier(2, 4, 8));
		barriers.add(new SmallBarrier(3, 5, 8));
		barriers.add(new SmallBarrier(3, 6, 9));
		barriers.add(new SmallBarrier(2, 7, 3));
		boxes.add(new Box(0, 4, 12));
		boxes.add(new Box(0, 4, 9));
		boxes.add(new Box(3, 7, 11));
		boxes.add(new Box(3, 7, 10));
		boxes.add(new Box(1, 7, 1));
		boxes.add(new Box(2, 6, 3));
		boxes.add(new Box(2, 8, 6));
		boxes.add(new Box(3, 3, 9));
		boxes.add(new Box(2, 2, 7));
		boxes.add(new Box(1, 5, 5));
//		doors.add(new Door(false, false, true, false, 9, 10));
//		doors.add(new Door(true, false, false, false, 9, 11));
//		doors.add(new Door(false, true, false, false, 9, 8));
		rooms.add(new Room(10,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

        ////////////10///////////////
		barriers.add(new SmallBarrier(1, 4, 10));
		barriers.add(new SmallBarrier(1, 5, 11));
		barriers.add(new SmallBarrier(2, 4, 8));
		barriers.add(new SmallBarrier(3, 5, 8));
		barriers.add(new SmallBarrier(3, 6, 9));
		barriers.add(new SmallBarrier(2, 7, 3));
		boxes.add(new Box(0, 4, 12));
		boxes.add(new Box(0, 4, 9));
		boxes.add(new Box(3, 7, 11));
		boxes.add(new Box(3, 7, 10));
		boxes.add(new Box(1, 7, 1));
		boxes.add(new Box(2, 6, 3));
		boxes.add(new Box(2, 8, 6));
		boxes.add(new Box(3, 3, 9));
		boxes.add(new Box(2, 2, 7));
		boxes.add(new Box(1, 5, 5));
//		doors.add(new Door(false, false, false, true, 9, 10));
		rooms.add(new Room(11,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

		barriers.add(new SmallBarrier(1, 4, 10));
		barriers.add(new SmallBarrier(1, 5, 11));
		barriers.add(new SmallBarrier(2, 4, 8));
		barriers.add(new SmallBarrier(3, 5, 8));
		barriers.add(new SmallBarrier(3, 6, 9));
		barriers.add(new SmallBarrier(2, 7, 3));
		boxes.add(new Box(0, 4, 12));
		boxes.add(new Box(0, 4, 9));
		boxes.add(new Box(3, 7, 11));
		boxes.add(new Box(3, 7, 10));
		boxes.add(new Box(1, 7, 1));
		boxes.add(new Box(2, 6, 3));
		boxes.add(new Box(2, 8, 6));
		boxes.add(new Box(3, 3, 9));
		boxes.add(new Box(2, 2, 7));
		boxes.add(new Box(1, 5, 5));
//		doors.add(new Door(false, false, true, false, 9, 11));
		rooms.add(new Room(12,boxes, barriers, enemies, doors));
		boxes.clear();
		doors.clear();
		barriers.clear();

	}
}
