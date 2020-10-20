import java.util.*;

public class Main{
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int target = input.nextInt();
        int[] total = new int[num+1];
        for (int i = 0;i<num+1;i++){
            total[i] = i;
        }
        int[][] map = new int[target][2];
        for (int i = 0;i<target;i++){
            for (int j=0;j<2;j++){
                map[i][j] = input.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0;i<target;i++){
            if (!union(map[i][0],map[i][1],total)) sum++;
        }
        System.out.println(sum);
    }
    public static boolean union(int x,int y,int[] list){
        int fatherx = find(x,list), fathery = find(y,list);
        if (fatherx==fathery) return true;
        else{
            list[fatherx] = fathery;
            return false;
        }
    }
    public static int find(int x,int[] list){
        if (list[x] == x){
            return x;
        }
        else{
            return find(list[x],list);
        }
    }
}