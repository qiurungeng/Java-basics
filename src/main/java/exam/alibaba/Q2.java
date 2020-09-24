package exam.alibaba;

import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < n; j++) {
                String[] str = sc.nextLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                int cost = Integer.parseInt(str[2]);


            }
        }
    }

    class Edge{
        int a;
        int b;
        int cost;
        Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

    }

}
