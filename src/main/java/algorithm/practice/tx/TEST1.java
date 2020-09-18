package algorithm.practice.tx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TEST1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String originText = sc.nextLine();
        char[] encode = originText.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < encode.length ; i++){
            if(encode[i] == '['){
                int start = i;
                while(encode[++i] != ']')i++;
                String[] splits = originText.substring(start, i).split("\\|");
                for (String split : splits) {
                    System.out.println(split);
                }
                Stack<String> stack = new Stack<>();
                stack.addAll(Arrays.asList(splits));
                StringBuilder decode = new StringBuilder();
                while(!stack.isEmpty()){
                    String S = stack.pop();
                    int m = Integer.parseInt(stack.pop());
                    String oldDecode = decode.toString();
                    for (int j = 0; j < m; j++) {
                        decode.append(S).append(oldDecode);
                    }
                }
                sb.append(decode);
            }else{
                sb.append(encode[i]);
            }
        }

        System.out.println(sb.toString());
    }
}
