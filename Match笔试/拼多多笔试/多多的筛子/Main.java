package Match笔试.拼多多笔试.多多的筛子;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int num = input.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList();
            for (int i=0;i<num;i++){
                ArrayList<Integer> one = new ArrayList();
                one.add(input.nextInt());
                one.add(input.nextInt());
                one.add(input.nextInt());
                one.add(input.nextInt());
                one.add(input.nextInt());
                one.add(input.nextInt());
                list.add(one);
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList();
            for (int i =0;i<num;i++){
                if (result.size()==0){
                    result.add(list.get(i));
                }
                if (check(list.get(i),result)){
                    result.add(list.get(i));
                }
            };
        }
    }
    public boolean check(ArrayList<Integer> one, ArrayList<ArrayList<Integer>> result){
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean same = true;
        for (int i = 0;i<result.size();i++){

        }
    }
}
