package algorithm.sort;

public class MergeSort {
    private static int[] auxiliary;

    public static void sort(int[] a){
        auxiliary = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);               //对左半边排序
        sort(a, mid + 1, hi);       //对右半边排序
        merge(a, lo, hi, mid);          //归并排序结果
    }

    private static void merge(int[] a, int lo, int hi, int mid) {
        //对 a[lo...mid], a[mid+1...hi] 进行归并
        int left = lo, right = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, auxiliary, lo, hi + 1 - lo);
        for (int i = lo; i <= hi; i++) {
            // 两边中的一边已经排空了
            if(left > mid){
                a[i] = auxiliary[right++];
            }
            else if(right > hi){
                a[i] = auxiliary[left++];
            }
            // 两边都还有剩余
            else if (auxiliary[left] < auxiliary[right]){
                a[i] = auxiliary[left++];
            }
            else{
                a[i] = auxiliary[right++];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,2,7,3,21,5,2,7,9,8,69,34};
        MergeSort.sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
