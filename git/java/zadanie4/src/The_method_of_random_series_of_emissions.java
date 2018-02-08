/**
 * Created by Sergy on 18.12.2014.
 */
public class The_method_of_random_series_of_emissions {

    private static final double[]lamda  = {0.4, 0.6, 0.9, 1.0, 1.4, 1.8, 2.1, 2.3, 2.6, 2.9};
    private static final double[] A  = {0.01, 0.06, 0.16, 0.23, 0.98, 1.82, 1.98, 1.62, 0.99, 0.37};

    private double[] massiv_lamda_0;
    private double[] massiv_A_0;
    private double[] massiv_sigma;

    private double[] A_new;
    private double[][][] W;
    private double[] accuracy;

    private double A_perm;
    private double W_perm;
    int i;int i_2;int i_3;
    int i_cor;int i_2_cor;int i_3_cor;

    double L;

    void function_A_new(double A_0, double lamda,double lamda_0, double sigma){
        A_perm = A_0*Math.exp((-1)*(lamda-lamda_0)*(lamda-lamda_0)/sigma);
    }

    void function_W(double A_0, double lamda_0, double sigma){
        W_perm=0;
        for (i = 0; i < 10; i++){
            this.function_A_new(A_0,lamda[i],lamda_0,sigma);
            W_perm=W_perm+(A_perm-A[i])*(A_perm-A[i]);
        }
    }

    void myMain(){
        massiv_lamda_0 = new double[100];
        massiv_A_0 = new double[100];
        massiv_sigma = new double[100];
        W=new double[100][100][100];
        accuracy=new double[100];

        double e=0.001;
        double a=0.001;
        double b=100;
        double W_min=100;
        int number_of_iterations=0;

        while (W_min>=e){
            //System.out.println( (int)(Math.random()*5+3) ); // целое число из [3;7]
            for (i = 0; i < 10; i++){//генерация случайных значений для A0, lamda0 и σ;
                massiv_A_0[i]=(int)(Math.random()*(a-b)+b);
                massiv_lamda_0[i]=(int)(Math.random()*a-b+b);
                massiv_sigma [i]=(int)(Math.random()*a-b+b);
            }
            for (i=0; i<100; i++) {        //заполнение массива W;
                for (i_2=0; i_2<100; i_2++) {
                    for (i_3=0; i_3<100; i_3++){
                        this.function_W(massiv_A_0[i],massiv_lamda_0[i_2],massiv_sigma[i_3]);
                        W[i][i_2][i_3]=W_perm;
                    }
                }
            }
            W_min=W[0][0][0];
            for (i=0; i<100; i++) {        //поиск минимального W
                for (i_2=0; i_2<100; i_2++) {
                    for (i_3=0; i_3<100; i_3++){
                        if (W_min>W[i][i_2][i_3]){
                            W_min=W[i][i_2][i_3];
                            i_cor=i;       //определение координат массива;
                            i_2_cor=i_2;
                            i_3_cor=i_3;
                        }
                    }
                }
            }
            L=0.9*(b-a);
            a=massiv_A_0[i_cor]-L/2;
            b=massiv_A_0[i_cor]+L/2;
            number_of_iterations++;
        }
        System.out.println("Variable |  Value");
        System.out.println("W        "+W[i_cor][i_2_cor][i_3_cor]);
        System.out.println("A0       "+ massiv_A_0 [i_cor]);
        System.out.println("Lambda0"+massiv_lamda_0[i_2_cor]);
        System.out.println("Sigma"+massiv_sigma[i_3_cor]);
        System.out.println("Number_of_iterations:"+number_of_iterations);
    }

}




  /*for (i=0; i<10; i++) {           //вычисление процента точности;
            this.function_A_new(massiv_A_0[i_cor], lamda[i] ,massiv_lamda_0[i_2_cor],massiv_sigma[i_3_cor]);
            accuracy[i] = A_perm/A[i];
            if (accuracy[i]>1){} accuracy[i] = 2.0-accuracy[i];
            percent += accuracy[i];
        }*/
