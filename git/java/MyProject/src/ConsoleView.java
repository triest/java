import Exaption.AllredyOccupadeExaption;
import Exaption.InvalidPointExaption;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by triest on 16.02.2017.
 */
/*
public class ConsoleView {
    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();


    public void show(final Game game){
        final Field field=game.getField();
        System.out.println("Game  "+game.getName());
        for (int x=0;x<=field.getSize();x++){
            if (x!=0)
            printSeparator(field);
            printLine(field,x);
                                }
    }



    public boolean move(final Game game) throws InvalidPointExaption, AllredyOccupadeExaption {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        CurrentMoveController currentMoveController=new CurrentMoveController();
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        if (currentFigure==null){
            final Figure winner1=winnerController.getWinner(field);
            if (winner1==null){
                System.out.println("new vinner");
                return false;
            }
            else {
                System.out.println("winner is"+winner.name());
                return true;}

        }

        System.out.println("Enter coordinate");
        final Point point1=askPoint();
        moveController.applyFigure(field,point,currentFigure);
        try {
            moveController.applyFigure(field,point,currentFigure);
        }catch (InvalidPointExaption|AllredyOccupadeExaption e){
            e.printStackTrace();
            System.out.println("Point is invalid");
        }
    return true;
    }


    private Point askPoint(){
        System.out.println("Input coordinate");
        final Scanner scanner=new Scanner(System.in);
        return new Point(askCoordinate("X")-1,askCoordinate("Y")-1);

    }

    public void printLine(final Field field, int line){
       // System.out.print("|");
        for (int y=0;y<=field.getSize();y++){
            if (y!=0){
                System.out.print("|");
            }
            Figure figure;
            try {
               figure=field.getFigure(new Point(line,y));
            } catch (InvalidPointExaption invalidPointExaption) {
                invalidPointExaption.printStackTrace();
                throw new RuntimeException();
            }

            System.out.print(figure!=null ? figure: " ");
            if (y>0 || y<field.getSize()-1) {
                System.out.print("");
            }
        }
      System.out.println();
    }

    public void printSeparator(final Field field){
        for (int i=0;i<=(int) field.getSize()*2;i++){
            System.out.print("~");
        }
        System.out.println();
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("0_0 olololo!!!!!");
            return askCoordinate(coordinateName);
        }
    }
    }
*/


public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x <field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) throws InvalidPointExaption {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner1(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (final InvalidPointExaption | AllredyOccupadeExaption e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("0_0 olololo!!!!!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y <field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointExaption e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}