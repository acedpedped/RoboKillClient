package robokill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 6/27/15
 * Time: 7:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends Menu implements ActionListener{
    private JButton start, credits, options;
    private MainMenu mainMenu;
    public static Map map;
    public static OptionsMenu optionMenu;
    public static CreditsMenu creditsMenu;


    public  MainMenu()
    {
        super();

        start = new JButton("start", button1);
        start.setFont(font);
        start.setForeground(Color.yellow);
        start.setVerticalTextPosition(JButton.CENTER);
        start.setHorizontalTextPosition(JButton.CENTER);
        start.setSize(button1.getIconWidth(), button1.getIconHeight());
        start.setRolloverIcon(button);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setOpaque(false);
        start.setLocation(300, 200);
        start.addActionListener(this);

        options = new JButton("options", button1);
        options.setFont(font);
        options.setForeground(Color.yellow);
        options.setVerticalTextPosition(JButton.CENTER);
        options.setHorizontalTextPosition(JButton.CENTER);
        options.setSize(button1.getIconWidth(), button1.getIconHeight());
        options.setRolloverIcon(button);
        options.setContentAreaFilled(false);
        options.setBorderPainted(false);
        options.setOpaque(false);
        options.addActionListener(this);
        options.setLocation(300, 250);


        credits = new JButton("credits", button1);
        credits.setFont(font);
        credits.setForeground(Color.yellow);
        credits.setVerticalTextPosition(JButton.CENTER);
        credits.setHorizontalTextPosition(JButton.CENTER);
        credits.setSize(button1.getIconWidth(), button1.getIconHeight());
        credits.setRolloverIcon(button);
        credits.setContentAreaFilled(false);
        credits.setBorderPainted(false);
        credits.setOpaque(false);
        credits.addActionListener(this);
        credits.setLocation(300, 300);

        add(start);
        add(options);
        add(credits);


        //frame.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd == "start")
        {
            Robokill.frame.remove(Robokill.mainMenu);
            map = new Map();
            Robokill.frame.repaint();
            //map.build();
            //map.build();
        }
        else if(cmd == "options")
        {
            optionMenu = new OptionsMenu();
            Robokill.frame.remove(Robokill.mainMenu);
            //Robokill.frame.getContentPane().setVisible(false);
            //repaint();
            Robokill.frame.add(optionMenu);
            Robokill.frame.repaint();
            //repaint();
        }
        else if(cmd == "credits")
        {
           //frame.dispose();
           creditsMenu = new CreditsMenu();
            Robokill.frame.add(creditsMenu);
            Robokill.frame.repaint();
            Robokill.frame.remove(Robokill.mainMenu);
            //Robokill.frame.repaint();
        }
    }
}
