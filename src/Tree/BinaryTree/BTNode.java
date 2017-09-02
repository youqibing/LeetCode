package Tree.BinaryTree;

import sun.reflect.generics.tree.Tree;

public class BTNode<T> {
    private T parent;
    private BTNode<T> left, right;

    BTNode(T parent){
        this(parent,null,null);
    }

    BTNode(T parent, BTNode left, BTNode right){
        this.parent =parent;
        this.left=left;
        this.right=right;
    }


    public T getParent(){
        return parent;
    }
    public void setParent(T parent){
        this.parent = parent;
    }

    public BTNode<T> getLeft(){
        return left;
    }
    public void setLeft(BTNode<T> left){
        this.left = left;
    }

    public BTNode<T> getRight(){
        return right;
    }
    public void setRight(BTNode<T> right){
        this.right = right;
    }

}
