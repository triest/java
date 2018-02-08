/**
 * Created by triest on 19.02.2017.
 */
public class Main {
    public void exampl(){
        return void;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); String h1 = "HelloWorld"; sb.append("Hello").append("World"); if (h1 == sb.toString()) { System.out.print("One"); } if (h1.equals(sb.toString())) { System.out.print("Two"); }
    }
}