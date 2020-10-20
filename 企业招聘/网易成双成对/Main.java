import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        // a,b,c,x,y,z
        int start = find(str,0);
        if(start == str.length()){
            System.out.println(start);
            return;
        }
        int end = 0;
        int[] one = new int[6];
        int max = 0;
        for (int i = start;i<str.length();i++){
            if (str.charAt(i)=='a'){
                one[0]++;
            }
            else if (str.charAt(i)=='b'){
                one[1]++;
            }
            else if (str.charAt(i)=='c'){
                one[2]++;
            }
            else if (str.charAt(i)=='x'){
                one[3]++;
            }
            else if (str.charAt(i)=='y'){
                one[4]++;
            }
            else if (str.charAt(i)=='z'){
                one[5]++;
            }
            if (check(one)){
                end = i;
            }
        }
        if (end ==0){
            System.out.println(start);
            return;
        }
        max = end-start+1;
        while (start<str.length()){
        start = find(str,start+1);
        int[] list = new int[6];
        for (int i = start;i<str.length();i++){
            if (str.charAt(i)=='a'){
                list[0]++;
            }
            else if (str.charAt(i)=='b'){
                list[1]++;
            }
            else if (str.charAt(i)=='c'){
                list[2]++;
            }
            else if (str.charAt(i)=='x'){
                list[3]++;
            }
            else if (str.charAt(i)=='y'){
                list[4]++;
            }
            else if (str.charAt(i)=='z'){
                list[5]++;
            }
            if (check(list)){
                end = i;
            }
        }
        max = Math.max(max,end-start+1);
    }
        System.out.println(max);
}
    public static int find(String str, int index){
        for (int i = index;i<str.length();i++){
            if (str.charAt(i)=='a'||str.charAt(i)=='b'||str.charAt(i)=='c'||
                    str.charAt(i)=='x'||str.charAt(i)=='y'||str.charAt(i)=='z'){
                return i;
            }
        }
        return str.length();
    }

    public static boolean check(int[] list){
        for (int i = 0;i<6;i++){
            if (list[i]%2!=0){
                return false;
            }
        }
        return true;
    }
}