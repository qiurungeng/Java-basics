package exam.perfectworld;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (map.get(c) == 1) sb.append(c);
        }

        System.out.println(sb);
    }
}
