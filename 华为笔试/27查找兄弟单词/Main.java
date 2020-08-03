import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num = input.nextInt();
            IdentityHashMap<String,String> m= new IdentityHashMap<>();
            for (int i=0;i<num;i++){
                String word = input.next();
                String value = getValue(word);
                m.put(word,value);
            }
            String searchWord = input.next();
            String searchValue = getValue(searchWord);
            ArrayList<String> output = new ArrayList<>();
            int count = 0;
            for (String c:m.keySet()){
                if (m.get(c).equals(searchValue) && !c.equals(searchWord)){
                    count++;
                    output.add(c);
                }
            }
            System.out.println(count);
            int outputNum = input.nextInt();
            if (count!=0 && outputNum<=output.size()){
                Collections.sort(output);
                System.out.println(output.get(outputNum-1));
            }
        }
    }

    public static String getValue(String word){
        char[] chr = word.toCharArray();
        ArrayList<Character> val = new ArrayList<>();
        for (char c:chr){
            val.add(c);
        }
        Collections.sort(val);
        StringBuffer v = new StringBuffer();
        for (int j=0;j<val.size();j++){
            v.append(val.get(j));
        }
        return v.toString();
    }
}