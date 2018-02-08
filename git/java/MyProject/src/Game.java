/**
 * Created by triest on 13.02.2017.
 */
public class Game {
    public Player[] players;
    public Field field;
    public String name;

    public Game(Player[] players, Field field, String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlaeyr(){
        return players;
    }

    public  Field getField(){
        return field;
    }

    public String getName(){
        return name;
    }
}
