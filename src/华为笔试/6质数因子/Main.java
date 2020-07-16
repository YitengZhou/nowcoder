import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);
        while (number.hasNext()){
            long num = number.nextLong();
            String str = "";
            while (num !=1){
                for (int i = 2;i<=num;i++){
                    if (num % i==0){
                        str += i + " ";
                        num /= i;
                        break;
                    }
                }
            }
            System.out.println(str);
        }
    }
}