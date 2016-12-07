package ThisWarOfMine;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Student on 12/1/2016.
 */
public class ProjectileMedium extends StationParts{
    private int ballSize;// = 50;
    private ProjectilePosition medPosition;
    public ProjectileMedium(int x, int y, Color color, int size, double angle, int powerVelocity){
        super(x,y,color);
        medPosition = new ProjectilePosition(x,y, angle, powerVelocity);//TODO Calculate Velocity from weight & power
        ballSize = size;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }
    public Color getBallColor(){
        return getShade();
    }
    public int getMedProjectileTime(){return medPosition.getTimeCount();}
    public void addMedProjectileTime(int time){medPosition.setTimeCount(medPosition.getTimeCount()+time);}

    //Override the get x and get y to a parabola
    public int getxCoord(){
        return medPosition.getPixelX();
    }
    public int getyCoord(){
        return medPosition.getPixelY();
    }


    public void setBallColor(Color aColor){
         setShade(aColor);
    }

    public int getBallSize() {
        return ballSize;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getShade());
        Ellipse2D medBall = new Ellipse2D.Double(getxCoord(),getyCoord(), getBallSize(), getBallSize());
        g2.draw(medBall);
        g2.fill(medBall);
    }
}
