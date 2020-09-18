package exam.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); //需要判断的组数
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] params = sc.nextLine().split(" ");
            int n = Integer.parseInt(params[0]);  //小岛数
            int m = Integer.parseInt(params[1]);  //可造桥数
            int k = Integer.parseInt(params[2]);  //每条桥成本限制
            Island[] islands = new Island[n];
            for (int i = 0; i < n; i++) {
                islands[i] = new Island(i);
            }

            for (int i = 0; i < m; i++) {
                String[] costInfos = sc.nextLine().split(" ");
                int cost = Integer.parseInt(costInfos[2]);
                if(cost > k) continue;
                Island i1 = islands[ Integer.parseInt(costInfos[0]) - 1 ];
                Island i2 = islands[ Integer.parseInt(costInfos[1]) - 1 ];
                i1.buildBridge(i2);
            }

            islands[0].traverse();
            String res = "Yes\n";
            for (Island island : islands) {
                if (!island.reach)  {
                    res = "No\n";
                    break;
                }
            }
            sb.append(res);
        }

        System.out.print(sb.toString());
    }

    static class Island{
        ArrayList<Island> connected = new ArrayList<>();
        int code;
        boolean reach = false;

        Island(int i){
            this.code = i ;
        }

        void buildBridge(Island island){
            if (connected.contains(island)) return;
            connected.add(island);
            island.connected.add(this);
        }
        void traverse(){
            if(!reach){
                reach = true;
                for (Island island : connected) {
                    island.traverse();
                }
            }
        }

    }
}
