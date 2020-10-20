package Match比赛.牛牛晒衣服;

import java.util.*;


public class Solution {
    /**
     * 计算最少要多少时间可以把所有的衣服全烘干
     * @param n int整型 n件衣服
     * @param a int整型一维数组 n件衣服所含水量数组
     * @param k int整型 烘干机1分钟可以烘干的水量
     * @return int整型
     */
    public int solve (int n, int[] a, int k) {
        // write code here
        int left = 0;
        int right = 0;
        for (int i=0;i<n;i++){
            if (a[i]>right){
                right=a[i];
            }
        }
        if (k==1){
            return right;
        }
        else{
            while (left<=right){
                int mid = (left+right)/2;
                if (check(mid,a,n,k)){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            return left;
        }

    }
    public boolean check(int ans, int a[],int n,int k) {
        int now=0;
        for (int i=0; i<n; i++) {
            if (a[i]>ans) {
                // 至少需要多长时间能够烘干衣服
                if ((a[i]-ans)%(k-1)==0){
                    now += (a[i]-ans)/(k-1);
                }
                else{
                    now += (a[i]-ans)/(k-1)+1;
                }
                if (now>ans) {
                    return false;
                }
            }
        }
        return true;
    }
}