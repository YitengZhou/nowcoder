import java.util.*;

public class Main{
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);
        int time = input.nextInt();
        int num = input.nextInt();
        int[][] map = new int[num][4];
        for (int i = 0;i<num;i++){
            for (int j = 0;j<4;j++){
                map[i][j] = input.nextInt();
            }
        }
        int[] dp = new int[time+1];
        dp[0] = 0;
        HashMap<Integer,ArrayList<Integer>> link = new HashMap<>();
        for (int i =1;i<time+1;i++){
            int max = dp[i-1];
            int task = 0;
            int begin = 0;
            int end = 0;
            ArrayList<Integer> one = new ArrayList<>();
            for (int x = 0;x<num;x++){
                if (map[x][2]+map[x][3]==i){
                    if (map[x][1]+dp[i-map[x][3]]>max){
                        max=map[x][1]+dp[i-map[x][3]];
                        task = map[x][0];
                        begin = map[x][2];
                        end = map[x][3];
                    }
                }
            }
            dp[i] = max;
            if (dp[i]!=dp[i-1]){
                one.add(task);
                one.add(begin);
                one.add(end+begin);
                link.put(i,one);
            }
        }
        // print
        System.out.println(dp[time]);
        System.out.println(link.size());
        for (Integer i:link.keySet()){
            System.out.println(link.get(i).get(0));
        }

        /*
        for (int i = 0;i<time+1;i++){
            System.out.println(dp[i]);
        }*/

    }

}