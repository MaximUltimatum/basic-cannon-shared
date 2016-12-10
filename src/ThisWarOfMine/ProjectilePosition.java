package ThisWarOfMine;

import java.awt.*;

/**
 * Created by Student on 12/1/2016.
 * Is used to store a projectile in general case
 * Calculates x and y position in pixels
 * Forms basis for medium projectile
 */
//TODO Javadoc
public class ProjectilePosition {
    private int pixelY = 400;//actual position of the ball on the screen
    private int pixelX = 0;
    private double angle = (Math.PI/4); //angle of cannon (0<angle<90)
    private int startVelocity = 20;//40,60,80,100 (adjust for light & medium) TODO Replace with slider/other listener
    private int timeCount = 0;//in milliseconds
    private int damage = 5;//light 3, heavy 10
    public Color positionTeamColor;

    public int getStartVelocity() {
        return startVelocity;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setStartVelocity(int startVelocity) {
        this.startVelocity = startVelocity;
    }

    public ProjectilePosition(int x, int y, double cannonAngle, int velocity, Color teamColor){
        pixelX = x;
        pixelY = 400 - y;
        angle = cannonAngle;
        startVelocity = velocity;
        positionTeamColor = teamColor;
    }


    public int getTimeCount(){return timeCount;}
    public void setTimeCount(int time){timeCount = time;}
    //pixelX at time t
    public int getPixelX(){
        if(positionTeamColor == Color.BLUE) {
            pixelX = (int) Math.round(startVelocity * (timeCount / 1000.0) * Math.cos(angle));
        }
        if(positionTeamColor == Color.RED){
            pixelX = (int) (640 + Math.round(startVelocity * (timeCount / 1000.0) * Math.cos(angle)));
        }
        return pixelX;
    }

    public int getPixelY(){
        pixelY = 350 - ((int)Math.round((startVelocity*(timeCount/1000.0)*Math.sin(angle))-(4.9*Math.pow((timeCount/1000.0),2))));
        return pixelY;
    }


}
