import java.util.Scanner;

public class TEST3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(" ");
        int N = Integer.parseInt(params[0]); //商品总数
        int M = Integer.parseInt(params[1]); //背包原始大小

        int profile = 0;
        int count = 0; //
        int[] spaces = new int[N];
        int[] profiles = new int[N];

        for(int i = 0 ; i < N ; i++){
            String[] cv = scanner.nextLine().split(" ");
            int c = Integer.parseInt(cv[0]); //占空间
            int v = Integer.parseInt(cv[1]); //收益
            spaces[i] = c;
            profiles[i] = v;
        }


    }
}
