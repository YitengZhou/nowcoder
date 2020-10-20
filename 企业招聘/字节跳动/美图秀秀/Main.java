package 字节跳动.美图秀秀;

import java.util.*;
//2 3
//101011
//2 1

//4 5
//10101111010010000100
//2 1
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int row = input.nextInt();
            int col = input.nextInt();
            ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
            String point = input.next();
            for (int i =0;i<row;i++){
                ArrayList<Integer> newRow = new ArrayList<>();
                for (int j=0;j<col;j++){
                    if (point.charAt(i*col+j)=='0'){
                        newRow.add(0);
                    }
                    else{
                        newRow.add(1);
                    }
                }
                map.add(newRow);
            }
            // print map
            String output= "";
            for (int i = 0;i<map.size();i++){
                for (Integer j:map.get(i)){
                    output += j +" ";
                }
                output += "\n";
            }
            // all points
            String all= "";
            int x= input.nextInt();
            int y = input.nextInt();
            int le = findLeft(map,x,y);
            int ri = findRight(map,x,y);
            for (int i = x-le;i<=x +ri;i++){
                int to = findTop(map,i,y);
                int down = findDown(map,i,y);
                for (int j = y-to;j<=y+down;j++){
                    all += "("+ i + "," + j + ") ";
                }
            }
            System.out.println(all);
        }
    }
    public static int findLeft(ArrayList<ArrayList<Integer>>map,int x, int y){
        int flag = map.get(y).get(x);
        boolean point = true;
        int count = 0;
        while (x>0 && point){
            int val = map.get(y).get(x-1);
            if (val !=flag){
                break;
            }
            else{
                count++;
                x--;
            }
        }
        return count;
    }

    public static int findRight(ArrayList<ArrayList<Integer>>map,int x, int y){
        int flag = map.get(y).get(x);
        boolean point = true;
        int count = 0;
        while (x<map.get(0).size()-1 && point){
            int val = map.get(y).get(x+1);
            if (val !=flag){
                break;
            }
            else{
                count++;
                x++;
            }
        }
        return count;
    }

    public static int findTop(ArrayList<ArrayList<Integer>>map,int x, int y){
        int flag = map.get(y).get(x);
        boolean point = true;
        int count = 0;
        while (y>0 && point){
            int val = map.get(y-1).get(x);
            if (val !=flag){
                break;
            }
            else{
                count++;
                y--;
            }
        }
        return count;
    }

    public static int findDown(ArrayList<ArrayList<Integer>>map,int x, int y){
        int flag = map.get(y).get(x);
        boolean point = true;
        int count = 0;
        while (y<map.size()-1 && point){
            int val = map.get(y+1).get(x);
            if (val !=flag){
                break;
            }
            else{
                count++;
                y++;
            }
        }
        return count;
    }
}
