import java.io.BufferedReader;
import java.util.*;
// 5 3 2 1 5, 21345
// 5 2 4 2, 13425
// 3 3 7 4 3,743
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int numT = input.nextInt();
            int numO = input.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            int[] result = new int[numT];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i =0;i<numO;i++){
                int n = input.nextInt();
                if (n<min){
                    min = n;
                }
                if (n>max){
                    max=n;
                }
                list.add(n);
            }
            TreeSet<Integer> pool = new TreeSet<>();
            int poolnum = (max>=numT)? max:numT;
            for (int i = 1;i<=poolnum;i++){
                pool.add(i);
            }
            int o = 0;
            int j = 0;
            while (j<numT&&o<numO){
                Iterator one = pool.iterator();
                int x = list.get(o);
                while (one.hasNext()){
                    int n = (int) one.next();
                    if (n<list.get(o)){
                        if (!list.contains(n)){
                            result[j++] = n;
                            pool.remove(n);
                            break;
                        }
                    }
                    else{
                        result[j++] = list.get(o);
                        pool.remove(list.get(o));
                        o++;
                        break;
                    }
                }
            }
            Iterator one = pool.iterator();
            while (j<numT){
                result[j++] = (int) one.next();
            }
            while (o<numO){
                result[result.length-(numO-o)]=list.get(o);
                o++;
            }
            StringBuffer out = new StringBuffer();
            for (int i = 0;i<numT;i++){
                if (i == numT-1){
                    out.append(result[i]);
                }
                else{
                    out.append(result[i] + " ");
                }
            }
            System.out.println(out);
        }
    }
}
