package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main {

    /**
     * @param args the command line arguments
     */

    static double V (double p) {
        double vo;
        vo=(2.5-(p*2))*(2-(p*2))*p;  //проверенно
        return vo;
    }




    public static void main(String[] args) {

        double a=0;
        double b=1;
        double dif=0.001;
        double eps=0.001;
        double max=0;

        //double min=10000;
        double[] mas=new double[2000];//массив значений независемой переменной
        double[] fun=new double[2000];//массив функции
        int size=2000;




        do{

      for(int i=0;i<size;i++)//
        {
            mas[i]=Math.random() * ( b - a )+a;
        }
        for(int i=0;i<size;i++)
        {
            fun[i]=V(mas[i]);
        }



               double x_optimal=0;
            //поиск максимальных
            for (int i=0;i<size;i++){
                if (fun[i]>max){
                    max=fun[i];
                    x_optimal=mas[i];
                }
                 double l;
                 l=(b-a)*0.9;

                  a=x_optimal-l/2;
                  b=x_optimal+l/2;
                dif=b-a;
            }
        } while(dif>eps);

           System.out.println("P: "+a+" м");
           System.out.println("max V:"+max+" м^3");

    }
}



