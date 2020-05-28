package common;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        Node current = root;
        Node parent = null;

        if(root == null) {
            root = node;
            return;
        }

        boolean chk = true; // 부모 노드에서 연결할 때 기존 기록에 left로 넘어왔는지, right로 넘어왔는지 체크값. left면 true, right면 false
        while(true) {
            if(current == null) {
                if(chk) parent.left = node;
                else parent.right = node;
                break;
            }
            if(current.value < value) {
                parent = current;
                chk = false;
                current = current.right;
            } else {
                parent = current;
                chk = true;
                current = current.left;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        boolean result = false;
        while(true) {
            if(current == null) break;
            System.out.println(current.value); // 체크 중인 노드 출력
            if(current.value < value) {
                current = current.right;
            } else if(current.value == value) {
                return true;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    public boolean delete(int value) {
        return false;
    }

    public void round(Node root) {
        if(root == null) {
            return;
        }
        round(root.left);
        System.out.println(root.value);
        round(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
        tree.insert(6);

        tree.find(6);
        System.out.println("======================");
        tree.find(7);
        System.out.println("======================");
        tree.find(9);
        System.out.println("======================");
        tree.find(5);

        System.out.println("======================");

        tree.round(tree.root);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
