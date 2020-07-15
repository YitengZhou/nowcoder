import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            double num = input.nextDouble();
            System.out.println(Math.round(num));
        }
    }
}