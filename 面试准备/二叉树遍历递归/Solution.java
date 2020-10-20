import java.util.*;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        // pre-order
        preOrder(root,pre);
        // mid-order
        midOrder(root,mid);
        // post-order
        postOrder(root,post);
        int[] preResult = new int[pre.size()];
        int[] midResult = new int[mid.size()];
        int[] postResult = new int[post.size()];
        int index = 0;
        for (Integer i :pre){
            preResult[index++] = i;
        }
        index = 0;
        for (Integer i:mid){
            midResult[index++] = i;
        }
        index = 0;
        for (Integer i:post){
            postResult[index++] = i;
        }
        int[][] result = new int[3][];
        result[0] = preResult;
        result[1] = midResult;
        result[2] = postResult;
        return result;
    }
    public void preOrder(TreeNode root, ArrayList<Integer> pre){
        if (root==null){
            return;
        }
        pre.add(root.val);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }
    public void midOrder(TreeNode root, ArrayList<Integer> mid){
        if (root ==null){
            return;
        }
        midOrder(root.left,mid);
        mid.add(root.val);
        midOrder(root.right,mid);
    }
    public void postOrder(TreeNode root, ArrayList<Integer> post){
        if (root ==null){
            return;
        }
        postOrder(root.left,post);
        postOrder(root.right,post);
        post.add(root.val);
    }
}