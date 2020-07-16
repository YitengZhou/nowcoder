import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            HashMap<Integer,Integer> match= new HashMap<>();
            for (int i= 0;i<num;i++){
                int newNum=input.nextInt();
                if (newNum%2==0){
                    even.add(newNum);
                }
                else{
                    odd.add(newNum);
                }
            }
            int[] evenMatch = new int[even.size()];
            int result=0;
            for (int i=0;i<odd.size();i++){
                int[] used = new int[even.size()];
                if (find(odd.get(i),even,used,evenMatch)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    public static boolean isPrime(int num){
        for (int i=2;i<num/2;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean find(int odd, ArrayList<Integer> even, int[] used, int[] evenMatch){
        for (int i=0;i<even.size();i++){
            if (isPrime(odd+even.get(i))&&used[i]==0){
                used[i]=1;
                if (evenMatch[i]==0||find(evenMatch[i],even,used,evenMatch)){
                    evenMatch[i]=odd;
                    return true;
                }
            }
        }
        return false;
    }
}