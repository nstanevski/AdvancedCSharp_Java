import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class_01_PlusRemove {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<ArrayList<Character>> array = new ArrayList<ArrayList<Character>>();
        List<int[]> positions = new ArrayList<int[]>();

        String line = scanner.nextLine();
        while(!line.equals("END")){

            ArrayList<Character> lineChars = new ArrayList<Character>();
            for(Character c:line.toCharArray()){
                lineChars.add(c);
            }
            array.add(lineChars);

            line = scanner.nextLine();
        }

        int numRows = array.size();

        for(int rowNum = 0; rowNum<numRows - 2; rowNum++){
            int numCols = array.get(rowNum).size();
            for(int colNum = 1; colNum<numCols; colNum++){
                Character c1 = Character.toLowerCase(array.get(rowNum).get(colNum));
                Character c2 = null, c3 = null , c4 = null ,c5 = null;
                if(rowNum+1>=0 && rowNum+1< array.size() &&
                        colNum-1 <array.get(rowNum+1).size() && colNum-1>=0) {
                    c2 = Character.toLowerCase(array.get(rowNum + 1).get(colNum - 1));
                }


                if(rowNum+1>=0 && rowNum+1< array.size() &&
                        colNum <array.get(rowNum+1).size() && colNum >=0) {
                    c3 = Character.toLowerCase(array.get(rowNum + 1).get(colNum));
                }


                if(rowNum+1>=0 && rowNum+1< array.size() &&
                        colNum+1 <array.get(rowNum+1).size() && colNum+1 >=0) {
                    c4 = Character.toLowerCase(array.get(rowNum + 1).get(colNum + 1));
                }


                if(rowNum+2>=0 && rowNum+2< array.size() &&
                        colNum <array.get(rowNum+2).size() && colNum >=0) {
                    c5 = Character.toLowerCase(array.get(rowNum+2).get(colNum));
                }



                if((c1==c2 && c1==c3 && c1==c4 && c1 == c5) ){
                    //System.out.printf("Plus at position: %d %d", rowNum, colNum);
                    positions.add(new int[]{rowNum, colNum});
                    positions.add(new int[]{rowNum+1, colNum-1});
                    positions.add(new int[]{rowNum+1, colNum});
                    positions.add(new int[]{rowNum+1, colNum+1});
                    positions.add(new int[]{rowNum+2, colNum});

                }
            }

        }

        for(int[] position:positions){
            int rowNum = position[0];
            int colNum = position[1];
            ArrayList<Character> row = array.get(rowNum);
            row.set(colNum, null);
        }

        for(ArrayList<Character> row: array){
            StringBuffer sb = new StringBuffer();
            for(Character c: row){
                if(c!= null){
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}
