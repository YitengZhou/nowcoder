import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        int count = input.nextInt();
        HashSet<Long> map = new HashSet<>();
        int index = 0;
        while (index!=count){
            int temp = input.nextInt();
            long start = temp;
            while(start<=num){
                map.add(start);
                start+=temp;
            }
            index++;
        }
        System.out.println(map.size());
    }
}