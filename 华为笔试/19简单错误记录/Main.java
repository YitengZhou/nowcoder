import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> map =new LinkedHashMap<String, Integer>();
        while (input.hasNext()){
            String file = input.next();
            int lineNum = input.nextInt();
//            String[] list = str.split("\\s+");
            String[] list = file.split("\\\\");
            String fileName = list[list.length-1];
            if (fileName.length()>16){
                fileName = fileName.substring(fileName.length()-16);
            }
            String key = fileName + " " + lineNum;
            int value =1;
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,value);
            }
        }
        int count =0;
        for (String s: map.keySet()){
            count++;
            if (count>(map.keySet().size()-8)){
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}
