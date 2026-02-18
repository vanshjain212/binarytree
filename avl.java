package binarytree;

public class avl {
    node root;

    void insert(int value) {
        root = insert(value, root);
    }

    node insert(int value, node Node) {
        if (Node == null) {
            return new node(value);
        }
        if (value < Node.data) {
            Node.left = insert(value, Node.left);
        } else if (value > Node.data) {
            Node.right = insert(value, Node.right);
        }
        Node.height = Math.max(heightt(Node.left), heightt(Node.right)) + 1;
        return rotate(Node);
    }

    node rotate(node p) {
        if (heightt(p.left) - heightt(p.right) > 1){
            if (heightt(p.left.left) - heightt(p.left.right) > 0)
            return rightrotate(p);
            else if (heightt(p.left.left) - heightt(p.left.right) < 0) {
            p.left = leftrotate(p.left);
            return rightrotate(p);}
        } else if (heightt(p.left) - heightt(p.right) < -1){
            if (heightt(p.right.left) - heightt(p.right.right) < 0)
            return leftrotate(p);
        else if (heightt(p.right.left) - heightt(p.right.right) > 0) {
            p.right = rightrotate(p.right);
            return leftrotate(p);}
        }
        return p;
    }

    private node rightrotate(node p) {
        node c = p.left;
        node t = p.left.right;
        p.left = t;
        c.right = p;
        p.height = Math.max(heightt(p.left), heightt(p.right)) + 1;
        c.height = Math.max(heightt(c.left), heightt(c.right)) + 1;
        return c;
    }

    private node leftrotate(node p) {
        node c = p.right;
        node t = p.right.left;
        p.right = t;
        c.left = p;
        p.height = Math.max(heightt(p.left), heightt(p.right)) + 1;
        c.height = Math.max(heightt(c.left), heightt(c.right)) + 1;
        return c;
    }

    int heightt(node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    void preorder() {
        preorder(this.root);
    }

    void preorder(node Node) {
        if (Node != null) {
            System.out.println(Node.data + " "+Node.height);
            preorder(Node.left);
            preorder(Node.right);
        }
    }

    public static void main(String[] args) {
        avl v = new avl();
        v.insert(10);
        v.insert(15);
        v.insert(5);
        v.insert(12);
        v.insert(18);
        v.insert(6);
        v.insert(7);
        v.insert(16);
        v.preorder();
    }

    class node {
        int data;
        int height;
        node left;
        node right;

        node(int value) {
            this.data = value;
            this.height=0;
        }
    }
}
