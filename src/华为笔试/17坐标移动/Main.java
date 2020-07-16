import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            String str = input.nextLine();
            String[] point = str.split(";");
            int x=0,y=0;
            for (String s:point){
                try{
                    int move = Integer.parseInt(s.substring(1,s.length()));
                    if (s.charAt(0)=='A'){
                        x-=move;
                    }
                    else if (s.charAt(0)=='D'){
                        x+=move;
                    }
                    else if (s.charAt(0)=='W'){
                        y+=move;
                    }
                    else if (s.charAt(0)=='S'){
                        y-=move;
                    }
                }
                catch(Exception e){
                    continue;
                }
            }
            System.out.println(x+","+y);
        }
    }
}