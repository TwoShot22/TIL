
import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    Object data;
    TreeNode left;
    TreeNode right;
}

class LinkedTree {
    private TreeNode root;

    public TreeNode createBT() {
        root = null;
        return root;
    }

    public boolean isEmpty(TreeNode bt) {
        if (bt == null)
            return true;
        else
            return false;
    }

    public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
        TreeNode root = new TreeNode();
        root.data = data;
        root.left = bt1;
        root.right = bt2;

        return root;
    }

    public TreeNode leftSubtree(TreeNode bt) {
        if (isEmpty(bt))
            return null;
        else
            return bt.left;
    }

    public TreeNode rightSubtree(TreeNode bt) {
        if (isEmpty(bt))
            return null;
        else
            return bt.right;
    }

    public Object data(TreeNode bt) {
        if (isEmpty(bt))
            return null;
        else
            return bt.data;
    }

    ////////////////////////////////////////////////////////////////
    ///          Binary Tree Traversal
    ////////////////////////////////////////////////////////////////

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.printf("%c", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf("%c", root.data);
            inorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%c", root.data);
        }
    }

    public void levelOrder(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<TreeNode>();
        que.add(root);
//        while (que.peek() != null) {
//            TreeNode element = que.poll();
//            System.out.printf("%c", element.data);
//            if(element.left != null) que.add(element.left);
//            if(element.right != null) que.add(element.right);
//        }

        levelOrderRecursive(que);
    }

    private void levelOrderRecursive(Deque<TreeNode> que) {
        if(que.peek() != null){
            TreeNode element = que.poll();
            System.out.printf("%c", element.data);
            if(element.left != null) que.add(element.left);
            if(element.right != null) que.add(element.right);
            levelOrderRecursive(que);
        }
    }
}

class TreeTraversal {
    public static void main(String[] args) {
        LinkedTree T = new LinkedTree();

        TreeNode n7 = T.makeBT(null, 'D', null);
        TreeNode n6 = T.makeBT(null, 'C', null);
        TreeNode n5 = T.makeBT(null, 'B', null);
        TreeNode n4 = T.makeBT(null, 'A', null);
        TreeNode n3 = T.makeBT(n6, '/', n7);
        TreeNode n2 = T.makeBT(n4, '*', n5);
        TreeNode n1 = T.makeBT(n2, '-', n3);

        System.out.print("\n Preorder : ");
        T.preorder(n1);

        System.out.print("\n Inorder : ");
        T.inorder(n1);

        System.out.print("\n Postorder : ");
        T.postorder(n1);

        System.out.println("\n Level-Order : ");
        T.levelOrder(n1);
    }
}
