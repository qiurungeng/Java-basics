package exam.alibaba;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
        String[] s = new String[K];
        for (int i = 0; i < K; i++) {
            s[i] = sc.nextLine();
        }
        for (String str : s) {
            String[] strNum = str.split(" ");
            int N = Integer.parseInt(strNum[0]);
            int M = Integer.parseInt(strNum[1]);
            if(N % 2 == 0 || M % 2 == 0) System.out.println("1/2");
            else{
                int n2 = N >> 1;
                int n1 = N - n2;
                int m2 = M >> 1;
                int m1 = M - m2;
                int up = n2*m1 + m1*n2;
                int down = N*M;
                int q = maxGYS(up, down);
                System.out.println(up/q + "/" + down/q);
            }

        }
    }

    private static int maxGYS(int a, int b){
//        int min = Math.min(a, b);
//        for (int i = min; i >= 1; i--) {
//            if(a % i == 0 && b % i == 0){
//                return i;
//            }
//        }
//        return 1;


//        int e = a;
//
//        for(int i = 1 ; i <= e ; i++){
//            int c = Math.max(a, b);
//            int d = Math.min(a, b);
//
//            a = c % d;
//            b = d;
//
//            if(a == 0){
//                return d;
//            }
//        }
//
//        return 1;

        int r = a % b;
        if(r == 0) return b;
        return maxGYS(b, r);
    }
}
