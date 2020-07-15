import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str= input.next();
            int count = 0;
            int[] list = new int[128];
            for (int i=0;i<str.length();i++){
                int val = Integer.valueOf(str.charAt(i));
                if (val>=0 && val <128 && list[val]==0){
                    list[val]++;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}