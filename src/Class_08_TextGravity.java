import java.util.Scanner;

public class Class_08_TextGravity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowLen = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int numRows = input.length() / rowLen;
        if((input.length() % rowLen)>0){
            numRows++;
        }
        int inputIndex = 0;
        Character[][] chars = new Character[numRows][rowLen];
        for(int rowNum = 0; rowNum<numRows; rowNum++){
            for(int colNum = 0; colNum<rowLen; colNum++){
                if(inputIndex<input.length()){
                    chars[rowNum][colNum] = input.charAt(inputIndex);
                }else{
                    chars[rowNum][colNum] = ' ';
                }
                inputIndex++;
            }
        }

        //walk by columns
        for(int i=0; i<chars[0].length; i++){
            StringBuffer column = new StringBuffer();
            //put non-space chars at the left
            for(int j=0; j<chars.length; j++){
                if(!Character.isSpaceChar(chars[j][i])){
                    column.append(chars[j][i]);
                }
            }

            //left-padding with spaces
            while(column.length()<numRows){
                column.insert(0, ' ');
            }

            //put the column back
            for(int j=0; j<chars.length; j++){
                chars[j][i] = column.charAt(j);
            }

        }

        StringBuffer result = new StringBuffer("<table>");
        for(int i=0; i<chars.length; i++){
            result.append("<tr>");
            for(int j=0; j<chars[0].length; j++){
                result.append("<td>").append(chars[i][j]).append("</td>");
            }
            result.append("</tr>");
        }
        result.append("</table>");
        System.out.println(result);
    }
}
