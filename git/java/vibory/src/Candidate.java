/**
 * Created by triest on 25.05.2017.
 */

public class Candidate extends Voiting{

    private String name;
    private int voite=0;

    public Candidate() {

    }

    public int getVoite() {
        return voite;
    }

    public void setVoite(int voite) {
        this.voite = voite;
    }

    public Candidate(String name) {
        this.name = name;
        this.voite=0;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addVoice(){
        this.setVoite(this.getVoices()+1);
    }

    public int getVoices() {
        return voite;
    }
}
