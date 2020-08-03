import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            for (int i =0;i<num;i++){
                String str = input.next();
                // 例如本处(.)表示集合 \\1(集合中的字符1),{2,}重复两次以上
                System.out.println(str.replaceAll("(.)\\1{2,}","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
                // 也可以如下
                System.out.println(str.replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1+(.)\\2","$1$1$2"));
            }
        }
    }
}