import java.util.*;
import java.math.*;

/*
1
8
1 1 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 1 1
*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int loop = input.nextInt();
            for (int i = 0;i<loop;i++){
                int num = input.nextInt();
                HashMap<Long,Long> list = new HashMap<>();
                long[][] data = new long[num][3];
                for (int j =  0;j<num;j++){
                    long time = input.nextLong();
                    long id = input.nextLong();
                    long flag = input.nextInt();
                    data[j][0] = time;
                    data[j][1] = id;
                    data[j][2] = flag;
                    if (flag==0){
                        list.put(id,time);
                    }
                    else{
                        long newTime = time - list.get(id);
                        list.put(id,newTime);
                    }
                }
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (Long l : list.keySet()){
                    ArrayList<Long> in = new ArrayList<>();
                    int start = findS(data,l)+1;
                    int end = findE(data,l);
                    while(start<end){
                        long temp = data[start][1];
                        in.add(temp);
                        start = findE(data,temp)+1;
                    }

                    long time =list.get(l);
                    for (int k = 0;k<in.size();k++){
                        time -= list.get(in.get(k));
                    }
                    if (time>max){
                        max = time;
                        min = l;
                    }
                    else if (list.get(l)==max){
                        min = Math.min(min,l);
                    }
                }
                System.out.println(min);
            }
        }
    }
    public static int findS(long[][] data,long target){
        for (int i = 0; i< data.length;i++){
            if (target==data[i][1]){
                return i;
            }
        }
        return 0;
    }
    public static int findE(long[][] data,long target){
        for (int i = data.length-1; i>=0;i--){
            if (target==data[i][1]){
                return i;
            }
        }
        return 0;
    }

}