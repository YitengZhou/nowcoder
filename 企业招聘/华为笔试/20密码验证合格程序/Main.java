import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String password=input.next();
            if (password.length()<=8){
                System.out.println("NG");
                continue;
            }
            if (!hasLetter(password)){
                System.out.println("NG");
                continue;
            }
            if (hasRepeat(password)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean hasLetter(String p){
        int upper=0;
        int lower=0;
        int digit=0;
        int other=0;
        for (int i=0;i<p.length();i++){
            if (Character.isDigit(p.charAt(i))){
                digit=1;
            }
            else if (Character.isUpperCase(p.charAt(i))){
                upper=1;
            }
            else if(Character.isLowerCase(p.charAt(i))){
                lower=1;
            }
            else{
                other=1;
            }
        }
        return upper + lower + digit + other >= 3;
    }
    private static boolean hasRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1))
                return true;
        }
        return false;
    }
}
