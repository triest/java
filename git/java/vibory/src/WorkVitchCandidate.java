import java.util.Scanner;
/**
 * Created by triest on 26.05.2017.
 */
public class WorkVitchCandidate {
    public void creatCandidate(VoitingSystem voitingSystem){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя кандидата");
        String name=in.nextLine();
        voitingSystem.addCandidate(name);

    }
}
