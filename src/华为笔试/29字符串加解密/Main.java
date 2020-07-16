import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String aucP = input.next();
            String aucR = input.next();
            System.out.println(encrypt(aucP));
            System.out.println(unencrypt(aucR));
        }
    }
    private static String encrypt(String aucP){
        char[] password = aucP.toCharArray();
        StringBuffer result = new StringBuffer();
        for (char c:password){
            if (Character.isLowerCase(c)){
                result.append((char)(((c-'a')+1)%26 + 'A'));
            }
            else if (Character.isUpperCase(c)){
                result.append((char)(((c-'A')+1)%26 + 'a'));
            }
            else if (Character.isDigit(c)){
                result.append(((char)(((c-'0')+1)%10 + '0')));
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
    private static String unencrypt(String aucR){
        char[] result = aucR.toCharArray();
        StringBuffer aucResult = new StringBuffer();
        for (char c:result){
            if (Character.isLowerCase(c)){
                aucResult.append((char)(((c-'a')+25)%26 + 'A'));
            }
            else if (Character.isUpperCase(c)){
                aucResult.append((char)(((c-'A')+25)%26 + 'a'));
            }
            else if (Character.isDigit(c)){
                aucResult.append(((char)(((c-'0')+9)%10 + '0')));
            }
        }
        return aucResult.toString();
    }
}