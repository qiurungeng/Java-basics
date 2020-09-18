package exam.tx;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        Box[] boxes = new Box[n];
        Map<Integer, Box> map = new HashMap();
        String[] ai = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ai[i]);
            Box box = new Box(a[i]);
            boxes[i] = box;
            map.put(a[i], box);
        }
        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.val - o2.val;
            }
        });
        int mid = n/2;
        for (int i = 0; i < n; i++) {
            if (i >= mid) boxes[i].answer = boxes[mid-1].val;
            else boxes[i].answer = boxes[mid].val;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(map.get(a[i]).answer);
        }

    }
    static class Box{
        int val;
        int answer;
        Box(int val){
            this.val = val;
        }
    }
}
