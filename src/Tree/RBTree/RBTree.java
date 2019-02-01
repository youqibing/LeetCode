package Tree.RBTree;

import java.util.concurrent.atomic.AtomicLong;

public class RBTree<T extends Comparable<T>> {
    private final RBTreeNode<T> root;

    //overrideMode表示所有的节点 node 不能有相同的value
    private boolean overrideMode;

    //AtomicLong是作用是对长整形进行原子操作.在32位操作系统中，64位的long 和 double 变量由于会被JVM当作两个
    //分离的32位来进行操作,所以不具有原子性.而使用AtomicLong能让long的操作保持原子型.
    private AtomicLong size = new AtomicLong(0);

    public RBTree(){
        this.root = new RBTreeNode<>();
    }

    public RBTree(boolean overrideMode){
        this();
        this.overrideMode = overrideMode;
    }


    public boolean isOverrideMode(){
        return overrideMode;
    }

    public void setOverrideMode(boolean overrideMode){
        this.overrideMode = overrideMode;
    }

    /**
     * 树的节点数量
     */
    public long getSize(){
        return size.get();
    }

    /**
     * 获取根节点
     */
    private RBTreeNode<T> getRoot(){
        return root;
    }





    /**---------------------------------------------插入节点--------------------------------------------------**/

    public T addNode(T value){
        RBTreeNode<T> t = new RBTreeNode<T>(value);
        return addNode(t);
    }

    private T addNode(RBTreeNode<T> node){
        node.setLeft(null);
        node.setRight(null);
        node.setRed(true);
        setParent(node, null);

        if(root.getLeft() == null){
            root.setLeft(node);
            node.setRed(false);
            size.incrementAndGet();
        }else{
            RBTreeNode<T> x = findParentNode(node);
            int cmp = x.getValue().compareTo(node.getValue());  //比较node节点与父母节点的值


            //注意父母节点值与node节点相等时并不执行插入
            if(this.overrideMode && cmp == 0){      //如果允许overrideMode(可以重复)且此时两者刚好相等
                T v = x.getValue();     //此时父母节点(x)与他的一个子节点以及插入的结点(node)三者值相等
                x.setValue(node.getValue()); //替换父母节点(反正值都一样,这个无所谓了)
                return v;
            }else if(cmp == 0){     //不允许overrideMode,可以重复,返回父母节点的值
                return x.getValue();
            }

            setParent(node, x); //给node设置父母节点

            if(cmp>0){
                x.setLeft(node);    //父母节点的值大于node, 则将node作为左子节点
            }else {
                x.setRight(node);
            }

            fixInsert(node);    //修正插入
            size.incrementAndGet(); //更新size值
        }

        return null;
    }


    private void setParent(RBTreeNode<T> node,RBTreeNode<T> parent){
        if(node!=null){
            node.setParent(parent);
            if(parent==root){
                node.setParent(null);
            }
        }
    }


    /**
     * 找到添加节点时需要插入节点的父母的位置，这就是一个儿查查找的过程
     *
     * @param x 需要插入的结点
     * @return 父母节点
     */
    private RBTreeNode<T> findParentNode(RBTreeNode<T> x){
        RBTreeNode<T> dataRoot = getRoot(); //获取root节点
        RBTreeNode<T> child = dataRoot;

        while(child != null){   //根节点有孩子
            int cmp = child.getValue().compareTo(x.getValue()); //根节点的value和node节点比较
            if(cmp ==0){
                return child;   //如果相等,说明跟节点的是node的父母节点
            }else if(cmp>0){
                dataRoot = child;   //根的值比node的值大
                child = child.getLeft();    //再获得根的左孩子(找更小的节点比较)
            }else {
                dataRoot = child;   //根的值比node的值小
                child = child.getRight();   //往右子树上面寻找(找值大一点的)
            }
        }
        return dataRoot;    //返回应该插入的父母节点
    }


    /**------------------------------------------------插入结束---------------------------------------------------**/




    /**------------------------------------------------插入调整---------------------------------------------------**/

    /**
     * 新插入的节点是红色的,
     * 红色节点的孩子不能使红色,因此只有在父节点为红色节点的时候是需要插入修复操作的。插入修复操作如果遇到父节点的颜色为黑则修复操作结束
     * 插入修复操作分为以下的三种情况，而且新插入的节点的父节点都是红色的(一般来讲都是插在最底层最为叶子结点)：
     *
     * 叔叔节点也为红色。
     * 叔叔节点为空，且祖父节点、父节点和新节点处于一条斜线上。
     * 叔叔节点为空，且祖父节点、父节点和新节点不处于一条斜线上。
     *
     * 这里需要注意的是颜色变化：
     *      后两种情况在我们调整树平衡时,层级发生改变的(上位或者下位，而且层级改变是奇数个层级)都会伴随着颜色的变化,加上
     * "新插入的节点是红色的,父节点为红色节点"这个条件，可以推断出来颜色的变化情况
     *      第一种情况不需要调整高度,因此没有上位或者下位的情况.颜色改变也是直接从插入的那一层起,往上逐层改变颜色，一直到根节点那一层
     * @param x
     */
    private void fixInsert(RBTreeNode<T> x){
        RBTreeNode<T> parent = x.getParent();

        while(parent !=null && parent.isRed()){
            RBTreeNode<T> uncle = getUncle(x);

            if(uncle == null){  //叔叔节点为null,则树已经不平衡,需要旋转
                RBTreeNode<T> ancestor = parent.getParent();

                if(parent == ancestor.getLeft()){
                    boolean isRight = x == parent.getRight();
                    if(isRight){    //叔叔节点为空，且祖父节点、父节点和新节点不处于一条斜线上(case 3)
                        rotateLeft(parent); //先左旋parent节点,转化为case2的情况，再 rotateRight(ancestor)
                    }
                    //注意这里没有else
                    rotateRight(ancestor);  //叔叔节点为空，且祖父节点、父节点和新节点处于一条斜线(case 2)


                    if(isRight){    //叔叔节点为空，且祖父节点、父节点和新节点不处于一条斜线上
                        x.setRed(false);
                        parent = null;  //已经右旋过了,树已经平衡,终止循环
                    }else {     //叔叔节点为空，且祖父节点、父节点和新节点处于一条斜线上
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);  //祖先节点最终都要"下位",那么他的颜色一定会改变

                }else { //parent == ancestor.getRight(),是上面情况的镜像
                    boolean isLeft = x ==parent.getLeft();
                    if(isLeft){ //三者不在一条直线上, 对应 "插入操作-case 3" 的镜像
                        rotateRight(parent);    //调用这个方法转化为 "插入操作-case 2" 的镜像
                    }

                    rotateLeft(ancestor);   //然后就把祖先A旋转到左下去了

                    if(isLeft){
                        x.setRed(false);
                        parent=null;//end loop
                    }else{
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }
            }else {     //叔叔节点存在且是红色的(case 1),此时树是平衡的,只要挑整颜色即可
                parent.setRed(false);
                uncle.setRed(false);
                parent.getParent().setRed(true);    //祖先节点设为红

                x = parent.getParent(); //x变为祖先
                parent = x.getParent(); //parent变为祖先的parent,一次向上挑整颜色
            }
        }
        getRoot().makeBlack();  //不管怎么挑整,根节点必须为黑; 而且根节点的两个子节点可以是黑的; 但是红结点的两个子节点必须是黑的
        getRoot().setParent(null);
    }

    /**
     * 返回叔叔节点
     * @param node
     * @return
     */
    private RBTreeNode<T> getUncle(RBTreeNode<T> node){
        RBTreeNode<T> parent = node.getParent();
        RBTreeNode<T> ancestor =  parent.getParent();
        if(ancestor == null){
            return null;
        }

        if (parent == ancestor.getLeft()){
            return ancestor.getRight();
        }else {
            return ancestor.getLeft();
        }
    }

    /**-----------------------------------------------插入调整结束---------------------------------------------------**/





    /**------------------------------------------------左右旋转-----------------------------------------------------**/

    /**
     * 这个方法主要对应两个过程：
     *
     * 对于文中的 "插入操作-case 3"这个过程实际转化为"case 2"的过程, 之后还是要调用rotateRight才能完成旋转的过程，
     * 此时right是C, node是B, parent是A：
     *      A(B)           A(B)
     *     /              /
     *    B(R)   ---->   C(R)
     *    \             /
     *     C(R)        B(R)
     *
     *
     * 对于文中"插入操作-case 2"的镜像情况，即B在A右边,C在B右边,此时node是A,right是B,parent是更高层的祖先了,
     * 此时的任务是将A旋转到左下方,可对照分析:
     *      A(B)
     *       \                 B(B)
     *        B(R)  ---->     /  \
     *         \            A(R)  C(R)
     *          C(R)
     *
     * 其实仔细观察这两个过程是有规律的：
     * 对第一种情况——"曲线变直线 ",node=B(中间的结点):
     *           如果node有右孩子(r),则node和r的位置对调并将node设为r的 l;
     *           如果node有左孩子(l), 则node和l的位置对调并将node设置l的 r;
     *
     * 对于第二种情况——"直线变三角", node=A(顶部的结点):
     *           如果node有右孩子(r),则node变为r的l,即把node"折到左边去"即可；
     *           如果node有左孩子(l),则node变为l的r,即把node"折到右边去"即可；
     * 当然这两种情况中,需要注意的一点是都有一个结点"上位"和一个"下位",那么这个上位和下位的结点都需要更改他的parent指针
     *
     */
    private void rotateLeft(RBTreeNode<T> node){
        RBTreeNode<T> right = node.getRight();  //right是C, node是B, parent是A
        if(right == null){
            throw new IllegalStateException("right node is null");  //没右孩子不用左旋了
        }
        RBTreeNode<T> parent = node.getParent();

        if(right.getLeft()!=null){
            node.setRight(right.getLeft());
            setParent(right.getLeft(), node);
        }

        right.setLeft(node);    //B变为C的左子
        setParent(node, right);     //C设置为B的父母

        if(parent == null){  //parent表示A,如果A是null，只能说明之前B指向的是根节点 (根节点不能算作父母节点)
            root.setLeft(right);    //此时设置根节点的左子为C
            setParent(right, null); //设置C的父母节点为null，表示他指向根节点
        }else {
            if(parent.getLeft() == node){   //A的左子是B，符合 "操作Case 3"的图1
                parent.setLeft(right);  //A的左子设为C
            }else { //这里的else就是 parent.getRight() == node
                parent.setRight(right);
            }

            setParent(right, parent);   //设置C的父母为A
        }
    }

    private void rotateRight(RBTreeNode<T> node){
        RBTreeNode<T> left = node.getLeft();
        if(left == null){
            throw new IllegalStateException("left node is null");
        }
        RBTreeNode<T> parent = node.getParent();

        if(left.getRight()!=null){
            node.setLeft(left.getRight());
            setParent(left.getRight(), node);
        }

        left.setRight(node);
        setParent(node, left);

        if(parent == null){
            root.setLeft(left);
            setParent(left,null);
        }else {
            if(parent.getLeft() == node){
                parent.setLeft(left);
            }else {
                parent.setRight(left);
            }
        }

        setParent(left, parent);
    }

    /**----------------------------------------------左右旋转结束---------------------------------------------------**/
}













