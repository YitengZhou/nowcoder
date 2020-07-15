import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next();
            int[] list = new int[10];
            String out= "";

            for (int i = str.length()-1;i>=0;i--){
                if (list[str.charAt(i)-'0']==0){
                    out +=str.charAt(i);
                    list[str.charAt(i)-'0']++;
                }
            }
            System.out.println(out);
        }
    }
}