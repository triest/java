package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Field {
    public char[][] field;
    public  int size=4;
    private static int def=2;
    public int x=0;
    public int y=0;
    Scanner sc = new Scanner(System.in);
    public Field(int size){

       field=new char[size][size];
    }
    public void doSize(){
        boolean razm;
        razm=true;
        do {
        System.out.println("Введите размер");
        if(sc.hasNextInt()){
            size=sc.nextInt();
            razm=true;
        }
         else{
            System.out.println("Введнено некоректное число");
            razm=false;
        }
        } while(razm==false);
    }

    public Field(){

        field=new char[size][size];

    }

    public  void ShowField(){
          System.out.print("y/x");
          for (int i=0;i<=size;i++){
              System.out.print("  "+i+" ");
          }

         for (int i=0;i<=size-1;i++){
             System.out.println();
             System.out.print(i);
           for (int j=0;j<=size-1;j++){
            System.out.print("  ["+field[i][j]+"]");
           }
         }
          System.out.println();
       }

    public char plaseXY(boolean player){
        boolean correct=true;


        boolean plase=true;
        ShowField();

        do  {
            if (player==true){System.out.println("Ходят x");}
            else{
                System.out.println("Ходят 0");
            }
    do {
      System.out.println("Введите Y");
       x=sc.nextInt();
          if (x<0 | x>size-1){
             System.out.println("Некоректное число");
              correct=false;
              }
              else {correct=true;}

       }while (correct==false);

     do {
       System.out.println("Введите X");
       y=sc.nextInt();
            if (y<0 | y>size-1){
                System.out.println("Некоректное число");
                 correct=false;
            }
              else {correct=true;}
     }while (correct==false);

           if (field[x][y]=='x'||field[x][y]=='o'){plase=false;
               }
              else{
               plase=true;
            }



            if (plase==true){
                 if(player==true)     {
                     field[x][y]='x'; }
                 else{
                     field[x][y]='o';
                 }
            }
            else { System.out.println("Клетка занята");}
            int i=0;

        }
         while (plase==false);

        return(field [x][y]);



    }
    public boolean vin(char x_Or_0){

         boolean vin=false;
         //для центральных
         for (int j=1;j<size-1;j++){
             for (int i=1;i<size-1;i++){

                 if(field[i + 1][j] == x_Or_0 && field[i - 1][j] == x_Or_0 && field[i][j] == x_Or_0||
                         field[i][j + 1] == x_Or_0 && field[i][j + 1]  == x_Or_0 && field[i][j] == x_Or_0 ||
                         field[i - 1][j + 1] == x_Or_0 && field[i + 1][j - 1] == x_Or_0 && field[i][j] == x_Or_0 ||
                         field[i - 1][j - 1] == x_Or_0 && field[i + 1][j + 1] == x_Or_0 && field[i][j] == x_Or_0) vin=true;
             }
         }


         // для крайних  горизонтальных
          //для верхней горизонтали
                      int i=0;
            for (int j=1;j<size-1;j++){
                 if (field[i][j+1] == x_Or_0 && field[i][j-1] == x_Or_0 && field[i][j]==x_Or_0){vin=true;}
            }

            //для нижней горизонтали
          i=size-1;
         for (int j=1;j<size-1;j++){
             if (field[i][j+1] == x_Or_0 && field[i][j-1] == x_Or_0 && field[i][j]==x_Or_0){vin=true;}
         }

         // для левой вертикали
          int j=0;
           for (i=1;i<size-1;i++){
               if (field[i+1][j] == x_Or_0 && field[i-1][j] == x_Or_0 && field[i][j]==x_Or_0){vin=true;}
           }

         // для правой вертикали

           j=size-1;
         for (i=1;i<size-1;i++){
             if (field[i+1][j] == x_Or_0 && field[i-1][j] == x_Or_0 && field[i][j]==x_Or_0){vin=true;}
         }

         return (vin);
     }
    public void plaseX(){
        System.out.println("введите число x для X");
        x=sc.nextInt();
        System.out.println("введите число y для Х");
        y=sc.nextInt();
       field[x][y]='x';
    }
    public void plaseO(){
        System.out.println("введите число x для 0");
        x=sc.nextInt();
        System.out.println("введите число y для 0");
        y=sc.nextInt();
        field[x][y]='o';
    }


    public void show(){
        System.out.println("введите число x");
        x=sc.nextInt();
        System.out.println("введите число y");
        y=sc.nextInt();
        System.out.println(field[x][y]);
    }
}