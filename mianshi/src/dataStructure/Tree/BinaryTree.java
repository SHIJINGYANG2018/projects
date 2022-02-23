package dataStructure.Tree;

/**
 * 遍历二叉树
 * 前序遍历  30-20-15-25-40-35-50
 * 中序遍历  15-20-25-30-35-40-50
 * 后序遍历  15-25-20-35-50-40-30
 */
public class BinaryTree {
    public static void main(String[] args){
        // 定义二叉树
        BinaryNode C = new BinaryNode(15, null, null);
        BinaryNode D = new BinaryNode(25, null, null);
        BinaryNode E = new BinaryNode(35, null, null);
        BinaryNode F = new BinaryNode(50, null, null);
        BinaryNode A = new BinaryNode(20, C, D);
        BinaryNode B = new BinaryNode(40, E, F);
        BinaryNode H = new BinaryNode(30, A, B);

        //前序遍历
        //frontOrder(H);
        //中序遍历
        //inOrder(H);
        //后序遍历
        afterOrder(H);
    }
    static  void hou(BinaryNode root){
        if(root!=null){
            hou(root.leftNode);
            hou(root.leftNode);
            System.out.println(root.value+"--->");
        }
    }
    //前序遍历
    static public void frontOrder(BinaryNode localNode){
        if(localNode!=null){
            //访问根节点
            System.out.print(localNode.getValue()+"-->");
            //访问左子树
            frontOrder(localNode.getLeftNode());
            //访问右子树
            frontOrder(localNode.getRightNode());
        }
    }

    /**
     * 中序遍历
     */
    static public  void inOrder(BinaryNode localNode){
        if(localNode!=null){
            //中序遍历
            //访问左子树
            inOrder(localNode.getLeftNode());
            //访问根节点
            System.out.print(localNode.getValue()+"-->");
            //访问左子树
            inOrder(localNode.getRightNode());
        }
    }
    /**
     * 后序遍历
     */
    static  public  void afterOrder(BinaryNode localNode){
        if(localNode!=null){
            // 访问左子树
            afterOrder(localNode.getLeftNode());
            //访问右子树
            afterOrder(localNode.getRightNode());
            //访问根节点
            System.out.print(localNode.getValue()+"-->");
        }
    }
    static class BinaryNode{
        int value;
        BinaryNode leftNode;
        BinaryNode rightNode;
        public BinaryNode(int value, BinaryNode leftNode, BinaryNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
        public int getValue() {
            return value;
        }
        public BinaryNode getLeftNode() {
            return leftNode;
        }
        public BinaryNode getRightNode() {
            return rightNode;
        }
    }
}

