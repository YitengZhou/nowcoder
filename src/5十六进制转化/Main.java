import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next().substring(2);
            int number = Integer.parseInt(str,16);
            System.out.println(number);
        }
    }
}