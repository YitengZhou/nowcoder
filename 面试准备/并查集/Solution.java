import java.util.*;
class Solution {
    public int findCircleNum(int[][] M) {
        int num = M.length;
        // 设定一个数组，每个数字指向它自己
        int[] list = new int[num];
        for (int i =0;i<num;i++){
            list[i] = i;
        }
        // 进行赋值指向祖先，当祖先不相同时，更换祖先指向
        for (int i =0;i<num;i++){
            for (int j = 0;j<num;j++){
                if (M[i][j]==1){
                    if (i<j){
                        union(i,j,list);
                    }
                }
            }
        }

        HashSet<Integer> total = new HashSet<>();
        for (int i = 0;i<num;i++){
            total.add(find(i,list));
        }
        return total.size();
    }

    // 查看是否能够结合，祖先相同，无需结合，祖先不同，更换祖先A指向祖先B
    public boolean union(int x,int y,int[] list){
        int fatherx = find(x,list), fathery = find(y,list);
        if (fatherx==fathery) return true;
        else{
            list[fatherx] = fathery;
            return false;
        }
    }
    // 发现祖先
    public int find(int x,int[] list){
        if (list[x] == x){
            return x;
        }
        else{
            return find(list[x],list);
        }
    }
}