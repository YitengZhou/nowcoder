import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str1 = input.next();
            String str2 = input.next();
            String merge = str1+str2;
            char[] list = merge.toCharArray();
            ArrayList<Character> odd = new ArrayList<>();
            ArrayList<Character> even = new ArrayList<>();
            for (int i=0;i<list.length;i++){
                if (i%2 ==0) even.add(list[i]);
                else odd.add(list[i]);
            }
            Collections.sort(odd);
            Collections.sort(even);
            char[] newlist = new char[list.length];
            for (int i=0;i<even.size();i++){
                newlist[2*i] = even.get(i);
            }
            for (int i = 0;i<odd.size();i++){
                newlist[2*i+1] = odd.get(i);
            }
            StringBuffer output = new StringBuffer();
            for (char c:newlist){
                if (Character.isDigit(c)){
                    output.append(convert(c-'0'));
                }
                else if (c>='a' && c<='f'){
                    output.append(convert(c-'a'+10));
                }
                else if (c>='A' && c<='F'){
                    output.append(convert(c-'A'+10));
                }
                else{
                    output.append(c);
                }
            }
            System.out.println(output);
        }
    }
    private static char convert(int c){
        System.out.println(c);
        String bi = Integer.toBinaryString(c);
        int len = 4-bi.length();
        for (int i = 0;i<len;i++){
            bi = "0"+bi;
        }
        StringBuffer reverse = new StringBuffer(bi);
        int num = Integer.parseInt(reverse.reverse().toString(), 2);
        if (num<10){
            return (char)(num+'0');
        }
        else{
            System.out.println(Character.toUpperCase((char)('a' + num -10)));
            return Character.toUpperCase((char)('a' + num -10));
        }
    }
}