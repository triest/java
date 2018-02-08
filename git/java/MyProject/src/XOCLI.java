import Exaption.AllredyOccupadeExaption;
import Exaption.InvalidPointExaption;

/**
 * Created by triest on 17.02.2017.
 */
public class XOCLI {

    public static void main(final String[] args) throws InvalidPointExaption, AllredyOccupadeExaption {

        final String player1="12";
        final String player2="14";
        final Player[] player=new Player[2];
        player[0]=new Player(player1,Figure.X);
        player[1]=new Player(player2,Figure.O);

        final Game gameXO=new Game(player,new Field(),"FirstGame");
         ConsoleView consoleView=new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }


    }
}
