import Exaption.InvalidPointExaption;

/**
 * Created by triest on 15.02.2017.
 */
public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointExaption {

        int countX=0;
        int countO=0;
        for (int i = 0; i <field.getSize(); i++){
               for (int j=0;j<field.getSize();j++) {
                   if ( field.getFigure(new Point(i, j)) == Figure.O ) {
                       countO++;
                   }
                   else {
                       if ( field.getFigure(new Point(i, j)) == Figure.X ) countX++;
                   }
               }
            }

        if (countX+countO==field.getSize()*field.getSize()) {
            return null;
        }
        if (countX<=countO){return Figure.X;}
            else {return Figure.O;}

    }
/*
    final int countFigureInTheRow(final Field field,int row) throws InvalidPointExaption {
            int CountFigure=0;
        for (int j=0;j<field.getSize();j++){
            //   Point point=new Point(i,j);
            if (field.getFigure(new Point(row,j))!=null){
                CountFigure++;
            }
    }
        return CountFigure;
    }*/
}
