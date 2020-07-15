import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            if (num==0){
                break;
            }
            else{
                int change = num/3;
                int retainNum = num/3 + num%3;
                while (retainNum>=3){
                    change +=retainNum/3;
                    retainNum = retainNum/3 + retainNum%3;
                }
                if (retainNum == 2){
                    change++;
                }
                System.out.println(change);
            }
        }
    }
}