public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i =0;i<m;i++){
            int val = i==0? 0:dp[i-1][0];
            dp[i][0] = grid[i][0] + val;
        }
        for (int i = 0;i<n;i++){
            int val = i==0? 0:dp[0][i-1];
            dp[0][i] = grid[0][i] + val;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        StringBuffer s = new StringBuffer();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                s.append(dp[i][j]+" ");
            }
            s.append("\n");
        }
        System.out.println(s);
        return dp[m-1][n-1];
    }
}
