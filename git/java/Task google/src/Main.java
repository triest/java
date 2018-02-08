import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by triest on 15.08.2017.
 */
public class Main {

    public HashMap getDuplicateValues(HashMap in)
    {
        // Clone input HashMap because we're removing stuff from it
        in = (HashMap)in.clone();
        HashMap rval = new HashMap();
        Object[] keys = in.keySet().toArray();

        // iterate through all keys
        for(int x=0;x<keys.length;x++) {
            Object value = in.get(keys[x]);
            in.remove(keys[x]);
            // if value is in input HashMap, store it in duplicate HashMap because it has another value
            if(in.containsValue(value)) {
                rval.put(keys[x],value);
            }
            // if value is in duplicate HashMap, store it also because it HAD another value earlier
            if(rval.containsValue(value)) {
                rval.put(keys[x],value);
            }
        }

        return(rval);
    }

    public static HashMap removedDublicate(HashMap hm){
        HashMap newHm = new  HashMap();
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            if(newHm.containsKey(pair.getValue())){
                newHm.put(pair.getValue(), Integer.parseInt(newHm.get(pair.getValue()).toString())+1 );
            }else{
                newHm.put(pair.getValue(),1 );
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return newHm;
    }


    public static void main(String[] args) throws FileNotFoundException {
           System.out.println("Hello World!");


        //считываем
        File file=new File("E:\\Dropbox\\Java\\Task google\\src\\file.txt");
        Scanner s = new Scanner(new File("E:\\Dropbox\\Java\\Task google\\src\\file.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        HashMap<Integer, String> productMap = new HashMap<Integer,String>();
        int count=0;
        for (int i=0;i<list.size();i++) {
            productMap.put(i,list.get(i));
        }
        HashMap rez=removedDublicate(productMap);
        System.out.println("Rez: "+rez);
        Integer key=0;

        System.out.println("productMap:"+productMap);


        System.out.println("Number of Strings repeated : " );

        }

    }

