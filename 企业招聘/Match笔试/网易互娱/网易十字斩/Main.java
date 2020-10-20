import java.util.*;
/*
1 0 0
0 10 10
0 10 10
*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int size = input.nextInt();
            // 行列起始为1,行sum存0,列sum存0
            int[][] map = new int[size+1][size+1];
            for (int i =1;i<size+1;i++){
                for (int j = 1;j<size+1;j++){
                    map[i][j] = input.nextInt();
                    map[i][0]+=map[i][j];
                    map[0][j]+=map[i][j];
                }
            }
            int count = size;
            ArrayList<String> result = new ArrayList<>();
            while(count>0){
                map = findMax(map,result);
                count--;
            }
            for (String s:result){
                System.out.println(s);
            }
//            //print
//            StringBuffer s = new StringBuffer();
//            for (int i =0;i<size+1;i++){
//                for (int j = 0;j<size+1;j++){
//                    s.append(map[i][j]+" ");
//                }
//                s.append("\n");
//            }
//            System.out.println(s);
        }
    }

    public static int[][] findMax(int[][] map, ArrayList<String> results){
        int size = map.length;
        int maxR = 1;
        int maxC = 1;
        int maxVal = map[0][1]+map[1][0]-map[1][1];
        for (int i =1;i<size;i++){
            for (int j = 1;j<size;j++){
                if (map[0][j]+map[i][0]-map[i][j]>maxVal){
                    maxR = i;
                    maxC = j;
                    maxVal = map[0][j]+map[i][0]-map[i][j];
                }
            }
        }
        String one = new String(""+ maxR + " "+maxC);
        results.add(one);
        // change
        int[][] update = new int[size-1][size-1];
        for (int i = 1;i<size;i++){
            if (i<maxR){
                for (int j = 1;j<size;j++){
                    if (j<maxC){
                        update[i][j] = map[i][j];
                    }
                    else if (j==maxC) continue;
                    else{
                        update[i][j-1] = map[i][j];
                    }
                }
            }
            else if (i == maxR) continue;
            else{
                for (int j = 1;j<size;j++){
                    if (j<maxC){
                        update[i-1][j] = map[i][j];
                    }
                    else if (j==maxC) continue;
                    else{
                        update[i-1][j-1] = map[i][j];
                    }
                }
            }
        }
        for (int i = 0;i<size;i++){
            if (i<maxR){
                update[i][0] = map[i][0] - map[i][maxC];
            }
            else if (i>maxR){
                update[i-1][0] = map[i][0] - map[i][maxC];
            }
        }
        for (int i = 0;i<size;i++){
            if (i<maxC){
                update[0][i] = map[0][i] - map[maxR][i];
            }
            else if (i>maxC){
                update[0][i-1] = map[0][i] - map[maxR][i];
            }
        }
        return update;
    }
}