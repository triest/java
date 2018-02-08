/**
 * Created by triest on 13.02.2017.
 */
import Exaption.InvalidPointExaption;

public class Field {
    private static int Fild_size=4; //устанавливаем размер массива
    public final Figure[][]field=new Figure[Fild_size][Fild_size]; // создаем массив
   // public static int Max_coordinate=Fild_size;
    public static int Min_coordinate=0;
    public Field() {

    }

    // получаем размер поля
    public static int getSize(){
        return Fild_size-1;
    }

        //возвращаем фигуру на поле
        public Figure getFigure(Point point)throws InvalidPointExaption{
            if (!checkPoint(point)){
                throw new InvalidPointExaption();
            }
            return field[point.X][point.Y];
        }

        // устанавливаем фигуру в полк
        public void SetFigure(final Point point,final Figure figure) throws InvalidPointExaption {
            if (checkPoint(point)==false) {
               throw new InvalidPointExaption();
            }/*
            if (field[point.X][point.Y]!=null){
                throw new  AllredyOccupadeExaption();
            }*/
            field[point.X][point.Y]=figure;
        }


    // проверяем точку
        public boolean checkPoint(final Point point){
           // return checkCoordinate(point.X)&&checkCoordinate(point.Y);
            if (point.X>=Min_coordinate & point.X<field.length & point.Y>=Min_coordinate & point.Y<=field.length){return true;}
            else {return false;}

        }

        public boolean checkCoordinate(final int coordinate){
            return coordinate>=Min_coordinate && coordinate<=field.length-1;
        }



}
