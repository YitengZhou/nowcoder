package LeetCode.word_break2;

import java.util.*;
// 太难了
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        boolean[][] dp = getDP(s,dict);
        return getSolutions(dp,s,0);
    }
    public boolean[][] getDP(String s, Set<String> dict){
        int len = s.length();
        boolean[][] dp = new boolean[len][];
        for (int i=len-1;i>=0;i--){
            int row = len - i;
            dp[i] = new boolean[row];
            for(int j = 0;j<row;j++){
                String str = s.substring(len-i-j-1,len-i);
//                System.out.println(str+i+"-"+j);
                if (dict.contains(str)){
                    dp[i][j]=true;
                }
            }
        }
        return dp;
    }
    public ArrayList<String> getSolutions(boolean[][] dp,String s,int layer){
        ArrayList<String> all = new ArrayList<>();
        if(layer >= s.length()) {
            return all;
        }
        int rowLen = dp[layer].length;
        for(int i = 0; i < rowLen; i++){
            ArrayList<String> solutions = new ArrayList<>();
            if(dp[layer][i]) {
                String word = s.substring(rowLen - i - 1, rowLen);
//                System.out.println(word+"!");
                int wc = layer + word.length();
                if (wc == s.length()){
                    solutions.add(word);
                    all.addAll(solutions);
                }
                else{
                    ArrayList<String> ret = getSolutions(dp, s, wc);
                    if (!ret.isEmpty()){
                        for(String str : ret) {
                            solutions.add(str + " " + word);
                        }
                        all.addAll(solutions);
                    }
                }
            }
        }
        return all;
    }
}