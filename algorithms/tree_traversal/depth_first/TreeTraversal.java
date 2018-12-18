public class TreeTraversal {
    public void print(Node h, Order order) {
        if(h == null) return;
        if(order == Order.PRE_ORDER) {
            System.out.print(" " + h.getVal());
        }
        print(h.getLeft(), order);
        if(order == Order.IN_ORDER) {
            System.out.print(" " + h.getVal());
        }
        print(h.getRight(), order);
        if(order == Order.POST_ORDER) {
            System.out.print(" " + h.getVal());
        }
    }

    public static void main(String[] args) {
        Node h = new Node(8);
        Node ch1 = new Node(3);
        Node ch2 = new Node(10);
        h.setLeft(ch1);
        h.setRight(ch2);
        ch1.setLeft(new Node(1));
        Node ch22 = new Node(6);
        ch1.setRight(ch22);
        ch22.setLeft(new Node(4));
        ch22.setRight(new Node(7));
        Node ch23 = new Node(14);
        ch2.setRight(ch23);
        ch23.setLeft(new Node(13));
        System.out.println("Pre-order traversal:");
        new TreeTraversal().print(h, Order.PRE_ORDER);
        System.out.println();
        System.out.println("In-order traversal:");
        new TreeTraversal().print(h, Order.IN_ORDER);
        System.out.println();
        System.out.println("Post-order traversal:");
        new TreeTraversal().print(h, Order.POST_ORDER);
        System.out.println();
    }        
    
    public static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setLeft(Node l) {
            left = l;
        }

        public void setRight(Node r) {
            right = r;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private static enum Order {
        PRE_ORDER, IN_ORDER, POST_ORDER;
    }
}
