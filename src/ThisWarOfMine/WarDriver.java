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
        JLabel powerBlue = new JLabel("Power: 30");
        JLabel angleRed = new JLabel("Angle: 45");
        JLabel powerRed = new JLabel("Power: 30");
        dataPanelBlue.add(angleBlue);
        dataPanelBlue.add(powerBlue);
        dataPanelRed.add(angleRed);
        dataPanelRed.add(powerRed);
        WarPainter OnlyBeOne = new WarPainter();
        OnlyBeOne.setupShots();

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
                    OnlyBeOne.teamColor = Color.BLUE;
                    OnlyBeOne.paintProjectile(OnlyBeOne.WarG2D, blueShot);
                    //reset values here
                    OnlyBeOne.blueRoundShot.setVelocity(30);
                    OnlyBeOne.blueRoundShot.setAngle(45);
                    angleBlue.setText("Angle: 45");
                    powerBlue.setText("Power: 30");
                    if (OnlyBeOne.blueWin){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException l) {
                            System.out.println("Exception Problem!");
                        }
                        System.out.println("BLUE WINS!");
                        System.exit(0);
                    }
                }
                if (key == 'w') {
                    if(OnlyBeOne.blueRoundShot.getAngle() < 90) {
                        OnlyBeOne.blueRoundShot.setAngle(OnlyBeOne.blueRoundShot.getAngle()+5);
                        angleBlue.setText("Angle: " + OnlyBeOne.blueRoundShot.getAngle());
                    }
                }
                if (key == 'q'){
                    if(OnlyBeOne.blueRoundShot.getVelocity() < 180){
                        OnlyBeOne.blueRoundShot.setVelocity(OnlyBeOne.blueRoundShot.getVelocity()+15);
                        powerBlue.setText("Power: " + OnlyBeOne.blueRoundShot.getVelocity());
                    }
                }
                if(key == 'a'){
                    if(OnlyBeOne.blueRoundShot.getVelocity() > 30){
                        OnlyBeOne.blueRoundShot.setVelocity(OnlyBeOne.blueRoundShot.getVelocity()-15);
                        powerBlue.setText("Power: " + OnlyBeOne.blueRoundShot.getVelocity());
                    }
                }


                //RED CANNON
                if (key == 'k') {
                    if(OnlyBeOne.redRoundShot.getAngle() < 180) {
                        OnlyBeOne.redRoundShot.setAngle(OnlyBeOne.redRoundShot.getAngle()+5);
                        angleRed.setText("Angle: " + (180-OnlyBeOne.redRoundShot.getAngle()));
                    }
                }

                if (key == 'm') {
                    OnlyBeOne.redStartX = 640;
                    ProjectileMedium redShot = new ProjectileMedium(OnlyBeOne.redStartX, OnlyBeOne.redStartY, Color.RED, 12, (Math.PI/180)*OnlyBeOne.redRoundShot.getAngle(), OnlyBeOne.redRoundShot.getVelocity());
                    redShot.setxCoord(640);
                    System.out.println(redShot.getxCoord());
                    OnlyBeOne.teamColor = Color.RED;
                    OnlyBeOne.paintProjectile(OnlyBeOne.WarG2D, redShot);
                    //reset values here
                    OnlyBeOne.redRoundShot.setVelocity(30);
                    OnlyBeOne.redRoundShot.setAngle(135);
                    angleBlue.setText("Angle: 45");
                    powerBlue.setText("Power: 30");
                    if (OnlyBeOne.redWin){
                        System.out.println("RED WINS");
                        try {
                            Thread.sleep(4000);
                            System.out.println("Sleeping!");
                        } catch (InterruptedException l) {
                            System.out.println("Excepted");
                        }
                        System.exit(0);
                    }
                }
                if (key == 'o') {
                    if(OnlyBeOne.redRoundShot.getAngle() > 90) {
                        OnlyBeOne.redRoundShot.setAngle(OnlyBeOne.redRoundShot.getAngle()-5);
                        angleRed.setText("Angle: " + (180-OnlyBeOne.redRoundShot.getAngle()));
                    }
                }
                if (key == 'p'){
                    if(OnlyBeOne.redRoundShot.getVelocity() < 180){
                        OnlyBeOne.redRoundShot.setVelocity(OnlyBeOne.redRoundShot.getVelocity()+15);
                        powerRed.setText("Power: " + OnlyBeOne.redRoundShot.getVelocity());
                    }
                }
                if(key == 'l'){
                    if(OnlyBeOne.redRoundShot.getVelocity() > 30){
                        OnlyBeOne.redRoundShot.setVelocity(OnlyBeOne.redRoundShot.getVelocity()-15);
                        powerRed.setText("Power: " + OnlyBeOne.redRoundShot.getVelocity());
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
