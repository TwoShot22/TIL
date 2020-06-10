
public class BST<E extends Comparable<E>>{
    private class Node<E>{
        E key;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E k){
            key = k;
            parent = null;
            left = null;
            right = null;
        }

        public String toString(){
            String returnVal = "";
            return returnVal + key;
        }
    }

    Node<E> root;

    public BST(){
        root = null;
    }

    public Node<E> search(Node<E> startNode, E x){
        Node<E> p = startNode;

        if(p == null || x.equals(p.key)){
            return p;
        } else if(x.compareTo(p.key) < 0){
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    public Node<E> insert(E x){
        Node<E> p = root;
        Node<E> q = null;

        while(p != null){
            if(x.equals(p.key))
                return root;

            q = p;

            if(x.compareTo(p.key) < 0)
                p = p.left;
            else
                p = p.right;
        }

        Node<E> newNode = new Node<>(x);

        if(root == null)
            root = newNode;
        else{
            if(x.compareTo(q.key) < 0)
                q.left = newNode;
            else
                q.right = newNode;

            newNode.parent = q;
        }

        return root;
    }

    public Node<E> delete(Node<E> startNode, E x){
        Node<E> v = search(startNode, x);

        if(v == null)
            return root;

        // Case 1 : No Child
        if(v.left == null && v.right == null){
            if(x.compareTo(v.parent.key) < 0)
                v.parent.left = null;
            else
                v.parent.right = null;
            return root;
        }

        // Case 2 : 1 Child
        if(v.left == null || v.right == null){
            if(v.right != null){ // v is left child of parent
                if(v == v.parent.left){
                    v.parent.left = v.right;
                    v.right.parent = v.parent;
                } else { // v is right child of parent
                    v.parent.right = v.right;
                    v.right.parent = v.parent;
                }
            } else { // v.left != null
                if(v == v.parent.left){
                    v.parent.left = v.left;
                    v.left.parent = v.parent;
                } else { // v is right child of parent
                    v.parent.right = v.left;
                    v.left.parent = v.parent;
                }
            }
            return root;
        } else {
            // Case 3 : 2 children
            // (1) pick predecessor
            Node<E> q = predecessor(v);
            v.key = q.key;
            delete(v.left, q.key);
            return root;

//            // (2) pick successor
//            Node<E> q = successor(v);
//            v.key = q.key;
//            delete(v.right, q.key);
//            return root;
        }
    }

    private Node<E> predecessor(Node<E> v){
        if(v == null)
            return null;

        Node<E> p = v.left;
        while(p.right != null)
            p = p.right;

        return p;
    }

    private Node<E> successor(Node<E> v){
        if(v == null)
            return null;

        Node<E> p = v.right;
        while(p.left != null)
            p = p.left;

        return p;
    }

    public String toString(){
        return inorder(root);
    }

    public String toString(Node<E> v){
        return inorder(v);
    }

    private String inorder(Node<E> v){
        if(v == null)
            return "";
        else
            return inorder(v.left) + " " + v.key + " " + inorder(v.right);
    }

    public static void main(String[] args) {
        BST<Character> mybst = new BST<>();

        mybst.insert('M');
        mybst.insert('Y');
        mybst.insert('O');
        mybst.insert('N');
        mybst.insert('G');
        mybst.insert('J');
        mybst.insert('I');

        System.out.println(mybst.toString());

        mybst.delete(mybst.root, 'G');
        System.out.println(mybst.toString());
    }
}
