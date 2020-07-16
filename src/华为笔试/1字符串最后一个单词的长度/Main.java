import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String str = "";
        while (input.hasNext()){
            str = input.next();
        }
        System.out.println(str.length());
    }
}
