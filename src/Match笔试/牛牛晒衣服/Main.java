package Match比赛.牛牛晒衣服;

public class Main{
    public static void main(String[] args){
        Solution s = new Solution();
        int n = 3;
        int[] a = new int[3];
        a[0] = 8;
        a[1]= 8;
        a[2] =8;
        int k=5;
        System.out.println(s.solve(n,a,k));
    }
}
