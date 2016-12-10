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
    int blueVelocity = 30;
    int redAngle = 135;
    int redStartX = 640;
    int redStartY = 345;
    int redVelocity = 30;
    boolean redWin = false;
    boolean blueWin = false;
    Color teamColor;
    public ProjectileMedium blueRoundShot;
    public ProjectileMedium redRoundShot;
    StationMount rightMount;
    public RandomWall obstacle = new RandomWall(340,(int)(Math.random()*200), Color.GRAY, 10, (int)(Math.random()*200));//340,200, Color.GRAY, 10, 100

    StationMount leftMount;
    Graphics2D WarG2D;
    Graphics2D BlueCannonRotator;
    Graphics2D RedCannonRotator;
    boolean collided = false;
    public void paint(Graphics g) {
        WarG2D = (Graphics2D) g;
        BlueCannonRotator = (Graphics2D) g;
        RedCannonRotator = (Graphics2D) g;

        //sets up stationary objects
        leftMount = new StationMount(0, 330, Color.BLUE, 40, 60);
        leftMount.draw(WarG2D);
        rightMount = new StationMount(630, 330, Color.RED, 40, 60);
        rightMount.draw(WarG2D);
        obstacle.draw(WarG2D);
        //paintProjectile(WarG2D, roundShot);

    }

    public void paintProjectile(Graphics passGraphicStrat, ProjectileMedium anyShot){
        collided = false;
        createBufferStrategy(2);
        BufferStrategy strategy = getBufferStrategy();
        WarDriver getInvisibleColor = new WarDriver();
        Color invisiColor = getInvisibleColor.frame.getContentPane().getBackground();
        while(collided != true) {
            int sleepyTime = 40;

            //blueRoundShot = anyShot;
            try {
                Graphics graphicStrat = strategy.getDrawGraphics();
                //draws and moves the projectile
                anyShot.setBallColor(invisiColor);
                anyShot.draw(graphicStrat);//erases
                anyShot.setBallColor(teamColor);
                anyShot.addMedProjectileTime(sleepyTime);
                anyShot.draw(graphicStrat);//draws again

                //repaint stationary objects
                leftMount.draw(graphicStrat);
                rightMount.draw(graphicStrat);
                obstacle.draw(graphicStrat);
                Graphics2D g2d = (Graphics2D) passGraphicStrat;


                //resets graphics and displays
                graphicStrat.dispose();
                strategy.show();
                anyShot.setBallColor(invisiColor);
                Thread.sleep(sleepyTime);
            } catch (InterruptedException e) {

            }
            anyShot.setBallColor(teamColor);
            collided = checkPositions(anyShot);
        }
    }

    public void setupShots(){
        blueRoundShot = new ProjectileMedium(blueStartX, blueStartY, Color.BLUE, 12, blueAngle, blueVelocity);//large size 20 med size 12 small size 8
        redRoundShot = new ProjectileMedium(redStartX, redStartY, Color.RED, 12, redAngle, redVelocity);
    }

    public boolean checkPositions(ProjectileMedium myBallistic){
        boolean possibleCollision = false;
        if(myBallistic.getxCoord() > 800 || myBallistic.getxCoord() < 0) {
            possibleCollision = true;
            System.out.println(myBallistic.getxCoord());
            System.out.println("COLLISION");
        }
        if(myBallistic.getyCoord() > 400 || myBallistic.getyCoord() < -10) {
            possibleCollision = true;
            System.out.println("COLLISION");
        }
        if(myBallistic.getxCoord()>obstacle.getxCoord()&&myBallistic.getxCoord()<(obstacle.getxCoord()+obstacle.getWidth())&&myBallistic.getyCoord()>obstacle.getyCoord()&&myBallistic.getyCoord()<(obstacle.getyCoord()+obstacle.getHeight())){
            possibleCollision = true;
            System.out.println("COLLISION");
        }
        if(myBallistic.getxCoord()>630&&myBallistic.getyCoord()>330&&myBallistic.getBallColor()!=Color.RED){
            System.out.println("RED DESTROYED");
            possibleCollision = true;
            blueWin = true;
        }
        if(myBallistic.getxCoord()<40&&myBallistic.getyCoord()>330&&myBallistic.getBallColor()!=Color.BLUE){
            System.out.println("BLUE DESTROYED");
            possibleCollision = true;
            redWin = true;
        }

        return possibleCollision;
    }

}
