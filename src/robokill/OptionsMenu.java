package robokill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 6/27/15
 * Time: 5:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class OptionsMenu extends Menu implements ActionListener {
    private JButton soundOff, soundOn, musicOn, musicOff, back;

    public OptionsMenu()
    {
        super();

        soundOff = new JButton("On", button1);
        soundOff.setFont(font);
        soundOff.setForeground(Color.yellow);
        soundOff.setSize(button1.getIconWidth(), button1.getIconHeight());
        soundOff.setRolloverIcon(button);
        soundOff.setOpaque(false);
        soundOff.setContentAreaFilled(false);
        soundOff.setBorderPainted(false);
        soundOff.addActionListener(this);
        soundOff.setLocation(420, 230);


        soundOn = new JButton("Off", button1);
        soundOn.setFont(font);
        soundOn.setForeground(Color.yellow);
        soundOn.setSize(button1.getIconWidth(), button1.getIconHeight());
        soundOn.setRolloverIcon(button);
        soundOn.setOpaque(false);
        soundOn.setContentAreaFilled(false);
        soundOn.setBorderPainted(false);
        soundOn.addActionListener(this);
        soundOn.setLocation(260, 230);


        musicOff = new JButton("Off", button1);
        musicOff.setFont(font);
        musicOff.setSize(button1.getIconWidth(), button1.getIconHeight());
        musicOff.setRolloverIcon(button);
        musicOff.setForeground(Color.yellow);
        musicOff.setOpaque(false);
        musicOff.setContentAreaFilled(false);
        musicOff.setBorderPainted(false);
        musicOff.addActionListener(this);
        musicOff.setLocation(420, 360);

        musicOn = new JButton("on");
        musicOn.setIcon(button1);
        musicOn.setFont(font);
        musicOn.setForeground(Color.yellow);
        musicOn.setSize(button1.getIconWidth(), button1.getIconHeight());
        musicOn.setRolloverIcon(button);
        musicOn.setOpaque(false);
        musicOn.setContentAreaFilled(false);
        musicOn.setBorderPainted(false);
        musicOn.addActionListener(this);
        musicOn.setLocation(260, 360);


        back = new JButton("Back", button1);
        back.setFont(font);
        back.setSize(button1.getIconWidth(), button1.getIconHeight());
        back.setRolloverIcon(button);
        back.setOpaque(false);
        back.setForeground(Color.yellow);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        back.setLocation(360, 500);

        add(back);
        add(soundOff);
        add(soundOn);
        add(musicOff);
        add(musicOn);


        //Robokill.frame.getContentPane().setVisible(true);


    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //g.drawString("kir", 270, 370);
        //super.paintComponent(g);
        /*musicOn.repaint();
        musicOff.repaint();
        soundOff.repaint();
        soundOn.repaint();
        back.repaint(); */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back)
        {
            Robokill.frame.remove(MainMenu.optionMenu);
            Robokill.frame.add(Robokill.mainMenu);
            Robokill.frame.repaint();
        }

    }
}
