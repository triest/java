import Exaption.InvalidPointExaption;

//import java.lang.reflect.*;
//import java.lang.reflect.Field;

/**
 * Created by triest on 13.02.2017.
 */


public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++)
                if ( check(field, new Point(i, 0), p -> new Point(p.X, p.Y + 1)) )
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < 3; i++)
                if ( check(field, new Point(0, i), p -> new Point(p.X + 1, p.Y)) )
                    return field.getFigure(new Point(0, i));

            if ( check(field, new Point(0, 0), p -> new Point(p.X + 1, p.Y + 1)) )
                return field.getFigure(new Point(0, 0));

            if ( check(field, new Point(0, 2), p -> new Point(p.X + 1, p.Y - 1)) )
                return field.getFigure(new Point(1, 1));

        } catch (final InvalidPointExaption e) {
            e.printStackTrace();
        }
        return null;
    }


    public Figure getWinner1(final Field field) {

        Figure win =getLineWinner(field);
        Figure win2=getRowWinner(field);
        Figure win3=getDiagonalWinner(field);

        if (win!=null){
            return win;
        }else {
            if(win2!=null){
                return win2;
            }
            else {
                if ( win3 != null ) {
                    return win3;
                }
            }
        }
        return null;
    }

    public Figure getRowWinner(final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if ( (field.getFigure(new Point(1, i)) == field.getFigure(new Point(2, i))) && (field.getFigure(new Point(1, i)) == field.getFigure(new Point(3, i)))&&((field.getFigure(new Point(1,i))==Figure.X)||field.getFigure(new Point(1,i))==Figure.O)) {
                    return field.getFigure(new Point(i, 0));
                }
            }
        } catch (final InvalidPointExaption e) {
            e.printStackTrace();
        }
        return null;
    }

    public Figure getLineWinner(final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if ( (field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 1))) && (field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 2))) ) {
                    return field.getFigure(new Point(i, 0));
                }
            }
        } catch (final InvalidPointExaption e) {
            e.printStackTrace();
        }
        return null;
    }

    public Figure getDiagonalWinner(final Field field){
        try {
            if(field.getFigure(new Point(0,0))==field.getFigure(new Point(1,1))&&field.getFigure(new Point(2,2))==field.getFigure(new Point(0,0))&&((field.getFigure(new Point(0,0))==Figure.X)||field.getFigure(new Point(0,0))==Figure.O)){
                return field.getFigure(new Point(0,0));
            }
            if(field.getFigure(new Point(0,2))==field.getFigure(new Point(1,1))&&field.getFigure(new Point(2,0))==field.getFigure(new Point(0,2))&&((field.getFigure(new Point(0,2))==Figure.X)||field.getFigure(new Point(0,2))==Figure.O)){
                return field.getFigure(new Point(0,2));
            }
        }catch (final InvalidPointExaption e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean check(final Field field,
                         final Point currentPoint,
                         final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if ( currentFigure == null )
                return false;

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointExaption e) {
            return true;
        }

        if ( currentFigure != nextFigure )
            return false;

        return check(field, nextPoint, pointGenerator);
    }

    public interface IPointGenerator {
        Point next(final Point point);
    }

}