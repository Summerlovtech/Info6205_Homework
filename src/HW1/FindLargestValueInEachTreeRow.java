package HW1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public FindLargestValueInEachTreeRow() {
        TreeNode root = constructRoot();
        System.out.println("FindLargestValueInEachTreeRow result: " + largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int num = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < num; i++) {
                TreeNode cur = queue.poll();
                if (cur.value > levelMax) {
                    levelMax = cur.value;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(levelMax);
        }
        return res;
    }

    private TreeNode constructRoot() {
            // populate test case
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        return root;
    }

}