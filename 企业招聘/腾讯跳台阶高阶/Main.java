import java.util.Scanner;

public class Main3{
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] dp = new int[n+1][m+1][m+1];
        // 初始方案为1
        dp[0][0][0] = 1;
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    //j和k都是0的情况下是可以转移的，不然一步都迈不出去
                    if (j != 0 && k != 0) {
                        // 不符合
                        if (i < j+k || j == k) continue;
                    }
                    // 非法不专利
                    if (dp[i][j][k] == 0) continue;
                    for (int s = 1; s <= m; s++) {
                        if (s != j && s != k && i+s <= n) {
                            // 状态转移
                            dp[i+s][k][s] = (dp[i+s][k][s] + dp[i][j][k])%MOD;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= m; j++) {
                cnt = (cnt + dp[n][i][j])%MOD;
            }
        }
        System.out.println(cnt);
    }
}