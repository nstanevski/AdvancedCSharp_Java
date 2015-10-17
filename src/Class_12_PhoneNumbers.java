import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class_12_PhoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        Pattern pat = Pattern.compile("([A-Z][A-Za-z]*)[^+A-Za-z]*?([+\\d]\\d[\\d\\(\\)/\\.\\-\\s]*)");
        StringBuffer sb = new StringBuffer();
        while(!line.equals("END")){
            sb.append(line);
            line = scanner.nextLine().trim();
        }
        String input = sb.toString().trim();
        Matcher mat = pat.matcher(input);
        Map<String,String> namePhoneMap = new LinkedHashMap<>();
        while(mat.find()){
            String name = mat.group(1).trim();
            String phone = mat.group(2).trim();
            phone = phone.replaceAll("[\\(\\)\\.\\-\\s/]", "");
            namePhoneMap.put(name, phone);
        }
        if(namePhoneMap.isEmpty()){
            System.out.println("<p>No matches!</p>");
        }else{
            System.out.print("<ol>");
            for(String name: namePhoneMap.keySet()){
                System.out.printf("<li><b>%s:</b> %s</li>", name, namePhoneMap.get(name));
            }
            System.out.print("</ol>");
        }
    }
}
