package HW1;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode () {

    }

    public TreeNode (int value) {
        this.value = value;
    }

    public TreeNode (int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
