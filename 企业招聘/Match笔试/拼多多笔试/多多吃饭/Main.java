package Match笔试.拼多多笔试.多多吃饭;/*
5 1 9
9 1
4 9
3 1
2 3
6 5
9 8

1 1 0
3 1
2 1

3 3 10
1 1
2 5
3 7
2 4
4 8
6 9

*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int lnum = input.nextInt();
            int dnum = input.nextInt();
            int val = input.nextInt();

            int[][] lunch = new int[lnum][2];
            int[][] din = new int[dnum][2];
            for (int i = 0;i<lnum;i++){
                lunch[i][0] = input.nextInt();
                lunch[i][1] = input.nextInt();
            }
            for (int i = 0;i<dnum;i++){
                din[i][0] = input.nextInt();
                din[i][1] = input.nextInt();
            }
            if (val<=0){
                System.out.println(0);
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0;i<lnum;i++){
                if (lunch[i][1]>=val){
                    min = Math.min(lunch[i][0],min);
                    break;
                }
                for (int j = 0;j<dnum;j++){
                    if (din[j][1]>=val){
                        min = Math.min(din[j][0],min);
                        break;
                    }
                    if (lunch[i][1]+din[j][1]>=val){
                        min = Math.min(lunch[i][0]+din[j][0],min);
                    }
                }
            }
            if (min==Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(min);
            }

        }
    }
}
