package Match笔试.拼多多笔试;
/*
#*****
******
******
******
******
******
* */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int [][] map= new int[8][8];
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    map[i][j] = -1;
                }
            }
            for (int i=0;i<6;i++){
                String str= input.nextLine();
                for (int j =0;j<6;j++){
                    if (str.charAt(j) =='#'){
                        map[i+1][j+1] = 0;
                    }
                    else{
                        map[i+1][j+1] = -1;
                    }
                }
            }
            ArrayList<int[][]> list = new ArrayList<>();
            list.add(map);
            while (check(list.get(0))){
                System.out.println("!!");
                plant(list);
            }
            System.out.println(list.size());
        }
    }

    public static boolean check(int[][] map){
        for (int i=1;i<7;i++){
            for (int j =1;j<7;j++){
                if (map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void plant(ArrayList<int[][]> list){
        int[][] map= list.get(0);
        list.remove(0);
        HashSet<Integer> good= new HashSet<>();
        good.add(1);
        good.add(2);
        good.add(3);
        good.add(4);
        good.add(5);
        good.add(6);
        int x=0,y=0;
        for (int i=1;i<7;i++){
            for (int j =1;j<7;j++){
                if (map[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println(x);
        System.out.println(y);
        // left
        if (map[x-1][y] != -1 || map[x-1][y] != 0) {
            good.remove(map[x-1][y]);
        }
        // right
        if (map[x+1][y] != -1 || map[x+1][y] != 0) {
            good.remove(map[x+1][y]);
        }
        // up
        if (map[x][y-1] != -1 || map[x][y-1] != 0) {
            good.remove(map[x][y-1]);
        }
        // down
        if (map[x][y+1] != -1 || map[x][y+1] != 0) {
            good.remove(map[x][y+1]);
        }
        for (Integer i:good){
            int[][] add = map.clone();
            map[x][y] = i;
            list.add(add);
        }
    }
}