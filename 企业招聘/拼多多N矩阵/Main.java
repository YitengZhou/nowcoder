import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] result = new int[num][num];
        float mid = num/2;
        for (int i = 0;i<num;i++){
            for (int j=0;j<num;j++){
                if (i==j || i+j == num-1){
                    result[i][j] = 0;
                }
                else if (i<mid&&j<mid){
                    if (j>i){
                        result[i][j] = 2;
                    }
                    else{
                        result[i][j] = 3;
                    }
                }
                else if (i<mid&&j>=mid){
                    if (i<num-1-j){
                        result[i][j]=1;
                    }
                    else {
                        result[i][j] = 8;
                    }
                }
                else if (i>=mid&&j<mid){
                    if (i+j<num){
                        result[i][j]=4;
                    }
                    else{
                        result[i][j]=5;
                    }
                }
                else if (i>=mid&&j>=mid){
                    if (i>j){
                        result[i][j]=6;
                    }
                    else{
                        result[i][j]=7;
                    }
                }
            }
        }
        if (num%2==1){
            int m = num/2;
            for (int i =0;i<num;i++){
                result[i][m] = 0;
                result[m][i] = 0;
            }
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0;i<num;i++){
            for (int j = 0;j<num;j++){
                str.append(result[i][j]+" ");
            }
            str.append("\n");
        }
        System.out.println(str);
    }
}