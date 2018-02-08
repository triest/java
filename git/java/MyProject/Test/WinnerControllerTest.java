import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by triest on 13.02.2017.
 */
public class WinnerControllerTest {


    @Test
    public void getLineWinner() throws Exception {
        final WinnerController winnerController=new WinnerController();
        final Field field=new Field();
        field.SetFigure(new Point(0,0),Figure.O);
        field.SetFigure(new Point(0,1),Figure.O);
        field.SetFigure(new Point(0,2),Figure.O);
      //  assertEquals(Figure.O,winnerController.getLineWinner(field));
        assertEquals(Figure.O,winnerController.getWinner1(field));
    }




    @Test
    public void getDiagonal1Winner() throws Exception {
        final WinnerController winnerController=new WinnerController();
        final Field field=new Field();
        field.SetFigure(new Point(0,0),Figure.O);
        field.SetFigure(new Point(1,1),Figure.O);
        field.SetFigure(new Point(2,2),Figure.O);
        assertEquals(Figure.O,winnerController.getWinner1(field));
    }

    @Test
    public void getDiagonal2Winner() throws Exception {
        final WinnerController winnerController=new WinnerController();
        final Field field=new Field();
        field.SetFigure(new Point(0,2),Figure.O);
        field.SetFigure(new Point(1,1),Figure.O);
        field.SetFigure(new Point(2,0),Figure.O);
        assertEquals(Figure.O,winnerController.getWinner1(field));
    }


    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field();
               // тестируем все столбцы
        field.SetFigure(new Point(0,0),Figure.O);
        field.SetFigure(new Point(0,1),Figure.O);
        field.SetFigure(new Point(0,2),Figure.O);
        assertEquals(Figure.O, winnerController.getWinner1(field));
    }


    @Test
    public void testGetWinnerWhenNoDiaganal1Row2() throws Exception {
        final WinnerController winnerController=new WinnerController();
        final Field field=new Field();
        field.SetFigure(new Point(0,0),Figure.O);
        field.SetFigure(new Point(1,1),Figure.O);
        field.SetFigure(new Point(0,2),Figure.O);
        //  assertEquals(Figure.O,winnerController.getLineWinner(field));
        assertNull(winnerController.getWinner1(field));
    }


    @Test
    public void testGetWinnerWhenNDiaganal2() throws Exception {
        final WinnerController winnerController=new WinnerController();
        final Field field=new Field();
        field.SetFigure(new Point(2,2),Figure.O);
        field.SetFigure(new Point(1,1),Figure.O);
        field.SetFigure(new Point(2,0),Figure.O);
        //  assertEquals(Figure.O,winnerController.getLineWinner(field));
        assertNull(winnerController.getWinner1(field));
    }




    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

            final Field field = new Field();
            field.SetFigure(new Point(0, 0), Figure.X);
            field.SetFigure(new Point(1, 0), Figure.X);
            field.SetFigure(new Point(2, 1), Figure.O);
            assertNull(winnerController.getWinner1(field));

    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field();
        field.SetFigure(new Point(0, 0), Figure.X);
        field.SetFigure(new Point(1, 1), Figure.X);
        field.SetFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner1(field));
    }
/*
    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field();
        field.SetFigure(new Point(0, 0), Figure.X);
        field.SetFigure(new Point(1, 1), Figure.X);
        field.SetFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }
*/
    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field();
        field.SetFigure(new Point(0, 2), Figure.X);
        field.SetFigure(new Point(1, 1), Figure.X);
        field.SetFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner1(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field();
        field.SetFigure(new Point(0, 2), Figure.X);
        field.SetFigure(new Point(1, 1), Figure.X);
        field.SetFigure(new Point(2, 1), Figure.O);
        assertNull(winnerController.getWinner1(field));
    }


}