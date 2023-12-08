package HW1;

public class CountCompleteTreeNodes {
    public CountCompleteTreeNodes() {
        TreeNode root = constructRoot();
         System.out.println("CountCompleteTreeNodes result: " + countNodes(root));
    }
    public int computeDepth(TreeNode root) {
        int depth = 0;
        TreeNode cur = root;
        if (cur == null) {
            return depth;
        }
        while (cur.left != null) {
            cur = cur.left;
            depth++;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = computeDepth(root);
        int left = 1;
        int right = (int)Math.pow(2, depth) - 1;
        int num = (int)Math.pow(2, depth) - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (exist(mid, depth, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (num + left);
    }

    private boolean exist(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    private TreeNode constructRoot() {
        // populate test case
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        return root;
    }


}
