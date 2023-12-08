package HW1;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public MinimumDepthOfBinaryTree() {
        TreeNode root = constructRoot();
        System.out.println("result: " + minDepth(root));
    }

    private TreeNode constructRoot() {
        // populate test case
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        return root;
    }

    private TreeNode constructRoot2() {
        // populate test case 2
        TreeNode root = new TreeNode(2, null, new TreeNode(3,null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        return root;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int sameLevelNode = 1;
        // [1]
        while (queue.size() != 0) {
            sameLevelNode = queue.size();
            for (int i = 0; i < sameLevelNode; i ++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }

}
