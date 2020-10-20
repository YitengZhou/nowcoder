public class KMP {
    private int[][] dp;
    private String pat;

    /**
     * dp[j][c] = next
     * 0 <= j < M，代表当前的状态
     * 0 <= c < 256，代表遇到的字符（ASCII 码）
     * 0 <= next <= M，代表下一个状态
     *
     * dp[4]['A'] = 3 表示：
     * 当前是状态 4，如果遇到字符 A，
     * pat 应该转移到状态 3
     *
     * dp[1]['B'] = 2 表示：
     * 当前是状态 1，如果遇到字符 B，
     * pat 应该转移到状态 2
     * https://zhuanlan.zhihu.com/p/83334559
     */
    /
    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下一个状态
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        // 状态转移
        for (int j= 1;j<M;j++){
            for (int c= 0;c<256;c++){
                if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];
            }
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i<M;i++){
//            for (int j = 0;j<256;j++){
//                sb.append(dp[i][j]+" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
    }

    public int search(String txt){
        int M = pat.length();
        int N = txt.length();
        // pat的初始态为0
        int j = 0;
        for (int i = 0;i< N;i++){
            // 状态 = 前状态下遇到字符后，变成的状态
            j = dp[j][txt.charAt(i)];
            if (j==M) return i-M+1;
        }
        return -1;
    }
}
