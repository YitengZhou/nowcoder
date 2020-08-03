package Match笔试.牛牛翻滚;

import java.util.*;
import java.math.*;


public class Solution {
    /**
     *
     * @param k int整型 翻滚次数
     * @return double浮点型
     */
    public double circumference (int k) {
        // write code here
        double[] a= {1, Math.pow(3,0.5),2,Math.pow(3,0.5),1,0};
        int count = 0;
        double r = 0;
        for (int i = 0;i<k;i++){
            if (count == 5){
                r+= a[count];
                count = 0;
            }
            else {
                r+= a[count];
                count++;
            }
        }
        double sumTotal = r*Math.PI/3;
        return sumTotal;
    }
}