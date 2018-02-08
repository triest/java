import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by triest on 04.06.2017.
 */
class VoitingTest {
    @Test
    void getCandudate() {
        Voiting voiting=new Voiting();

        voiting.setTitle("Vibor 2018");
        voiting.addCandidate2("Putin");
        voiting.addCandidate2("Medvedev");
     //   System.out.println(voiting.getCandudate("Putin"));
   assertEquals("Putin",voiting.getCandudate("Putin"));
    }

}