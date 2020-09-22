package leetcode;

/**
 * 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 * 未解决，A中夹杂负数，
 * 左右指针所划定的窗口增大不代表sum增大，变小不代表sum变小
 */
public class Q862 {
    public int shortestSubarray(int[] A, int K) {
        int left = 0, right = 0, sum = A[0], n = A.length, minLen = n;
        boolean flag = false;
        while(true){
            while(sum < K && right < n - 1){
                sum += A[++right];
            }
            while(left <= right){
                if(sum >= K){
                    flag = true;
                    minLen = Math.min(minLen, right - left + 1);
                }
                sum -= A[left];
                left++;
            }
            if(right == n - 1){
                break;
            }
        }
        return flag ? minLen : -1;
    }
}
