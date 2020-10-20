import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num = input.nextInt();
            int[] a = new int[1000];
            for (int i=0;i<num;i++){
                int key = input.nextInt();
                int value = input.nextInt();
                a[key] +=value;
            }
            for (int i=0;i<1000;i++){
                if (a[i]!=0){
                    System.out.println(""+i+" "+a[i]);
                }
            }
        }
    }
}