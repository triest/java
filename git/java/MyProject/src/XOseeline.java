/**
 * Created by triest on 16.02.2017.
 */
public class XOseeline {

    public static void main(final String[] args){
        final String name1="1";
        final String name2="2";
        final Player[] players=new Player[2];
        players[0]=new Player(name1,Figure.X);
        players[1]=new Player(name2,Figure.O);
        Field field=new Field();
        String gameName="firest game";
        Game game=new Game(players,field,gameName);
        ConsoleView consoleView=new ConsoleView();
        consoleView.show(game);
    }
}
