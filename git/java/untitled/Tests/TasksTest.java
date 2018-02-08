import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by triest on 12.02.2017.
 */
public class TasksTest {
    @Test
    public void reverse() throws Exception {
         String str1="ab";
         String str2="ba";
        Tasks point=new Tasks();
         assertEquals(str1,point.reverse(str2));
    }

    @Test
    public void averange() throws Exception {
        int[] mass2={2,3,4,5,6};
        Tasks point=new Tasks();
        double ecp=4;
        assertEquals(ecp,point.Averange(mass2),0);
    }

}
user-6f68bfce3eef2f8a