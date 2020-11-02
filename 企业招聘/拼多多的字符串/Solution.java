import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String temp = str;
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        while (str.substring(1).contains(String.valueOf(str.charAt(0)))){
            str = str.substring(1);
            list.add(str);
        }
        Collections.sort(list);
        str = list.get(0);
        while(str.substring(0,str.length()-1).contains(String.valueOf(str.charAt(str.length()-1)))){
            str = str.substring(0,str.length()-1);
        }

        System.out.println(temp.lastIndexOf(str)+" "+str.length());
    }
}