package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        MyWindowApp window=new MyWindowApp();

         window.main2();






        boolean player=false ;
        Field field=new Field();
        boolean Vin=false;
        char x_Or_0;



        do {
       // field.ShowField();
         if (player==true){x_Or_0='x';}
             else {x_Or_0='o';}

        field.plaseXY(player);
         Vin=field.vin(x_Or_0);
            //смена игрока

          if (player==true){player=false;}
             else { player=true;

          }


        } while (Vin==false);
        field.ShowField();
           System.out.println("Игра окончена");
         if (player=false){System.out.println("Победили крестики");}
             else {System.out.println("Победили нолики");}
        }



    }
