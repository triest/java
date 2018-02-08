import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;



/**
 * Created by triest on 12.02.2017.
 */
public class Task_test {

    // тест метода, увеличивающего заданный элемент на единицу
    @Test
    public void array() throws Exception {
        double[] mass={1,2,3,4,5};
        double[] mass1={1,2,3,4,6};
        Tasks point=new Tasks();
       Arrays.equals(mass,mass1);

    }
// тест метода, считающего расстояние до молнии.
    @Test
    public void molnia() throws Exception{
        Tasks point=new Tasks();
          double time=7.2;
          double range=7.2*1100;
        assertEquals(range, point.molnia(time),0);
    }


    //



}