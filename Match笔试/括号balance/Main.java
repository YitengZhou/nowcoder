import java.util.*;
import java.math.*;
//"()(((())())()()(())(()()(()))())))(())(())(())(())"
//(())((((())()()()())()((((()))))

public class Main{
    public static void main(String[] args){
        Scanner  input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next();
            char[] chr = str.toCharArray();
            int left = 0,right = 0;
            for (char c:chr){
                if (c =='('){
                    left++;
                }
                else{
                    right++;
                }
            }
            if (str.length()%2 ==1 || Math.abs(right-left)!=2){
                System.out.println(0);
                continue;
            }
            int num = 0;
//            if (left<right) {
//                num = match(str,')','(');
//            }
//            else{
//                num = match(str,'(',')');
//            }
//            System.out.println(num);
            if (left<right) {
                int le = 0,ri=0;
                for (int i = str.length()-1;i>=0;i--){
                    if (str.charAt(i) =='('){
                        le++;
                    }
                    else{
                        ri++;
                    }
                    if (le == ri) le = ri =0;
                    if (le>ri) {
                        System.out.println(0);
                        break;
                    }
                }
                if (ri-le ==2){
                    System.out.println(ri-1);
                }
            }
            else{
                int le = 0,ri=0;
                for (int i=0;i<str.length();i++){
                    if (str.charAt(i) =='('){
                        le++;
                    }
                    else{
                        ri++;
                    }
                    if (le == ri) le = ri =0;
                    if (ri>le) {
                        System.out.println(0);
                        break;
                    }
                }
                if (le-ri ==2){
                    System.out.println(le-1);
                }
            }
        }
    }
//    public static int match(String str,char before,char after){
//        int num=0;
//        for (int i =0;i<str.length();i++){
//            if (str.charAt(i) == before){
//                StringBuilder cope = new StringBuilder(str);
//                cope.setCharAt(i, after);
//                String n= cope.toString();
//                if (isOK(n)){
//                    System.out.println(n);
//                    num++;
//                }
//            }
//        }
//        return num;
//    }
//    public static boolean isOK(String cope){
//        int left=0;
//        int right=0;
//        for (int i = 0;i<cope.length();i++){
//            if (cope.charAt(i)=='('){
//                left++;
//            }
//            else{right++;}
//            if (right>left){
//                return false;
//            }
//        }
//        return true;
//    }
}