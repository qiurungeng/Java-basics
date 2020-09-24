package exam.perfectworld;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        System.out.println(func(M, N));
    }

    // 递归

    /**
     *
     * @param M 相同球
     * @param N 相同盒子
     * @return 允许盒子为空，有多少种放法？
     */
    private static int func(int M, int N){
        //只有1盒子 或 没有球
        if(N == 1 || M == 0) {
            return 1;
        }
        //盒子 > 球 的情况等价于 盒子 = 球
        else if(N > M) {
            return  func(M, M);
        }
        // 盒子 <= 球 :
        // 1) 至少有一个盒子空着
        // 2） 所有盒子都有球，每个盒子里拿掉一个球不影响总放法
        return func(M, N-1) + func(M-N, N);
    }
}
