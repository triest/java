import java.util.List;

/**
 * Created by triest on 25.05.2017.
 */
public class Elector extends User{

 List candidats;

  private   boolean voited;
Voiting voiting;

    public boolean isVoited() {
        return voited;
    }

  public void setVoited(boolean voited) {
    this.voited = voited;
  }

  public void vote(String title,List candidats){
       //надо запросить за кого голосует, добавить + тому кандидвту, и поставить voited true
       setVoited(true);
       String titleVoitong="Examplr";
       System.out.println("Список кандидатов:");

       //тут будем выводить список кандидатов
      //voiting.Voiting();
    }

}
