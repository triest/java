import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by triest on 25.05.2017.
 */
public class VoitingSystem {
    public ArrayList<User> users;
    public Voiting currentVoiting;
    public User corrrentUser;


    public VoitingSystem(ArrayList<User> users) {
        this.users = users;
    }

    public VoitingSystem() {
      users=new ArrayList<>();
    }

    public void addUser(String name, String login, String password){
        User user=new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int Index) {
        return users.get(Index);
    }



    public void addCandidate(String name){
        Candidate candidate=new  Candidate(name);
        candidate.setName(name);

    }


    public User findUser(String login,String password){
        Integer index=Arrays.asList(users).indexOf(login);
       if (index!=-1){
           // если логин есть, то найдем пароль
           index=Arrays.asList(users).indexOf(login);
           if (users.get(index).getPassword().equals(password)){
               return users.get(index);
           }
       }
        return null;
    }

    //ищет пользователя по логинуи паролю
    public User findUser2(String login,String password){
        for (User user:users) {
            if ((user.getLogin().equals(login))&&(user.getPassword().equals(password))){
                return user;
            }
        }
        return null;
    }

    public void getResults(){

    }


    public void creatCandidate(WorkVitchCandidate workVitchCandidate,VoitingSystem voitingSystem){
        String ansver="";
        Scanner in=new Scanner(System.in);

        while (!ansver.equals("n")){
            System.out.println("Continion?");
            ansver=in.nextLine();
        }
    }

    public  void mainLoop(String[] args) {
       WorkVitchUser workVitchUser=new WorkVitchUser();
       WorkVitchCandidate workVitchCandidate=new WorkVitchCandidate();
       VoitingSystem voitingSystem=new VoitingSystem();
       this.creatCandidate(workVitchCandidate,voitingSystem);


        System.out.println("user.lastIndexOf "+users.lastIndexOf(users)); //не заносяться в массив users
        for (int i=0;i<users.lastIndexOf(users);i++){
           System.out.println("Name:" +users.get(i).getName());
            System.out.println("Login:" +users.get(i).getLogin());
            System.out.println( "Pass"+ users.get(i).getPassword());
        }



    //   workVitchUser.creatUser(voitingSystem);
        System.out.println("End");
        System.out.println();
    }

 // подучаем результату голосования
    public List getResult(){
        System.out.println("Resylt:");
        for (final Candidate candidate:currentVoiting.candidates){
           System.out.println(candidate.getVoices());
        }

        return null;
    }
}
