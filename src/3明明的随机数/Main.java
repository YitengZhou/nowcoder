// TreeSet
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int totalNumber = input.nextInt();
            TreeSet<Integer> set= new TreeSet<>();
            for (int i = 0;i<totalNumber;i++) {
                int number = input.nextInt();
                set.add(number);
            }
            for (Integer i : set){
                System.out.println(i);
            }
        }
    }
}
