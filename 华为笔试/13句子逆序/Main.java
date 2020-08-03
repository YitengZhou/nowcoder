import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            String str = input.nextLine();
            String[] list = str.split(" ");
            String out = "";
            for (int i=list.length-1;i>=0;i--){
                out += list[i] + " ";
            }
            System.out.println(out);
        }
    }
}