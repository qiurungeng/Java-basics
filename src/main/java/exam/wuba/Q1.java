package exam.wuba;

import java.util.Scanner;

public class Q1 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] strs = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1){
                    mark(matrix, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void mark(int[][] matrix, int i, int j){
        if (matrix[i][j] != 0) {
            matrix[i][j] = 0;
            if(i > 0) mark(matrix, i-1, j);
            if(i < matrix.length -1) mark(matrix, i+1, j);
            if(j > 0) mark(matrix, i, j-1);
            if(j < matrix[i].length -1) mark(matrix, i, j+1);
        }
    }
}
