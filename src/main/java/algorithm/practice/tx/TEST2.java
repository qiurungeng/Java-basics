package algorithm.practice.tx;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");

        int[] heights = new int[strings.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(strings[i]);
        }

        int[] res = monotonyStack(heights);
        for(int i = 0 ; i < n ; i++){
            System.out.print(res[i] + " ");
        }
    }

    static int[] monotonyStack(int[] heights){
        int[] ans = new int[heights.length];
        Arrays.fill(ans, 1);
        Stack<Integer> stackL2R = new Stack<>();
        Stack<Integer> stackR2L = new Stack<>();
        for (int i = heights.length - 1; i >= 0 ; i--) {
            ans[i] += stackL2R.size();
            while(!stackL2R.isEmpty() && heights[i] > stackL2R.peek()){
                stackL2R.pop();
            }
            stackL2R.push(heights[i]);

        }
        for (int i = 0; i < heights.length; i++) {
            ans[i] += stackR2L.size();
            while(!stackR2L.isEmpty() && heights[i] > stackR2L.peek()){
                stackR2L.pop();
            }
            stackR2L.push(heights[i]);
        }
        return ans;
    }

    static int[] reverse(int[] array){
        int l = 0 , r = array.length;
        while (l < r){
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++; r--;
        }
        return array;
    }
}
