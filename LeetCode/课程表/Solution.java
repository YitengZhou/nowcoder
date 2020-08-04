import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i =0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0;i<prerequisites.length;i++){
            for (int j = 1;j<prerequisites[i].length;j++){
                list.get(prerequisites[i][0]).add(prerequisites[i][j]);
            }
        }
        HashSet<Integer> result = new HashSet<>();
        for (int i =0;i<numCourses;i++){
            if (list.get(i).size()==0){
                result.add(i);
            }
        }
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i =0;i<numCourses;i++){
                if (list.get(i).size()==0){
                    continue;
                }
                else{
                    Iterator<Integer> iterator = list.get(i).iterator();
                    while (iterator.hasNext()){
                        if (result.contains(iterator.next())){
                            iterator.remove();
                        }
                    }
                    if (list.get(i).size()==0){
                        flag = true;
                        result.add(i);
                    }
                }
            }
        }
        if (result.size()==numCourses){
            return true;
        }
        return false;
    }
}