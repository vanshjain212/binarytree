package binarytree;
public class bst {
    node root;
    void insert(int value){
        if(root==null)
        root=  new node(value);
        insert(value, root);
    }
    void insert(int value,node Node){
        if(value<Node.data){
            if(Node.left==null)
            Node.left=new node(value);
            insert(value, Node.left);
        }
        if(value>Node.data){
            if(Node.right==null)
            Node.right=new node(value);
            insert(value, Node.right);
        }
    }
    void preorder(){
        preorder(this.root);
    }
    void preorder(node Node){
        if(Node!=null){
            System.out.print(Node.data+" ");
            preorder(Node.left);
            preorder(Node.right);
        }
    }
    
    public static void main(String[] args) {
        bst v=  new bst();
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
    class node{
        int data;
        node left;
        node right;
        node(int value){
            this.data=value;
        }
    }
}
