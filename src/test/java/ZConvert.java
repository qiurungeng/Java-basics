import java.util.HashMap;
import java.util.LinkedList;

public class ZConvert {

    public String convert(String s, int numRows) {
        ZPointer zp = new ZPointer(numRows);
        Character[][] zArray = new Character[numRows][costColumn(s, numRows)];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int[] index = zp.get();
            zArray[index[0]][index[1]] = c;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < zArray.length ; i++){
            for(int j = 0 ; j < zArray[i].length ; j++){
                System.out.print(zArray[i][j] == null ? "  ":zArray[i][j]  + " ");
                if(zArray[i][j] != null) sb.append(zArray[i][j]);
            }
            System.out.println();
        }
        return sb.toString();
    }

    public String convert2(String s, int numRows){
        HashMap<Integer, LinkedList<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new LinkedList<>());
        }
        ZPointer zp = new ZPointer(numRows);
        for (char c : s.toCharArray()) {
            int row = zp.get()[0];
            map.get(row).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            LinkedList<Character> row = map.get(i);
            for (Character c : row) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //占用列数
    public int costColumn(String s, int row){
        ZPointer zp = new ZPointer(row);
        for (int i = 0; i < s.length()-1; i++) {
            zp.get();
        }
        return zp.get()[1] + 1;
    }

    class ZPointer{
        private final int[] zPointer = new int[]{0, 0};
        private final int numRows;
        boolean down = true;

        ZPointer(int numRows){
            this.numRows = numRows;
        }

        int[] get(){
            int[] res = new int[]{zPointer[0], zPointer[1]};
            if(down){
                zPointer[0]++;
                if(zPointer[0] == numRows - 1) down = false;
            }else{
                zPointer[0]--;
                zPointer[1]++;
                if(zPointer[0] == 0) down = true;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ZConvert ZConvert = new ZConvert();
        System.out.println(ZConvert.costColumn("PAYPALISHIRIN", 4));
        System.out.println(ZConvert.convert("PAYPALISHIRING", 4));
    }
}
