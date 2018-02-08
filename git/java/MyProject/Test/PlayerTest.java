import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.*;

import static org.junit.Assert.*;

/**
 * Created by triest on 13.02.2017.
 */
public class PlayerTest {
    @Test
    public void getName() throws Exception {

        String value="Jon";
        Player player=new Player(value,null);
        assertEquals(value,player.getName());

    }

    @Test
    public void getFigure() throws Exception{
        final Figure input=Figure.X;
        final Figure extendValue=input;
        Player player=new Player("Jon",input);
        assertEquals(extendValue,player.getFigure());

    }

}