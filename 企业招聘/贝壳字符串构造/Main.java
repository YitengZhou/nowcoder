import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String str = input.next();
        int mid = num/2;
        int copy = 0;
        for (int i =mid;i>=0;i--){
            if (str.substring(0,i).equals(str.substring(i,2*i))){
                copy = i-1;
                break;
            }
        }

        System.out.println(num-copy);
    }
}


