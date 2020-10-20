import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        long[] list = new long[num];
        for (int i =0;i<num;i++){
            list[i] = input.nextLong();
        }
        long[] list2 = Arrays.copyOfRange(list,0,num);
        Arrays.sort(list2);
        int mid = num/2;
        for (int i = 0;i<num;i++){
            if (list[i]>=list2[mid]){
                System.out.println(list2[mid-1]);
            }
            else{
                System.out.println(list2[mid]);
            }
        }
    }
}