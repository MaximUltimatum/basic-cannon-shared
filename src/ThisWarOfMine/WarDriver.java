package ThisWarOfMine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
//TODO Javadoc
/**
 * Created by Student on 11/29/2016.
 */
public class WarDriver {
    public JFrame frame = new JFrame();
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        WarPainter OnlyBeOne = new WarPainter();
        System.out.println(frame.getContentPane().getBackground());
        frame.add(OnlyBeOne);
        frame.setSize(1200,600);
        frame.setVisible(true);
        frame.repaint();
        frame.setTitle("This War of Mine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
