import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int index = 0;
        int[] list = new int[m*n];
        while (index < m*n){
            list[index++] = input.nextInt();
        }
        Arrays.sort(list);
        int[][] result = new int[m][n];
        // 螺旋赋值
        index = 0;
        int up = 0, down = m-1, left = 0, right = n-1;
        while (index<m*n){
            // up
            for (int i = left;i<=right;i++){
                result[up][i] = list[index++];
            }
            up++;
            // right
            for (int i = up;i<=down;i++){
                result[i][right] = list[index++];
            }
            right--;
            // down
            for (int i = right;i>=left;i--){
                result[down][i] = list[index++];
            }
            down--;
            // left
            for (int i = down;i>=up;i--){
                result[i][left] = list[index++];
            }
            left++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}