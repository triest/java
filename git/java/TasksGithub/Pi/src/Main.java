import java.util.Random;

/**
 * Created by triest on 20.02.2017.
 */

public class Main {

    public static double pi(int n){
        int r=46340;
        int r2=r*r;
        long i=0;long pass=0;
        float x,y;
        Random random=new Random();
        for (i=0;i<=n;i++){
             x = 0 + (float) (Math.random() * r+1);
            y=0 + (float) (Math.random() * r+1);
        }
        return Pi;
    }

    public static void main(String[] args) {

            System.out.println(pi(100));
    }
}
