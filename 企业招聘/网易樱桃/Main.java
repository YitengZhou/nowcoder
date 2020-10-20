import java.util.HashSet;
import java.util.Scanner;
/*
10 9
1 left 2
1 right 3
2 left 4
2 right 5
3 right 6
6 left 7
6 right 8
7 left 9
7 right 10
*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nodeNum = input.nextInt();
        int bondNum = input.nextInt();
        String[][] map = new String[bondNum][3];
        int[] nodes = new int[nodeNum+1];
        HashSet<Integer> link = new HashSet<>();
        for (int i = 0;i<bondNum;i++){
            for (int j = 0;j<3;j++){
                map[i][j] = input.next();
                if (j==0){
                    nodes[Integer.parseInt(map[i][j])]++;
                    link.add(Integer.parseInt(map[i][j]));
                }
            }
        }
//        for (int i = 0;i<bondNum;i++){
//            for (int j = 0;j<3;j++){
//                System.out.println(map[i][j]);
//            }
//        }
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0;i<nodeNum+1;i++){
            if (nodes[i]==2){
                result.add(i);
            }
        }
        HashSet<Integer> output = new HashSet<>();
        for (Integer x: result){
            for (int i = 0;i<bondNum;i++){
                for (int j = 0;j<3;j++){
                    if (j==0&&x==Integer.parseInt(map[i][j])){
                        int temp1 = Integer.parseInt(map[i][2]);
                        int temp2 = Integer.parseInt(map[i+1][2]);
                        if (!link.contains(temp1) && !link.contains(temp2)){
                            output.add(x);
                        }
                        i++;
                    }
                }
            }
        }
        System.out.println(output.size());
    }
}