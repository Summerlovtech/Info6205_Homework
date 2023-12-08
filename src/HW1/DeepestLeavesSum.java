package HW1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum {
    public DeepestLeavesSum () {
        TreeNode root = constructRoot();
        System.out.println("DeepestLeavesSum result: " + deepestLeavesSum(root));
    }
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                sum += cur.value;
            }
        }
        return sum;
    }
    private TreeNode constructRoot() {
        // populate test case
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        return root;
    }
}
