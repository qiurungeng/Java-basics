import java.util.Scanner;

public class TEST2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] in = new int[m][n];
        int count = 0;
        for(int[] line : in){
            String s = scanner.nextLine();
            String[] elements = s.split(" ");
            for (int i = 0; i < elements.length; i++) {
                line[i] = Integer.parseInt(elements[i]);
                if(line[i]==1)count++;
            }
        }


        System.out.println(count);

    }
}
