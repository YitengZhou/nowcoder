package 字节跳动.区间计算值;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        if (input.hasNext()){
            int num = input.nextInt();
            int[] list = new int[num];
            for (int i =0;i<num;i++){
                list[i] = input.nextInt();
            }
            int max =0;
            for (int i =0;i<num;i++){
                int add = 0;
                // left
                for (int j = i;j>=0;j--){
                    if (list[j]>=list[i]){
                        add += list[j];
                    }
                    else{
                        break;
                    }
                }
                // right
                for (int j = i+1;j<num;j++){
                    if (list[j]>=list[i]){
                        add += list[j];
                    }
                    else{
                        break;
                    }
                }
                if (add*list[i]>max){
                    max= add*list[i];
                }
            }
            System.out.println(max);
        }
    }
}