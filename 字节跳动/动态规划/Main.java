package 字节跳动.动态规划;

import java.util.*;
public class Main {
    //备忘录
    public static int[][] memo;
    //自上而下的dp函数
    public static int dp(int city, int j, int[][] dist) {
        //中止条件
        if(j == 0)
            return dist[city][0];
        //如果命中，直接返回
        if(memo[city][j] != -1)
            return memo[city][j];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < dist.length; i++) {
            if(((j >> (i-1)) & 1) == 1) {
                j ^= (1 << (i-1));
                //记录这一轮的最小答案
                ans = Math.min(ans, dist[city][i]+dp(i, j, dist));
                j ^= (1 << (i-1));
            }
        }
        //添加至备忘录
        memo[city][j] = ans;
        return ans;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cityNum = in.nextInt();// 城市数目
        int[][] dist = new int[cityNum][cityNum];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < cityNum; j++) {
                dist[i][j] = in.nextInt();
            }
        }
        //对1进行左移n-1位，值刚好等于2^(n-1)
        int V = 1 << (cityNum - 1);
        System.out.println(V);
        memo = new int[cityNum][V];
        //初始化memo备忘录
        for (int i = 0; i < cityNum; i++) {
            for(int j = 0; j < V; j++) {
                memo[i][j] = -1;
            }
        }

        int ans = dp(0 , V-1, dist);
        System.out.println(printMemo(memo,cityNum,V));
        System.out.println(ans);
    }

    public static String printMemo(int[][] memo,int cityNum, int V){
        String gh = "";
        for (int i = 0; i < cityNum; i++) {
            for(int j = 0; j < V; j++) {
                gh+=memo[i][j]+" ";
            }
            gh+="\n";
        }
        return gh;
    }
}