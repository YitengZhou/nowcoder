import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next();
            StringBuffer strR = new StringBuffer(str);
            System.out.println(strR.reverse().toString());
        }
    }
}