import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by triest on 28.05.2017.
 */
class UserTest {
    @Test
    void enter() {

    }

    @Test
    void setName() {
        User user=new User();
        String name="Name";
        user.setName(name);
        assertEquals(user.getName(),name);
    }

    @Test
    void setLogin() {
        User user=new User();
        String login="!@#$$%%%LLD<<XS";
        user.setLogin(login);
        assertEquals(login,user.getLogin());
    }

    @Test
    void setPassword() {
        User user=new User();
        String password="22dsssf5466d";
       user.setPassword(password);
        VoitingSystem voitingSystem=new VoitingSystem();
        voitingSystem.addUser("a","v",password);
        assertEquals(user.getPassword(),password);
    }
    @Test
    void UserInArray(){
        WorkVitchUser workVitchUser=new WorkVitchUser();
        VoitingSystem voitingSystem=new VoitingSystem();
        voitingSystem.addUser("a","b","c");
        voitingSystem.addUser("d","c","e");
        assertEquals(voitingSystem.getUsers().get(0).getName(),"a");
        assertEquals(voitingSystem.getUsers().get(0).getLogin(),"b");
        assertEquals(voitingSystem.getUsers().get(0).getPassword(),"c");
        assertEquals(voitingSystem.getUsers().get(1).getName(),"d");
        assertEquals(voitingSystem.getUsers().get(1).getLogin(),"c");
        assertEquals(voitingSystem.getUsers().get(1).getPassword(),"e");
    }

    @Test
    void SearchUser2(){
        VoitingSystem voitingSystem=new VoitingSystem();
        voitingSystem.addUser("a","b","c");
        User user=voitingSystem.findUser2("b","c");
        String ine="a";

           assertEquals(user.getName(),voitingSystem.getUser(0).getName());
    }


}