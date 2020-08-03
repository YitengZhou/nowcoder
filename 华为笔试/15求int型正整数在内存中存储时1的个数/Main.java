import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num = input.nextInt();
            int count =0;
            while (num>0){
                if ((num&1)>0){
                    count++;
                }
                num=num>>1;
            }
            System.out.println(count);
        }
    }
}
