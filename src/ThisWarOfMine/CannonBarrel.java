package ThisWarOfMine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Student on 12/6/2016.
 */
public class CannonBarrel extends StationParts{
    private int rotAngle;
    private int length = 30;
    private int width = 14;
    public CannonBarrel(int x, int y, Color theColor, int angle){
        super(x,y,theColor);
        rotAngle = angle;
    }

    public int getRotAngle(){
        return rotAngle;
    }

    public void setRotAngle(int newAngle){
        rotAngle = newAngle;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getShade());
        Rectangle2D  barrel = new Rectangle2D.Double(getxCoord(),getyCoord(), width, length);
        g2.draw(barrel);
        g2.fill(barrel);
    }

}
