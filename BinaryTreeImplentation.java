public class BinaryTree {

    Node root;

    private Node addRecursion(Node current, int value){
        if( current == null ){
            return new Node(value);
        }

        if( value < current.value ){
            current.left = addRecursion(current.left, value );
        }else if( value > current.value){
            current.right = addRecursion(current.right, value);
        }

        return current;
    }

    public void add(int value){
        root = addRecursion(root, value);
    }


    private BinaryTree createBinaryTree(){

        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private boolean containsNodeRecursive(Node current, int value ){

        if( current == null ){
            return false;
        }else if(current.value == value){
            return true;
        }
        return current.value > value ?  containsNodeRecursive(current.left,value):containsNodeRecursive(current.right,value);
    }

    public boolean containNode(int value){
        return containsNodeRecursive(root,value);
    }

    private Node deleteRecursive(Node current, int value){

        if(current == null){
            return null;
        }

        if( current.value == value ){

            if(current.left == null && current.right == null){
                return null;
            }else if( current.left == null ){
                return current.right;
            }else if ( current.right == null ){
                return current.left;
            }else {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
            }
        }

        if( current.value > value ){
            current.left = deleteRecursive(current.left,value);
        }else if ( current.value < value ){
            current.right = deleteRecursive(current.right,value);
        }
        return current;
    }


    private int findSmallestValue(Node current){

        return current.left == null ? current.value:findSmallestValue(current.left);

    }

    public void deleteNode(int value){
        root = deleteRecursive(root,value);
    }

    public static void main(String [] args){
//        BinaryTree bt = new BinaryTree();
//        bt = bt.createBinaryTree();
//        System.out.println(bt.containNode(6));
//        bt.deleteNode(6);
//        bt.deleteNode(7);
//        System.out.println(bt.containNode(6));
//        System.out.println(bt.containNode(4));
//        System.out.println(bt.containNode(8));
//        System.out.println(bt.containNode(3));
//        System.out.println(bt.containNode(5));
//        System.out.println(bt.containNode(7));
//        System.out.println(bt.containNode(9));
//        System.out.println(bt.containNode(10));
//        System.out.println(bt.containNode(1));
    }
    
}