package Match笔试.牛牛构造等比数列;

import java.util.*;

public class Solution {
    /**
     * 返回最少多少次操作后能使这几个数变成一个等差数列，如果完全不能构造成功，就返回-1
     * @param n int整型 代表一共有n个数字
     * @param b int整型一维数组 代表这n个数字的大小
     * @return int整型
     */
    public int solve (int n, int[] b) {
        // write code here
        if (b.length<2){
            return -1;
        }
        int first = b[0], second = b[1],count =0;
        int min = Integer.MAX_VALUE;
        for (int i=-1;i<=1;i++){
            for(int j =-1;j<=1;j++){
                first = b[0] + i;
                second = b[1] + j;
                if (i!=0) count++;
                if (j!=0) count++;
                int dif = first-second;
                int pre = second;
                boolean bool = true;
                for (int k = 2;k<b.length;k++){
                    int t = b[k]-pre;
                    int temp = t- dif;
                    if (temp==-1){
                        pre = b[k]+1;
                        count++;
                    }
                    else if (temp==0){
                        pre = b[k];
                    }
                    else if (temp==1){
                        pre = b[k] -1;
                        count++;
                    }
                    else{
                        bool = false;
                        break;
                    }
                }
                if (bool) min = Math.min(min,count);
            }
        }
        return min == Integer.MAX_VALUE? -1:min;
    }
}