import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by triest on 11.02.2017.
 *1. Напишите программу, которая считывает символы пока не встретится точка. Также предусмотрите вывод количества пробелов.
 * http://java-help.ru/java-exercises-for-beginners-1/
 */

class Tasks {
    //   *1. Напишите программу, которая считывает символы пока не встретится точка. Также предусмотрите вывод количества пробелов.
    public static void point4() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //инициируем буфер
        System.out.print("Enter String");
        String s = br.readLine(); // считываем строку
        System.out.println(s);
        String currentSumbl = ""; //текущий символ
        int count = 0;
        int spaceCount = 0;
        char m[] = s.toCharArray();

        for (int i = 0; i < m.length; i++) {

            if (m[i] == '.') break; // если встречаеться точка, то выходим из цикла
            count++;
            if (m[i] == ' ') spaceCount++; // считаем пробулы
        }
        System.out.println("Count:" + count);

        System.out.println("Space:" + spaceCount);
    }

    //2/Сила тяжести на Луне примерно равна 17%, напишите программу, которая вычисляет ваш вес на Луне.
    public static double moon(int weight) throws IOException {
        return weight * 0.17;
    }

    // 3. Напишите метод, который будет увеличивать заданный элемент массива на 10%
    public static double[] array(double[] mass, int number) {
        mass[number] = mass[number] * 1.1;
        return mass;
    }


    //5. Расчет расстояния до места удара молнии. Звук в воздухе распространяется со скоростью приблизительно равной 1100 футам в с
    // екунду. Зная интервал времени между вспышкой молнии и звуком сопровождающим ее можно рассчитать расстояние.
    // Допустим интервал 7,2 секунды.
    public static double molnia(double time) {
        return time * 1100;
    }

    //7. Напишите программу, которая вычислит простые числа в пределах от 2 до 100.
//(Опционально) Дополните программу так, чтобы она вычисляла составные числа.

    //Теорема ферма

    //Если n — простое число, то оно удовлетворяет сравнению
    // a^(n-1) ≡ 1 (mod n)
    public static int[] simpleNumbers(int num) {

        int[] mass;
        mass = new int[num];
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (num % i != 0) {
                //   System.out.println("This number is not simple!!!");
                mass[count] = i;
                count++;
            } else {
                System.out.println("This number " + i + " is not simple!!!");
            }
        }
        return mass;
    }

    //8. Найдите среднее арифметическое массива из 10 элементов типа double.

    public static double Averange(int[] mass) {
        int accum = 0;
        double rez=0;
        for (int i = 0; i < mass.length; i++) {
            {
                accum = accum + mass[i];
            }
             rez = accum / mass.length;

        }
        return rez;
    }

    //9. Напишите рекурсивный метод отображающий строку задом на перед.
      public static String reverse(String str){

         String res=new StringBuffer(str).reverse().toString();
            return res;
      }


    /*10. Найдите победителя марафона.
Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон вы можете увидеть ниже.
Ваша задача найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
(Опционально) Найдите человека, который прибежал вторым.
    */

     public static String vinner(String[] names,int[] times){
         int min=32760;
         int index=0;
         for (int i=0;i<times.length;i++){
             if (times[i]<min){
                 min=times[i];
                 index=i;
             }
         }
         String vin=names[index];
         return vin;
     }
}
