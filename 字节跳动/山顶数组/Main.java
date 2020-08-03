package 字节跳动.山顶数组;

import java.util.*;
// 1,2,2,5,10,9,8,2,1,1
// 1,2,2,2,4,75,95,100,99,88,78,78,78,78,78,2,2,2,2,2,1,1,1
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            String[] list = str.split(",");
            int right = list.length-1;
            int left = 0;
            String output= "";
            int min= Math.min(Integer.parseInt(list[left]),Integer.parseInt(list[right]));
            while (left<=right){
                while (Integer.parseInt(list[left])==min){
                    left++;
                }
                while (Integer.parseInt(list[right])==min){
                    right--;
                }
                output += min + ",";
                min= Math.min(Integer.parseInt(list[left]),Integer.parseInt(list[right]));
            }
            System.out.println(output.substring(0,output.length()-1));
        }
    }
}
