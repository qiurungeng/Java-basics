package exam.perfectworld;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] lens = s.split(" ");
        int lenA = Integer.parseInt(lens[0]);
        int lenB = Integer.parseInt(lens[1]);

        ArrayList<Integer> aList = new ArrayList<>();
        Map<Integer, Integer> aOccurTimes = new HashMap<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            String[] as = sc.nextLine().split(" ");
            int occurTimes = Integer.parseInt(as[1]);
            int a = Integer.parseInt(as[0]);
            aList.add(a);
            aOccurTimes.put(a, occurTimes);
        }
        aList.sort((o1, o2) -> o2 - o1);

        int count = 0;

        for (int i = 0; i < lenB; i++) {
            String[] bs = sc.nextLine().split(" ");
            int occurTimes = Integer.parseInt(bs[1]);
            int b = Integer.parseInt(bs[0]);
            for (Integer a : aList) {
                if (b >= a) break;
                count += occurTimes * aOccurTimes.get(a);
            }
        }

        System.out.println(count);
    }
}
