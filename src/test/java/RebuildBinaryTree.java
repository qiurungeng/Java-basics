import java.util.HashMap;

public class RebuildBinaryTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); //倒排索引
        }
        return recursive(0, 0, inorder.length - 1 );
    }

    private TreeNode recursive(int preOrdRootIndex, int inOrdLeftIndex, int inOrdRightIndex){
        if(inOrdLeftIndex > inOrdRightIndex) return null;

        TreeNode root = new TreeNode( preorder[preOrdRootIndex] );

        int inOrdRootIndex = map.get( preorder[preOrdRootIndex] );

        root.left = recursive(preOrdRootIndex + 1,
                inOrdLeftIndex, inOrdRootIndex - 1);

        root.right = recursive(
                preOrdRootIndex + (inOrdRootIndex - inOrdLeftIndex) + 1,
                inOrdRootIndex + 1, inOrdRightIndex);

        return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }
}
