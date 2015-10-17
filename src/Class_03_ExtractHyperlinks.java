import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class_03_ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuffer sb = new StringBuffer();
        while(!line.equals("END")){
            sb.append(line);
            line = scanner.nextLine();
        }
        String html = sb.toString();

        Pattern aPattern = Pattern.compile("<a([^>]+)>");
        Matcher aMatcher = aPattern.matcher(html);

        Pattern hrefPat = Pattern.compile("href\\s*=\\s*([\"']+)(.+?)\\1");
        while(aMatcher.find()){
            String attrString = aMatcher.group(1);
            Matcher valueMat = hrefPat.matcher(attrString);
            while(valueMat.find()){
                System.out.println(valueMat.group(2));
            }
        }
    }
}
