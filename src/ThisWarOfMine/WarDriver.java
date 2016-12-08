package ThisWarOfMine;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
//TODO Javadoc
/**
 * Created by Student on 11/29/2016.
 */
public class WarDriver {
    public JFrame frame = new JFrame();
    public static void main(String[] args)
    {
        JPanel dataPanelBlue = new JPanel();
        dataPanelBlue.setBackground(Color.BLUE);
        JPanel dataPanelRed = new JPanel();
        dataPanelRed.setBackground(Color.RED);
        dataPanelBlue.setLayout(new GridLayout(2,1));
        dataPanelRed.setLayout(new GridLayout(2,1));
        JLabel angleBlue = new JLabel("Angle: 45");
        JLabel powerBlue = new JLabel("Power: 15");
        JLabel angleRed = new JLabel("Angle: 45");
        JLabel powerRed = new JLabel("Power: 15");
        dataPanelBlue.add(angleBlue);
        dataPanelBlue.add(powerBlue);
        dataPanelRed.add(angleRed);
        dataPanelRed.add(powerRed);
        WarPainter OnlyBeOne = new WarPainter();


        class LowKeyListener implements ActionListener, KeyListener{
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                if (key == 's') {
                    if(OnlyBeOne.blueRoundShot.getAngle() > 0) {
                        OnlyBeOne.blueRoundShot.setAngle(OnlyBeOne.blueRoundShot.getAngle()-5);
                        angleBlue.setText("Angle: " + OnlyBeOne.blueRoundShot.getAngle());
                    }
                }

                if (key == 'x') {
                    ProjectileMedium blueShot = new ProjectileMedium(OnlyBeOne.blueStartX, OnlyBeOne.blueStartY, Color.BLUE, 12, (Math.PI/180)*OnlyBeOne.blueRoundShot.getAngle(), OnlyBeOne.blueRoundShot.getVelocity());
                    OnlyBeOne.paintProjectile(OnlyBeOne.WarG2D, blueShot);
                }
                if (key == 'w') {
                    if(OnlyBeOne.blueRoundShot.getAngle() < 90) {
                        OnlyBeOne.blueRoundShot.setAngle(OnlyBeOne.blueRoundShot.getAngle()+5);
                        angleBlue.setText("Angle: " + OnlyBeOne.blueRoundShot.getAngle());
                    }
                }
            }
            public void keyReleased(KeyEvent e){

            }
            public void keyTyped(KeyEvent e){

            }
            public void actionPerformed(ActionEvent p){

            }
        }

        KeyListener WarListener = new LowKeyListener();

        JFrame frame = new JFrame();
        frame.setFocusable(true);
        frame.addKeyListener(WarListener);
        frame.add(dataPanelBlue, BorderLayout.WEST);
        frame.add(dataPanelRed, BorderLayout.EAST);
        frame.add(OnlyBeOne);
        frame.setSize(800,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("This War of Mine");

    }


}
