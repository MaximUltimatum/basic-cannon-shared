package ThisWarOfMine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * Created by Student on 11/29/2016.
 */
//TODO Javadoc
public class WarPainter extends Canvas{
    int blueAngle = 45;
    int blueStartX = 15;
    int blueStartY = 345;
    int blueVelocity = 45;
    int redAngle = 45;
    int redStartX = 640;
    int redStartY = 345;
    int redVelocity = 45;
    public ProjectileMedium blueRoundShot = new ProjectileMedium(blueStartX, blueStartY, Color.BLUE, 12,blueAngle, blueVelocity);//large size 20 med size 12 small size 8
    public ProjectileMedium redRoundShot = new ProjectileMedium(redStartX, redStartY, Color.RED, 12, redAngle, redVelocity);
    StationMount rightMount;
    public RandomWall obstacle;
    StationMount leftMount;
    Graphics2D WarG2D;
    CannonBarrel blueCannon;
    boolean collided = false;
    public void paint(Graphics g) {
        WarG2D = (Graphics2D) g;
        //sets up stationary objects
        leftMount = new StationMount(0, 330, Color.BLUE, 40, 60);
        leftMount.draw(WarG2D);
        rightMount = new StationMount(630, 330, Color.RED, 40, 60);
        rightMount.draw(WarG2D);
        obstacle = new RandomWall(380,200, Color.GRAY, 10, 60);
        obstacle.draw(WarG2D);
        blueCannon = new CannonBarrel(45, 330, Color.RED, 45);//test change
        System.out.println(blueCannon.getRotAngle());
        blueCannon.draw(WarG2D);

        //pass paitnProjectile a shot TODO need direction code
        //paintProjectile(WarG2D, roundShot);

    }

    public void paintProjectile(Graphics passGraphicStrat, ProjectileMedium anyShot){
        createBufferStrategy(2);
        BufferStrategy strategy = getBufferStrategy();
        WarDriver getInvisibleColor = new WarDriver();
        Color invisiColor = getInvisibleColor.frame.getContentPane().getBackground();
        while(collided != true) {
            int sleepyTime = 40;

            blueRoundShot = anyShot;
            try {
                Graphics graphicStrat = strategy.getDrawGraphics();
                //draws and moves the projectile
                blueRoundShot.setBallColor(invisiColor);
                blueRoundShot.draw(graphicStrat);//erases
                blueRoundShot.setBallColor(Color.BLUE);
                blueRoundShot.addMedProjectileTime(sleepyTime);
                blueRoundShot.draw(graphicStrat);//draws again

                //repaint stationary objects
                leftMount.draw(graphicStrat);
                rightMount.draw(graphicStrat);
                obstacle.draw(graphicStrat);
                blueCannon.draw(graphicStrat);
                Graphics2D g2d = (Graphics2D) passGraphicStrat;


                //resets graphics and displays
                graphicStrat.dispose();
                strategy.show();
                blueRoundShot.setBallColor(invisiColor);
                Thread.sleep(sleepyTime);
            } catch (InterruptedException e) {

            }
            collided = checkPositions(blueRoundShot);
        }
    }

    public boolean checkPositions(ProjectileMedium myBallistic){
        boolean possibleCollision = false;
        if(blueRoundShot.getxCoord() > 800)
            possibleCollision = true;
        if(blueRoundShot.getyCoord() > 400)
            possibleCollision = true;
        return possibleCollision;
    }

}
