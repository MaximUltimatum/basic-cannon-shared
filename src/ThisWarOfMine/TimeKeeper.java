package ThisWarOfMine;

import java.sql.Time;

/**
 * Created by Student on 12/6/2016.
 * Class currently unused. Instead using timer in wait loop in warpainter
 * @see WarPainter
 */
public class TimeKeeper {
    private long startTime;
    public TimeKeeper(){
        startTime = System.nanoTime();
    }

}
