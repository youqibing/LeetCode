package Tree.RBTree;

public class RBTreeNode<T extends Comparable<T>> {
    private T value;
    private RBTreeNode<T> left;
    private RBTreeNode<T> right;
    private RBTreeNode<T> parent;
    private boolean red;


    public RBTreeNode(){ }
    public RBTreeNode(T value){ this.value = value; }
    public RBTreeNode(T value, boolean isRed){
        this.value = value;
        this.red = isRed;
    }



    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RBTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }

    public RBTreeNode<T> getRight() {
        return right;
    }

    public void setRight(RBTreeNode<T> right) {
        this.right = right;
    }

    public RBTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return red;
    }

    void setRed(boolean red) {
        this.red = red;
    }

    public boolean isBlack(){
        return !red;
    }





    boolean isLeaf(){
        return left == null && right == null;
    }

    void makeRed(){
        red = true;
    }

    void makeBlack(){
        red = false;
    }



    @Override
    public String toString() {
        return value.toString();
    }
}
