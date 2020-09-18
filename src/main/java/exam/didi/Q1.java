package exam.didi;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        char[] txt = sc.nextLine().toCharArray();

        for (int i = 0; i < txt.length; i += len) {
            int left = i , right = (txt.length - 1 - i < len ) ?
                                txt.length - 1 : i + len -1;
            while (left < right){
                char temp = txt[left];
                txt[left] = txt[right];
                txt[right] = temp;
                left++;
                right--;
            }
        }

        String result = new String(txt);
        System.out.println(result);

    }
}
