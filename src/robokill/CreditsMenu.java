package robokill;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 6/27/15
 * Time: 5:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreditsMenu extends Menu {

    public CreditsMenu()
    {
        super();
        Robokill.frame.add(this);
        Robokill.frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString("Credits", 0, 0);
    }
}
