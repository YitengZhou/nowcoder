import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for (int i=0;i<num;i++){
            String meileft = input.next();
            String meiright = input.next();
            String niuleft = input.next();
            String niuright = input.next();
            int leftWin = identify(meileft,niuleft,niuright);
            int rightWin = identify(meiright,niuleft,niuright);
            System.out.println(leftWin);
            System.out.println(rightWin);
            if (leftWin>rightWin){
                System.out.println("left");
            }
            else if (rightWin>leftWin){
                System.out.println("right");
            }
            else{
                System.out.println("same");
            }
        }
    }
    public static int identify(String mei, String niuleft, String niuright){
        int win = 0;
        if (mei.equals("J")){
            if (niuleft.equals("B")) win++;
            if (niuright.equals("B")) win++;
        }
        else if (mei.equals("S")){
            if (niuleft.equals("J")) win++;
            if (niuright.equals("J")) win++;
        }
        else{
            if (niuleft.equals("S")) win++;
            if (niuright.equals("S")) win++;
        }
        return win;
    }
}


