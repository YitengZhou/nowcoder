package LeetCode.max_point_on_line;

import java.util.*;
// 该法无法通过过大值，因为精度丢失

public class Solution {
    /**
     *
     * @param points Point类一维数组
     * @return int整型
     */
    public int maxPoints (Point[] points) {
        // write code here
        if (points.length<=2){
            return points.length;
        }
        int max = 0;
        for (int i =0;i<points.length-1;i++){
            HashMap<Double,Integer> map = new HashMap<>();
            int repeat =1;
            int vel = 0;
            for (int j=i+1;j<points.length;j++){
                double col = points[i].y - points[j].y;
                double row = points[i].x - points[j].x;
                double k;
                if (row == 0){
                    if (col == 0){
                        repeat++;
                        continue;
                    }
                    vel++;
                    continue;
                }
                else{
                    k = 0 + col/row;
                }
                System.out.println("point x,y" + points[j].x + points[j].y);
                System.out.println("k" + k);
                if (map.keySet().contains(k)){
                    map.put(k,map.get(k)+1);
                }
                else{
                    map.put(k,1);
                }
            }
            int oneTune = vel;
            for (Double d: map.keySet()){
                oneTune = Math.max(map.get(d), oneTune);
                System.out.println(oneTune);
            }
            max = Math.max(oneTune+repeat,max);
        }
        System.out.println(max);
        return max;
    }
}