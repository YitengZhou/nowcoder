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
        // 先序遍历,先右后左
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            pre.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        // 中序遍历,指针
        TreeNode temp = root;
        while (temp!= null || !stack.isEmpty()){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                TreeNode node = stack.pop();
                mid.add(node.val);
                temp = node.right;
            }
        }
        // 后序遍历,用两个栈,或者先左入栈，后右入栈，再反转
        Stack<TreeNode> stacktmp = new Stack<>();
        stacktmp.push(root);
        while(!stacktmp.isEmpty()){
            TreeNode node =stacktmp.pop();
            stack.push(node);
            if (node.left!=null){
                stacktmp.push(node.left);
            }
            if (node.right!=null){
                stacktmp.push(node.right);
            }
        }
        while (!stack.isEmpty()){
            TreeNode node =stack.pop();
            post.add(node.val);
        }
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }

        // 结果输出
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
}