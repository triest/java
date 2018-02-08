import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by triest on 25.05.2017.
 */
public class Voiting extends VoitingSystem{

   private String title;

    public ArrayList<Candidate> candidates;
        public Voiting voiting;



    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {

    }


    //тут будет функция, ищущая обьект в массиве по имени и добаляющая голос
    public void AddVoiceByName(String name){
        Integer index=this.GetIndexByCandidateName(name); //получаем индекс кандидата
        if (index!=null) {
            candidates.get(index).addVoice();
        }
    }


    // возвражает имя кандидата
    public String getCandudate(String name){
        for (Candidate candidate:candidates){
           if (candidate.getName().equalsIgnoreCase(name)){
             return candidate.getName();
           }
        }
        return null;
    }

    //тут бы индекс кандидата получить
    public Integer getIndexCandudate(String name){
   //     return candidates.indexOf(candidate.)
        return null;
    }

    //получаем обьект по индексу
    public Candidate getCandidateByIndex(Integer index){
       return candidates.get(index);
    }

    //возвращает номер в массиве, где находиться этот элемент
    public Integer GetIndexByCandidateName(String name){
        for (Candidate candidate:candidates){
            if (candidate.getName().equalsIgnoreCase(name)){
                return candidates.indexOf(candidate);
            }
        }
        return null;
    }



    public void addCandidate2(String CandidateName){
        Candidate candidate=new Candidate(CandidateName);
        candidate.setName(CandidateName);
          candidates.add(candidate); //нужен конструктор списка кандидатов
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public  Voiting(){
        this.candidates=new ArrayList<Candidate>();

    }

    public void Voiting2(String title){
        candidates=new ArrayList<>();
        int count=1;
        System.out.println("Voiting "+title);
        System.out.println("Candidate list to voiting:");
          for (Candidate candidate:candidates){
              System.out.println();
              System.out.print(count+".");
              System.out.print(candidate);
              count++;
          }
        while (true) {
          System.out.println("Enter number you candidate:");
          Scanner in = new Scanner(System.in);
          String ansver = in.nextLine();
          Integer ansverInt = Integer.parseInt(ansver);
           ansverInt = ansverInt - 1;

            if (ansverInt >= 0 && ansverInt < candidates.size()) {
              Candidate tempCandidate = candidates.get(ansverInt);
             tempCandidate.addVoice();
             candidates.set(ansverInt, tempCandidate);
             break;
            } else {
                  System.out.println("Wrong number");
               }
            }
    }
}
