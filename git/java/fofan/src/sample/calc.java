package sample;
import java.util.Scanner;
import java.lang.Math;

public class calc {
    public double[][] E;
    public double[][] ebf2;
    public double[][] ebf1;
    public  int size=4;
    private static int def=2;
    public int x=0;
    public int y=0;

    private boolean endCick=true;
    Scanner sc = new Scanner(System.in);
     int SizeX=40;
     int SizeY=10;
     double s1=0;
     double s2=0;

    public calc(){
       E=new double[40][20];
    }
    public  void filling(int SizeX,int SizeY,double E1,double E2){
         for (int x=0;x<SizeX/2;x++){
             for ( y=0;y<SizeY-1;y++){
                 E[x][y]=E1;
             }
         }

         for(x=SizeX/2;x<SizeX-1;x++){
             for (int y=0;y<SizeY-1;y++){
                E[x][y]=E2;
             }

         }


    }

    public void ShowField(){

        for (int y=0;y<SizeY;y++){
                System.out.println(" ");
              for (int x=0;x<SizeX-1;x++){
                  System.out.print(Math.round(E[x][y])+"! ");

              }


        }
        System.out.println(" ");
    }

    public int calculate(){
        endCick=false;
        int shethich=0;
       double[][] pred1=new double[SizeX][SizeY];
        double[][] pred2=new double[SizeX][SizeY];
      //  double s1=0.01;
        do {
        double dr=0.01;    // для крайних
         for (int y=1;y<4;y++){
             for (int x=1;x<SizeX-2;x++){
                  pred2[x][y]=pred1[x][y];
                  pred1[x][y]=E[x][y];
                 E[x][y]=(E[x-1][y]*(1-dr/(2*dr*(5-y)))+E[x+1][y]*(1+dr/(2*dr*(5-x)))+E[x][y-1]+E[x][y+1])/4;

             }

             for (int x=0; x<SizeX;x++){

                 E[x][9]=E[x][1];
                 E[x][8]=E[x][2];
                 E[x][7]=E[x][3];
             }




         }
         //для центральных
         for (int y=4;y<=6;y++){
             for (int x=1;x<SizeX-2;x++){
             E[x][y]=(E[x-1][y]+E[x+1][y]+E[x][y-1]+E[x][y+1])/4;
             }
         }

        //cчитаем S
         for (int y=1;y<SizeY;y++){
             for(int x=1;x<SizeX;x++){

                 s2=Math.pow((pred1[x][y]-pred2[x][y]),2)+s2;
             }
         }
        double dfi=Math.sqrt(s1/s2);

        if (dfi>0.9) {endCick=true;  }

            else{endCick=false;
            s1=s2;}

            shethich=shethich+1;
            System.out.println(s2);

       } while (endCick==false);
        return shethich;
    }


    public void calculate2(){
                        boolean endCi=false;
        ebf1 =new double[40][20];
        ebf2 =new double[40][20];
        double dr=0.01;
       int iter=0;  //
       double s1=0.0000001;
        double dfi;
        //считаем крайние точки
        do{
            iter=iter+1;
            for (int y=1;y<=4;y++){
                for (int x=1;x<=SizeX-3;x++){
                    ebf2[x][y]=ebf1[x][y];
                    ebf1[x][y]=E[x][y];
                    double tmp=(E[x-1][y]*(1-dr/(2*dr*(5-y)))+E[x+1][y]*(1+dr/(2*dr*(5-y)))+E[x][y-1]+E[x][y+1])/4;
                    E[x][y]=tmp;
                }
            }

            // копируем крайние точки
            for (int x=0;x<=39;x++){
                E[x][9]=E[x][1];
                E[x][8]=E[x][2];
                E[x][7]=E[x][3];
            }

            //среднии точки
            for (int y=4;y<=6;y++){
                for (int x=1;x<=SizeX-3;x++){
                    ebf2[x][y]=ebf1[x][y];
                    ebf1[x][y]=E[x][y];
                    E[x][y]=(E[x-1][y]+E[x+1][y]+E[x][y-1]+E[x][y+1])/4;
                }
            }

           //условие выхода

            for (int y=1;y<=SizeY-1;y++){
                for (int x=1;x<39;x++){
                     s2=(ebf1[x][y]-ebf2[x][y])*(ebf1[x][y]-ebf2[x][y])+s2;
                }
            }
          dfi=Math.sqrt(s1/s2);
            if (dfi>0.999999) {endCi=true; }
               else {endCi=false;}

                 s1=s2;

        }while(endCi==false);
            System.out.println("Число итераций: "+iter);
    }


}
