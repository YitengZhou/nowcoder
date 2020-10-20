import java.util.*;
public class Solution {
    /**
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean Game24Points (int[] arr) {
        // write code here
        char[] ch = new char[]{'+','-','*','/'};
        for (int i =0;i<4;i++){
            for (int j= 0;j<4;j++){
                for (int k = 0;k<4;k++){
                    if (getNum(arr,ch[i],ch[j],ch[k])==24){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getNum(int[] arr,char f, char s, char t){
        int num1,num2,num3;
        // first
        if (f=='+'){
            num1 = arr[0]+arr[1];
        }
        else if (f=='-'){
            num1 = arr[0]-arr[1];
        }
        else if (f=='*'){
            num1 = arr[0]*arr[1];
        }
        else{
            num1 = arr[0]/arr[1];
        }
        //secondMain.class
        //Main.java
        //Sort.class
        //Sort.java
        if (s=='+'){
            num2 = num1 + arr[2];
        }
        else if (s=='-'){
            num2 = num1 - arr[2];
        }
        else if (s=='*'){
            num2 = num1 * arr[2];
        }
        else{
            num2 = num1 / arr[2];
        }
        // third
        if (t=='+'){
            num3 = num2 + arr[3];
        }
        else if (t=='-'){
            num3 = num2 - arr[3];
        }
        else if (t=='*'){
            num3 = num2 * arr[3];
        }
        else{
            num3 = num2 / arr[3];
        }
        return num3;
    }
}