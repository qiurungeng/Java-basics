package exam.gbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    private static boolean[] isPrim;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt( sc.nextLine());
        isPrim = new boolean[n];
        List<Integer> prim = getPrim(n);
        int count = 0;
//        while (true){
//            for (int i = 0 ; prim.get(i) < temp ; i++) {
//                if (n % i == 0) {
//                    count++;
//                }
//            }
//        }

        System.out.println(count);
    }

    //寻找质数
    static List<Integer> getPrim(int n){

        Arrays.fill(isPrim, true);
        for (int i = 2; i < n; i++) {
            if (isPrim[i]){
                for (int j = 2 * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
