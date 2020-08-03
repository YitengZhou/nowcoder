import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int i,j;
        boolean array[]=new boolean[s.length()+1];//此处的Array大小
        array[0]=true;//此处的初始化
        for (boolean b: array){
            System.out.println(b+" ");
        }
        for(i=1;i<array.length;i++) {
            for(j=0;j<i;j++) {
                System.out.println(j+"-"+i);
                System.out.println(s.substring(j, i));
                if(array[j]&&dict.contains(s.substring(j, i))) {
                    System.out.println(j+"-"+i+"!!");
                    array[i]=true;//此处的SubString
                    break;
                }
            }
        }
        return array[array.length-1];//此处的返回值
    }
}