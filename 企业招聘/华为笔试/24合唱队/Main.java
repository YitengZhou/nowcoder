import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<num;i++){
                list.add(input.nextInt());
            }
            int[] left = leftMax(list);
            int[] right = rightMax(list);
            int[] result = new int[list.size()];
            int max=0;
            for (int i=0;i<list.size();i++){
                result[i]= left[i]+right[i]-1;
                if (max<result[i]){
                    max=result[i];
                }
            }
            System.out.println(num-max);
        }
    }

    private static int[] leftMax(ArrayList<Integer> list){
        int[] left = new int[list.size()];
        left[0]=1;
        for (int i=1;i<list.size();i++){
            left[i]=1;
            for (int j=0;j<i;j++){
                if (list.get(j)<list.get(i) && left[j]+1>left[i]){
                    left[i]=left[j]+1;
                }
            }
        }
        return left;
    }
    private static int[] rightMax(ArrayList<Integer> list){
        int num = list.size();
        int[] right = new int[num];
        right[num-1]=1;
        for (int i=num-2;i>=0;i--){
            right[i]=1;
            for (int j=num-1;j>i;j--){
                if (list.get(j)<list.get(i) && right[j]+1>right[i]){
                    right[i]=right[j]+1;
                }
            }
        }
        return right;
    }
}