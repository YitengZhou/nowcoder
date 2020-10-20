import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner total = new Scanner(System.in);
        String list = "";
        String ch = "";
        list = total.next().toLowerCase();
        ch = total.next().toLowerCase();
        int count = 0;
        for (int i = 0;i<list.length();i++) {
            if (list.charAt(i) == ch.charAt(0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
