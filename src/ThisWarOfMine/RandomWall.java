package ThisWarOfMine;

import java.awt.*;

/**
 * Created by Student on 11/29/2016.
 */
//TODO Javadoc
public class RandomWall extends StationParts {
    private int height;
    private int width;
    public RandomWall(int x, int y, Color aColor, int w, int h){
        super(x,y,aColor);
        width = w;
        height = h;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getShade());
        Rectangle obstacle = new Rectangle(getxCoord(),getyCoord(), width, height);
        g2.draw(obstacle);
        g2.fill(obstacle);
    }

}
