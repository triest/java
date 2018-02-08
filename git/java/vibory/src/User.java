/**
 * Created by triest on 25.05.2017.
 */
public class User {

    private String name;
    private String login;
    private String password;
    private boolean voited;
    public User() {
       voited=false;
    }

    public boolean isVoited() {
        return voited;
    }

    public void setVoited(boolean voited) {
        this.voited = voited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        //обрезаем пробелы
        password.trim();
        return password;
    }

    public void setPassword(String password) {
        //обрезаем пробелы
        password.trim();
        this.password = password;
    }


  //вначале finfUser, затем Enter;
    public boolean enter(String login,String password){
       if((login==this.getLogin()&&(password==this.getPassword()))){
           return true;
        }
        else {return false;}
    }

    public String getName() {
        return this.name;
    }
}
