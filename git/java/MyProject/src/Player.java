/**
 * Created by triest on 13.02.2017.
 */

import java.io.*;

public class Player {

    private  String name;

    public Figure figure;

    public Player(String name, Figure figure) {
        this.name=name;
        this.figure=figure;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Figure getFigure(){
        return figure;
    }
}
