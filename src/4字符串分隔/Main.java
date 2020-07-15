import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = "";
        while (input.hasNext()){
            str = input.next();
            while (str.length()>8){
                System.out.println(str.substring(0,8));
                str = str.substring(8);
            }
            if (str.length()>0){
                System.out.print(str);
                for (int i=0;i<8-str.length();i++){
                    System.out.print("0");
                }
                System.out.print("\n");
            }
        }
    }
}
