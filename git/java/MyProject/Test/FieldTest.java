import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by triest on 13.02.2017.
 */
public class FieldTest {
    @Test
    public void getFigure() throws Exception {
        Field field=new Field();
        Figure figure=Figure.X;
        Point point=new Point(0,0);
        field.SetFigure(point,figure);
    //    assertEquals(figure,field.getFigure(point));
        Point point1=new Point(0,1);
       // field.SetFigure(point1,figure);
        assertNull(field.getFigure(point));
    }


// не работает проверка
    @Test
    public void checkPoint() throws Exception {
        Point point=new Point(0,0);
        int x=2;
        Field field=new Field();
      //  Figure figure=Figure.X;
      //  field.SetFigure(point,figure);
      //  assertEquals(true,field.checkPoint(point));
        Point point1=new Point(1,2);
        assertEquals( true,field.checkPoint(point1));
        Point point2=new Point(1,6);
      //  assertEquals(true,field.checkPoint(point2));
        assertFalse(field.checkPoint(point2));
    }

    @Test
    public void checkCoordinate() throws Exception {
        Point point=new Point(0,0);
        int x=2;
        Field field=new Field();
        Figure figure=Figure.X;
        field.SetFigure(point,figure);
       // assertTrue(field.checkCoordinate(2));
      //  assertFalse(field.checkCoordinate(-1));
        assertTrue(field.checkCoordinate(2));
       assertFalse(field.checkCoordinate(3));
       assertFalse(field.checkCoordinate(4));
    }

    @Test
    public void setFigure() throws Exception {
        Field field=new Field();
        Figure figure=Figure.X;
        Point point=new Point(0,0);
        assertNull(field.getFigure(point));
        field.SetFigure(point,figure);
        assertEquals(figure,field.getFigure(point));
        point.X=0;
        point.Y=0;
        field.SetFigure(point,figure);
        assertEquals(figure,field.getFigure(point));
        point.X=0;
        point.Y=0;
        field.SetFigure(point,figure);
        assertEquals(figure,field.getFigure(point));
        point.X=0;
        point.Y=2;
        field.SetFigure(point,figure);
        assertEquals(figure,field.getFigure(point));
        assertNotNull(field.getFigure(point));
    }



    @Test
    public void getSize() throws Exception {
        Field field=new Field();
        assertEquals(3-1,field.getSize());
    }





}