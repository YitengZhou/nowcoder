import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            long[] wood = new long[n];
            for (int i =0;i<n;i++){
                wood[i] = input.nextInt();
            }
            int count =0;
            boolean flag = false;
            while (!flag){
                int i = 0;
                // find 1
                while(i<n&&wood[i]==0){
                    i++;
                }
                // no 1 break;
                if (i==n) {
                    flag = true;
                    break;
                }
                // -1
                while (i<n && wood[i]>0){
                    wood[i]-=1;
                    i++;
                }
                count++;
            }
            if (count >n){
                System.out.println(n);
            }else{
                System.out.println(count);
            }
        }
    }
}

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] list = new long[n];
        for (int i =0;i<n;i++){
            list[i] = input.nextLong();
            System.out.println(max(list[i]));
        }
    }
    public static long max(long number){
        int count = Long.toString(number).length()-1;
        long left = 0;
        for (int i =0;i<count;i++){
            left*=10;
            left+=9;
        }
        return val(left) + val(number-left);
    }
    public static long val(long num){
        long sum = 0;
        while(num>0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        int index = input.nextInt();
        LinkedList<String> list = new LinkedList<>();
        for (int i =0;i<str.length();i++){
            for (int j = i+1;j<=str.length();j++){
                add(list,str.substring(i,j));
            }
        }
        System.out.println(list.get(index-1));
    }
    public static void add(LinkedList<String> list, String subString){
        if (list.size()==0){
            list.add(subString);
            return;
        }
        if (list.contains(subString)) {
            return;
        }
        int i = 0;
        while(i< list.size() && list.get(i).compareTo(subString)<0){
            i++;
        }
        list.add(i,subString);
        if (list.size()>5){
            list.remove(5);
        }
    }
}