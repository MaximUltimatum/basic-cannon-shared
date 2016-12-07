package ThisWarOfMine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * Created by Student on 11/29/2016.
 */
//TODO Javadoc
public class WarPainter extends Canvas{
    public ProjectileMedium roundShot;        //large size 20 med size 12 small size 8
    public StationMount rightMount;
    public RandomWall obstacle;
    StationMount leftMount;
    CannonBarrel blueCannon;
    public void paint(Graphics g) {
        Graphics2D WarG2D = (Graphics2D) g;

        //sets up stationary objects
        leftMount = new StationMount(45, 330, Color.BLUE, 40, 60);
        leftMount.draw(WarG2D);
        rightMount = new StationMount(740, 330, Color.RED, 40, 60);
        rightMount.draw(WarG2D);
        obstacle = new RandomWall(380,200, Color.GRAY, 10, 60);
        obstacle.draw(WarG2D);
        blueCannon = new CannonBarrel(45, 330, Color.RED, 45);
        blueCannon.draw(WarG2D);

        //pass paitnProjectile a shot TODO need direction code
        ProjectileMedium testingShot = new ProjectileMedium(15, 360, Color.BLUE, 12,(Math.PI/4), 100);
        paintProjectile(WarG2D, testingShot);

    }

    public void paintProjectile(Graphics passGraphicStrat, ProjectileMedium anyShot){
        createBufferStrategy(2);
        BufferStrategy strategy = getBufferStrategy();
        WarDriver getInvisibleColor = new WarDriver();
        Color invisiColor = getInvisibleColor.frame.getContentPane().getBackground();


        roundShot = anyShot;
        try {
            for (int i = 0; i < 2000; i++) {//erase and redraw somehow (Use 3 step move - draw current position in background color, change position, draw current position
                Graphics graphicStrat = strategy.getDrawGraphics();

                //draws and moves the projectile
                roundShot.setBallColor(invisiColor);
                roundShot.draw(graphicStrat);//erases
                roundShot.setBallColor(Color.BLUE);
                roundShot.addMedProjectileTime(50);
                roundShot.draw(graphicStrat);//draws again

                //repaint stationary objects
                leftMount.draw(graphicStrat);
                rightMount.draw(graphicStrat);
                obstacle.draw(graphicStrat);
                blueCannon.draw(graphicStrat);
                Graphics2D g2d = (Graphics2D)passGraphicStrat;


                //resets graphics and displays
                graphicStrat.dispose();
                strategy.show();
                roundShot.setBallColor(invisiColor);
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e){

        }
    }

}
