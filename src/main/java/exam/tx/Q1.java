package exam.tx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        String[] s2 = sc.nextLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();
        for (String s : s1) {
            int i =Integer.parseInt(s);
            map.put(i, i);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s2) {
            int i =Integer.parseInt(s);
            if(map.containsKey(i)){
                sb.append(i).append(" ");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.print(sb.toString());
    }
}
