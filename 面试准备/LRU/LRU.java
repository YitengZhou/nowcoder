import java.util.*;


public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        //true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在尾部，最老访问的放在头部。
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>((int)Math.ceil(k/0.75)+1, 0.75f, true);
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] op : operators){
            if (op[0] == 1){
                if (map.size()==k){
                    map.remove(map.keySet().iterator().next());
                }
                map.put(op[1],op[2]);
            }
            else{
                if (map.containsKey(op[1])){
                    result.add(map.get(op[1]));
                }
                else{
                    result.add(-1);
                }
            }
        }
        int[] op = new int[result.size()];
        int index = 0;
        for (Integer i: result){
            op[index++] = i;
        }
        return op;
    }
}