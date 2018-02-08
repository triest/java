import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by triest on 03.06.2017.
 */
class VoitingSystemTest {
    @Test
    void findUser() {
    }

    @Test
    void findUser2() {
        VoitingSystem voitingSystem=new VoitingSystem();
        voitingSystem.addUser("2","d","c");
        voitingSystem.addUser("f","g","s");
        User testUser=voitingSystem.findUser2("d","c");
        assertEquals("2",testUser.getName());
    }


    @Test
    void addUser() {
        VoitingSystem voitingSystem=new VoitingSystem();
        voitingSystem.addUser("2","d","c");
        voitingSystem.addUser("f","g","s");

        assertEquals(voitingSystem.getUser(0).getName(),"2");
    }



}