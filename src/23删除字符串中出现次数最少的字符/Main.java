import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String s = input.next();
            char[] list = s.toCharArray();
            HashMap<Character,Integer> charMap= new LinkedHashMap<>();
            for (char c:list){
                if (charMap.containsKey(c)){
                    charMap.put(c,charMap.get(c)+1);
                }
                else{
                    charMap.put(c,1);
                }
            }
            Collection<Integer> val = charMap.values();
            int min = Collections.min(val);
            StringBuffer output = new StringBuffer();
            for (char c:list){
                if (charMap.get(c)==min){
                    continue;
                }
                else{
                    output.append(c);
                }
            }
            System.out.println(output);
        }
    }
}