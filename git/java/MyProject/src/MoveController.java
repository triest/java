import Exaption.AllredyOccupadeExaption;
import Exaption.InvalidPointExaption;


/**
 * Created by triest on 13.02.2017.
 */
public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointExaption, AllredyOccupadeExaption {
        if (field.getFigure(point) != null) {
            throw new AllredyOccupadeExaption();
        }
        field.SetFigure(point, figure);
    }
}


