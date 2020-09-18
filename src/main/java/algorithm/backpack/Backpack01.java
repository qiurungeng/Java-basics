package algorithm.backpack;

public class Backpack01 {

    public int backpack01(int[] values, int[] weight, int capacity){
        int n = values.length;
        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i < n + 1; i++) {
            for(int c = 1 ; c <= capacity ; c++){
                if (c - weight[i-1] < 0){
                    dp[i][c] = dp[i-1][c];
                }else{
                    dp[i][c] = Math.max(dp[i-1][c-weight[i-1]] + values[i-1],
                           dp[i-1][c] );
                }
            }
        }
        printDP(dp);
        return dp[n][capacity];
    }

    public void printDP(int[][] dp){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        Backpack01 b = new Backpack01();
        System.out.println(b.backpack01(val, wt, 4));
    }
}
