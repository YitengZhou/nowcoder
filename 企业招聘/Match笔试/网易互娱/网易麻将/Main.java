import java.util.*;
// 1T 4T 7T 2B 5B 8B 9W
// 1T 2T 3T 4T 5T 6T 7T
// 1B 2W 3T 4B 5W 6T 8W
// 2B 8B 5B 2B 6T 7W 4W
/*
1T 4T 7T 2B 5B 8B 9W
1T 2T 3T 4T 5T 6T 7T
1B 2W 3T 4B 5W 6T 8W
2B 8B 5B 2B 6T 7W 4W
*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num = input.nextInt();
            for (int i =0;i<num;i++){
                ArrayList<Integer> t= new ArrayList<>();
                ArrayList<Integer> b= new ArrayList<>();
                ArrayList<Integer> w= new ArrayList<>();
                for (int j = 0;j<7;j++){
                    String one = input.next();
                    if (one.toLowerCase().charAt(1)=='t'){
                        t.add(one.charAt(0)-'0');
                    }else if (one.toLowerCase().charAt(1)=='b'){
                        b.add(one.charAt(0)-'0');
                    }
                    else{
                        w.add(one.charAt(0)-'0');
                    }
                }
                if (t.size()==0||b.size()==0||w.size()==0||t.size()>=4||b.size()>=4||w.size()>=4){
                    System.out.println("NO");
                    continue;
                }
                HashSet<Integer> map = new HashSet<>();
                for (Integer in: t){
                    map.add(in);
                }
                for (Integer in: w){
                    map.add(in);
                }
                for (Integer in: b){
                    map.add(in);
                }
                if (map.size()!=7){
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }
        }
    }
}
