package sample;

import javax.swing.*;
public class Main {

    public double Pi(int n){}


    public static void main(String[] args) {



        calc field=new calc();
        int sizeX=40;
        int sizeY=20;
        double E1=100;
        double E2=200;
        JOptionPane.showMessageDialog(null, "HELLO WORLD");
     //   field.filling(sizeX,sizeY,E1,E2);
     //   field.calculate2();
        System.out.println("После расчета");
   //     field.ShowField();
        MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //окно видемо
     //      System.out.println("Число итераций:"+field.calculate());

    }
}