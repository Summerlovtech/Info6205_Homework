package HW1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilar {
    public LeafSimilar() {
        TreeNode root1 = constructRoot();
        TreeNode root2 = constructRoot();
        System.out.println("LeafSimilar result: " + leafSimilar(root1, root2));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<Integer>();
        List<Integer> leafs2 = new ArrayList<Integer>();
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    public void dfs(TreeNode root, List leafs){
        if (root == null){
            return;
        }
        if (root.left == null && root.right ==null){
            leafs.add(root.value);
        }
        dfs(root.right, leafs);
        dfs(root.left, leafs);
    }
    private TreeNode constructRoot() {
        // populate test case
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        return root;
    }
}
