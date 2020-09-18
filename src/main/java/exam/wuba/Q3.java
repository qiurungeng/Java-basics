package exam.wuba;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,-1,2,5,4}));
    }

    public static int firstMissingPositive (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int i = 1;
        int res = Math.max(1, nums[nums.length - 1]) ;
        for (int num : nums) {
            if(num > 0){
                if(num != i){
                    res = i;
                    break;
                }
                i++;
            }
        }
        return res;
    }
}
