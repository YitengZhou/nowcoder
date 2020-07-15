import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            ArrayList<String> dic = new ArrayList<>();
            int loop = input.nextInt();
            for (int i = 0;i<loop;i++){
                String word = input.next();
                dic.add(word);
            }
            Collections.sort(dic);
            for (String w : dic){
                System.out.println(w);
            }
        }
    }
}
