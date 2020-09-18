import java.util.ArrayList;
import java.util.Scanner;

public class TEST4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] features = new int[M];
        ArrayList<Integer> minGBS = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            features[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                int gbs = features[i] * features[j] / min(features[i], features[j]);
                if(!contains(minGBS, gbs))minGBS.add(gbs);
            }
        }

        int count = 0;
        for (int feature : features) {
            System.out.println(N/feature);
            count += N/feature;
        }
        for(int gys : minGBS){
            count -= N/gys;
        }

        System.out.println(count);
    }

    static boolean contains(ArrayList<Integer> list, int i){
        for (Integer integer : list) {
            if (integer == i)return true;
        }
        return false;
    }

    static int min(int a, int b){
        if(a < b){
            int temp = a;
            a=b;
            b=temp;
        }
        while(b != 0){
            if(a == b){
                return a;
            }else{
                int l = a % b;
                a = b;
                b = l;
            }
        }
        return a;
    }
}
