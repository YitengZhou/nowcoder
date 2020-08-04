public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] a= new int[2][2];
//        a[0][0] = 1;
//        a[0][1] = 0;
//        a[1][0] = 0;
//        a[1][1] = 1;
//        System.out.println(s.canFinish(2,a));
        int[][] b= new int[1][2];
        b[0][0] =0;
        b[0][1] =1;
        System.out.println(s.canFinish(2,b));
    }
}
