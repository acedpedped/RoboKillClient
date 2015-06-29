/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 6/23/15
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */

package robokill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Map extends JPanel{
    public static String sep = File.separator;
    //protected JFrame frame = new JFrame();

    //JPanel panel = this;

    protected ArrayList<Room> rooms = new ArrayList<Room>();
    protected Robot robot = new Robot(400, 500);
    protected Image background = new ImageIcon(new File("").getAbsolutePath() + sep + "res" + sep + "Image" + sep + "image 187.png").getImage();

    public Map()
    {
        setSize(800, 600);
        setDoubleBuffered(true);

        //new Room(null, null, null, null);



    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        //rooms.get(0).paint(g);
    }
    /**
     * shows the situation of the rooms
     */
    public void showMap()
    {

    }

    /**
     * for building the rooms
     * @param
     */
    public void build()
    {
        ArrayList<Box> boxes = new ArrayList<Box>();
        ArrayList<SmallBarrier> barriers = new ArrayList<SmallBarrier>();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        ArrayList<Door> doors = new ArrayList<Door>();

        doors.add(new Door(true, false, false, false, 0, 1));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        doors.clear();

        /////////////////0000000000///////////////////

        boxes.add(new Box(0,2,3));  boxes.add(new Box(1, 3,3)); boxes.add(new Box(2, 4, 4)); boxes.add(new Box(3, 3, 4));
        doors.add(new Door(true, false, false, false, 1, 2));        doors.add(new Door(false, false, true, false, 0, 1));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        doors.clear();  boxes.clear();

        //////////////111111111111////////////////

        boxes.add(new Box(0,2,3));  boxes.add(new Box(1, 3,3)); boxes.add(new Box(2, 4, 4)); boxes.add(new Box(3, 3, 4));
        barriers.add(new SmallBarrier(0,7,7));
        barriers.add(new SmallBarrier(4,5,5));
        barriers.add(new SmallBarrier(3, 10,8));
        doors.add(new Door(false, true, false, false, 2, 8));   doors.add(new Door(false, false, false, true, 3, 2));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        doors.clear();  boxes.clear();  barriers.clear();

        ////////////2222222222222//////////////

        boxes.add(new Box(2,2,8));
        boxes.add(new Box(1,2,2));
        boxes.add(new Box(2,2,9));
        boxes.add(new Box(3,3,8));
        boxes.add(new Box(2,2,7));
        boxes.add(new Box(0,3,9));
        barriers.add(new SmallBarrier(1, 8, 2));
        barriers.add(new SmallBarrier(2, 9, 2));
        barriers.add(new SmallBarrier(2, 9, 3));
        doors.add(new Door(false, true, false, false, 2, 3));   doors.add(new Door(false, false, false, true, 3, 4));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        ///////////////////333333333333//////////////////

        boxes.add(new Box(2,2,8));
        boxes.add(new Box(0,3,8));
        boxes.add(new Box(0,4,8));
        boxes.add(new Box(0,5,8));
        boxes.add(new Box(1,6,7));
        boxes.add(new Box(3,5,7));
        barriers.add(new SmallBarrier(0,6, 6));
        barriers.add(new SmallBarrier(0,5, 6));
        barriers.add(new SmallBarrier(0,6, 5));
        barriers.add(new SmallBarrier(0,5, 5));
        doors.add(new Door(true, false, false, false, 4, 7));   doors.add(new Door(false, false, true, false, 4, 6));
        doors.add(new Door(false, false, false,true, 4, 5));   doors.add(new Door(false, true, false, false, 3, 4));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        /////////////444444444////////////////

        barriers.add(new SmallBarrier(1,6, 6));
        barriers.add(new SmallBarrier(1,5, 6));
        barriers.add(new SmallBarrier(1,6, 5));
        barriers.add(new SmallBarrier(1,5, 5));
        barriers.add(new SmallBarrier(1,6, 7));
        barriers.add(new SmallBarrier(2,4, 9));
        boxes.add(new Box(2,4,8));
        boxes.add(new Box(1,3,4));
        boxes.add(new Box(2,4,1));
        boxes.add(new Box(3,5,7));
        boxes.add(new Box(3,3,3));
        boxes.add(new Box(3,5,7));
        doors.add(new Door(false, true, false, false, 4, 5));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        //////////////555555555555/////////////////

        barriers.add(new SmallBarrier(0,1, 6));
        barriers.add(new SmallBarrier(0,5, 6));
        barriers.add(new SmallBarrier(2,8, 4));
        barriers.add(new SmallBarrier(3,3, 2));
        barriers.add(new SmallBarrier(3,9, 5));
        barriers.add(new SmallBarrier(2,7, 3));
        boxes.add(new Box(2,4,8));
        boxes.add(new Box(1,3,4));
        boxes.add(new Box(1,9,1));
        boxes.add(new Box(1,5,7));
        boxes.add(new Box(0,3,3));
        boxes.add(new Box(0,7,4));
        boxes.add(new Box(2,4,1));
        boxes.add(new Box(3,5,7));
        boxes.add(new Box(3,3,3));
        boxes.add(new Box(3,3,7));
        doors.add(new Door(true, false, false, false, 4, 6));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        /////////////6666666666////////////

        barriers.add(new SmallBarrier(4,4, 4));
        barriers.add(new SmallBarrier(4,5, 3));
        barriers.add(new SmallBarrier(2,8, 4));
        barriers.add(new SmallBarrier(3,9, 9));
        barriers.add(new SmallBarrier(3,9, 5));
        barriers.add(new SmallBarrier(2,7, 1));
        boxes.add(new Box(2,3,6));
        boxes.add(new Box(1,3,4));
        boxes.add(new Box(3,1,11));
        boxes.add(new Box(3,3,11));
        boxes.add(new Box(0,8,12));
        boxes.add(new Box(0,5,10));
        doors.add(new Door(false, false, true, false, 7, 4));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        //////////////777777777777777/////////////

        barriers.add(new SmallBarrier(0,4, 10));
        barriers.add(new SmallBarrier(4,5, 11));
        barriers.add(new SmallBarrier(1,8, 12));
        barriers.add(new SmallBarrier(1,9, 10));
        barriers.add(new SmallBarrier(3,9, 11));
        barriers.add(new SmallBarrier(2,7, 12));
        boxes.add(new Box(2,3,10));
        boxes.add(new Box(1,3,9));
        boxes.add(new Box(3,1,11));
        boxes.add(new Box(3,3,11));
        boxes.add(new Box(0,8,12));
        boxes.add(new Box(0,5,3));
        boxes.add(new Box(3,1,4));
        boxes.add(new Box(3,3,5));
        boxes.add(new Box(0,8,3));
        boxes.add(new Box(0,5,4));
        doors.add(new Door(false, false, true, false, 7, 4));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        //////////////////8888888888888////////////////
        barriers.add(new SmallBarrier(0,3, 10));
        barriers.add(new SmallBarrier(4,5, 11));
        barriers.add(new SmallBarrier(1,8, 8));
        barriers.add(new SmallBarrier(1,6, 4));
        barriers.add(new SmallBarrier(3,2, 11));
        barriers.add(new SmallBarrier(2,2, 12));
        boxes.add(new Box(2,3,10));
        boxes.add(new Box(1,3,7));
        boxes.add(new Box(3,6,4));
        boxes.add(new Box(3,9,11));
        boxes.add(new Box(0,8,12));
        boxes.add(new Box(0,4,13));
        boxes.add(new Box(3,1,7));
        boxes.add(new Box(3,4,5));
        boxes.add(new Box(0,8,6));
        boxes.add(new Box(0,5,1));
        doors.add(new Door(false, false, false, true, 2, 8));
        doors.add(new Door(true, false, false, true, 8, 9));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        /////////////9999999999///////////


        barriers.add(new SmallBarrier(1,4, 10));
        barriers.add(new SmallBarrier(1,5, 11));
        barriers.add(new SmallBarrier(2,4, 8));
        barriers.add(new SmallBarrier(3,5, 8));
        barriers.add(new SmallBarrier(3,6, 9));
        barriers.add(new SmallBarrier(2,7, 3));
        boxes.add(new Box(0,4,12));
        boxes.add(new Box(0,4,9));
        boxes.add(new Box(3,7,11));
        boxes.add(new Box(3,7,10));
        boxes.add(new Box(1,7,1));
        boxes.add(new Box(2,6,3));
        boxes.add(new Box(2,8,6));
        boxes.add(new Box(3,3,9));
        boxes.add(new Box(2,2,7));
        boxes.add(new Box(1,5,5));
        doors.add(new Door(false, false, true, false, 9,  10));
        doors.add(new Door(true, false, false, false, 9 , 11));
        doors.add(new Door(false, true, false, false, 9, 8));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();

        ////////////10///////////////

        barriers.add(new SmallBarrier(1,4, 10));
        barriers.add(new SmallBarrier(1,5, 11));
        barriers.add(new SmallBarrier(2,4, 8));
        barriers.add(new SmallBarrier(3,5, 8));
        barriers.add(new SmallBarrier(3,6, 9));
        barriers.add(new SmallBarrier(2,7, 3));
        boxes.add(new Box(0,4,12));
        boxes.add(new Box(0,4,9));
        boxes.add(new Box(3,7,11));
        boxes.add(new Box(3,7,10));
        boxes.add(new Box(1,7,1));
        boxes.add(new Box(2,6,3));
        boxes.add(new Box(2,8,6));
        boxes.add(new Box(3,3,9));
        boxes.add(new Box(2,2,7));
        boxes.add(new Box(1,5,5));
        doors.add(new Door(false, false, false, true, 9, 10));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();


        barriers.add(new SmallBarrier(1,4, 10));
        barriers.add(new SmallBarrier(1,5, 11));
        barriers.add(new SmallBarrier(2,4, 8));
        barriers.add(new SmallBarrier(3,5, 8));
        barriers.add(new SmallBarrier(3,6, 9));
        barriers.add(new SmallBarrier(2,7, 3));
        boxes.add(new Box(0,4,12));
        boxes.add(new Box(0,4,9));
        boxes.add(new Box(3,7,11));
        boxes.add(new Box(3,7,10));
        boxes.add(new Box(1,7,1));
        boxes.add(new Box(2,6,3));
        boxes.add(new Box(2,8,6));
        boxes.add(new Box(3,3,9));
        boxes.add(new Box(2,2,7));
        boxes.add(new Box(1,5,5));
        doors.add(new Door(false, false, true, false, 9,  11));
        rooms.add(new Room(boxes, barriers, enemies, doors));
        boxes.clear(); doors.clear(); barriers.clear();


    }
}
