package ThisWarOfMine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Student on 11/29/2016.
 * General case for Mount and RandShape
 * is extended in projectiles and cannons
 * @StationMount
 */
//TODO Javadoc
public class StationParts extends JComponent
{
    private int xCoord;
    private int yCoord;
    private Color shade;

    //Constructors
    public StationParts(int x, int y, Color aColor){
        xCoord = x;
        yCoord = y;
        shade = aColor;
    }

    //Create getters & setters
    public int getxCoord(){
        return xCoord;
    }
    public int getyCoord(){
        return yCoord;
    }
    public Color getShade(){
        return shade;
    }
    public void setShade(Color color){shade = color;}
    public void setxCoord(int x){
        xCoord = x;
    }
    public void setyCoord(int y){
        yCoord = y;
    }
    public void setLocation(int x, int y){
        xCoord = x;
        yCoord = y;
    }
}
