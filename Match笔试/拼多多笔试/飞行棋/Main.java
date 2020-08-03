package Match笔试.拼多多笔试.飞行棋;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int step = input.nextInt();
            if (step == 0){
                System.out.println("paradox");
                break;
            }
            int num = input.nextInt();
            int back = 0;
            boolean flag = true;
            for (int i=0;i<num;i++){
                int now = input.nextInt();
                if (now >6 || now <0){
                    break;
                }
                if (step==now){
                    flag = false;
                    System.out.println("paradox");
                    break;
                }
                else if (step>now){
                    step-=now;
                }
                else {
                    step = now -step;
                    back++;
                }
            }
            if (flag){
                System.out.println(step + " " + back);
            }
        }
    }
}
