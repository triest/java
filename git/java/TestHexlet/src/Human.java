/**
 * Created by triest on 19.02.2017.
 */
public class Human {
    public String name = "";
    public int age = 0;
    public String surname = "N/A";
    public boolean sex = false;
    public void display() {
        System.out.println("Name: " + name + " Surname: " + surname); }
    public boolean isFemale() {
        return sex;
    }
}
