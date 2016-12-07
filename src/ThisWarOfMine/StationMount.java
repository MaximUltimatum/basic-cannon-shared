package ThisWarOfMine;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Student on 11/29/2016.
 * Is used to create a mount. Right and left designated by object maker
 */
//TODO Javadoc
public class StationMount extends StationParts {
    private int width;
    private int height;
    public StationMount(int x, int y, Color aColor, int w, int h){
        super(x,y,aColor);
        width = w;
        height = h;
    }


    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getShade());
        Ellipse2D mount = new Ellipse2D.Double(getxCoord(),getyCoord(), width, height);
        g2.draw(mount);
        g2.fill(mount);
    }
}
