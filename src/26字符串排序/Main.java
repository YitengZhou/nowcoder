import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            char[] chr = str.toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0;i<str.length();i++){
                if (Character.isLetter(str.charAt(i))){
                    list.add(str.charAt(i));
                }
            }
            Collections.sort(list,new Comparator<Character>(){
                public int compare(Character c1, Character c2){
                    return Character.toLowerCase(c1)-Character.toLowerCase(c2);
                }
            });
            int cnt = 0;
            for (int i=0;i<str.length();i++){
                if (Character.isLetter(str.charAt(i))){
                    chr[i]=list.get(cnt);
                    cnt++;
                }
            }
            System.out.println(chr);
        }
    }
}