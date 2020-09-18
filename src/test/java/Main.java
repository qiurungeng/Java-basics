import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] result = new int[n][n];
        for(int i = n-2 ; i >= (float)n/2 ; i--){
            for(int j = 0; j < n-1-i ; j++){
                result[j][i] = 1;
                result[n-1-j][i] = 6;
            }
        }
        for(int i = 1 ; i < n/2 ; i++){
            for(int j = 0; j < i ; j++){
                result[j][i] = 2;
                result[n-1-j][i]=5;
            }
        }
        for(int i = 1 ; i < n/2 ; i++){
            for(int j = 0 ; j < i ; j++){
                result[i][j] = 3;
                result[i][n-1-j] = 8;
            }
        }
        for(int i = n-2 ; i >= (float)n/2 ; i--){
            for(int j = 0 ; j < n-i-1 ; j++){
                result[i][j] = 4;
                result[i][n-1-j] = 7;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.replace(sb.length() - 1, sb.length(), "\n");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.print(sb.toString());
    }


}