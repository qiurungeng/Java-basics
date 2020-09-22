package exam.bytedance.practice;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.nextLine();
        }
        for (String s : strs) {
            System.out.println(filter(s.substring(0, s.length() - 1)));
        }
    }

    private static String filter(String s){
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        for (int i = 2; i < sb.length(); i++) {
            if(sb.charAt(i-1) == sb.charAt(i-2)){
                if(sb.charAt(i) == sb.charAt(i-1)){
                    sb.deleteCharAt(i);
                }else if(i < sb.length() - 1 && sb.charAt(i) == sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }
}
