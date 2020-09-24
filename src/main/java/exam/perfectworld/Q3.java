package exam.perfectworld;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            if (word.length() == 0) continue;
            if (word.length() > 1){
                char[] chars = word.toCharArray();
                for (int i = chars.length - 1 ; i >= 0 ; i--) {
                    sb.append(chars[i]);
                }
                sb.append("_");
            }else {
                sb.append(word).append("_");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.println(sb);
    }
}
