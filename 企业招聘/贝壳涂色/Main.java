import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loop = input.nextInt();
        for (int i = 0;i<loop;i++){
            int board = input.nextInt();
            int color = input.nextInt();
            int limit = input.nextInt();
            int[][] limitmap = new int[color+1][limit];
            for (int k=1;k<color+1;k++){
                for (int j=0;j<limit;j++){
                    limitmap[k][j] = input.nextInt();
                }
            }
            int[][] dp = new int[board+1][color+1];
            for (int k=0;k<color+1;k++){
                dp[1][k] = 1;
            }
            for (int j = 1;j<board;j++){
                for (int k = 1;k<color+1;k++){
                    for (int x = 1;x<color+1;x++){
                        if (nofind(k,x,limitmap,limit)){
                            dp[j+1][x] += dp[j][k];
                        }
                    }
                }
            }
//            StringBuffer map = new StringBuffer();
//            for (int j = 0;j<board+1;j++){
//                for (int k=0;k<color+1;k++){
//                    map.append(dp[j][k]+" ");
//                }
//                map.append("\n");
//            }
//            System.out.println(map);
            long sum =0;
            for (int j = 1;j<color+1;j++){
                sum +=dp[board][j];
            }
            System.out.println(sum%1000000007);
        }
    }
    public static boolean nofind(int before,int after, int[][] limitmap,int limit){
        for (int i = 0;i<limit;i++){
            if (limitmap[before][i] == after){
//                System.out.println(before+"-"+after+"-f");
                return false;
            }
        }
//        System.out.println(before+"-"+after+"-t");
        return true;
    }
}