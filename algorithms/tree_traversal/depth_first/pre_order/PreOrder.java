public class PreOrder {
    public void print(Node h) {
        if(h == null) return;
        System.out.print(" " + h.getVal());
        print(h.getLeft());
        print(h.getRight());
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
        new PreOrder().print(h);
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
}
