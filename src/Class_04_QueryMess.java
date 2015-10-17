import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class_04_QueryMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        Pattern pat = Pattern.compile("([^=]+?)=(.+)");
        Map<String, ArrayList<String>> container = new LinkedHashMap<String, ArrayList<String>>();
        while(!line.equals("END")){
            line = line.replaceAll("\\+", " ");
            line = line.replaceAll("%20", " ");
            line = line.replaceAll("\\s+", " ");
            String[] items = line.split("\\s*&\\s*");
            container.clear();
            for (String item:items){
                //System.out.println(item);
                Matcher mat = pat.matcher(item);
                if(mat.find()){
                    String key = mat.group(1).trim();
                    String value = mat.group(2).trim();
                    if(key.indexOf('?')>=0){
                        key = key.substring(key.indexOf('?')+1);
                    }
                    ArrayList<String> values;
                    if(container.containsKey(key)){
                        values = container.get(key);
                    }else{
                        values = new ArrayList<String>();
                    }
                    values.add(value);
                    container.put(key, values);
                }
            }
            for(String key: container.keySet() ){
                ArrayList<String> values = container.get(key);
                String[] valuesArr = (String[]) values.toArray(new String[0]);
                String valString = String.join(", ", valuesArr);
                System.out.printf("%s=[%s]", key, valString);
            }
            System.out.println();
            line = scanner.nextLine().trim();
        }


    }
}
