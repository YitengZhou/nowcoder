package LeetCode.回文序列;

import java.util.*;


public class Solution {
    /**
     *
     * @param s string字符串 
     * @return string字符串ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<String>> partition (String s) {
        // write code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (s==null ||s.length()==0){
            return result;
        }
        solves(s,0,new ArrayList<String>(),result);
        return result;
    }
    public void solves(String s, int n, ArrayList<String> one,ArrayList<ArrayList<String>> result){
        if (n==s.length()){
            result.add(new ArrayList<String>(one));
            return;
        }
        ArrayList<String> list = new ArrayList<String>(one);
        for (int i = n+1;i<=s.length();i++){
            System.out.println(s.substring(n,i) + "!");
            if (isPartition(s.substring(n,i))){
                list.add(s.substring(n,i));
                for (String str:list){
                    System.out.println(str);
                }
                solves(s,i,list,result);
                for (String str:list){
                    System.out.println("second  " + str);
                }
                list.remove(list.size()-1);
                for (String str:list){
                    System.out.println("third  " + str);
                }
            }
        }
    }

    public boolean isPartition(String s){
        if (s==null){
            return false;
        }
        int l = 0, r = s.length()-1;
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}