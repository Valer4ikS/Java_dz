public class taskk {
    public static class MyTree {
        private Node root;

        private enum Color {
            RED, BLACK
        }

        private class Node {
            private int value;
            private Node left;
            private Node right;
            private Color color;
        }

        public Node getNode() {
            return root;
        }

        public boolean contains(int value) {
            Node currNode = root;
            while (currNode != null) {
                if (currNode.value == value) {
                    return true;
                }
                if (currNode.value > value) {
                    currNode = currNode.left;
                } else {
                    currNode = currNode.right;
                }
            }
            return false;
        }

        public boolean add(int value) {
            if (root != null) {
                boolean result = addNode(root, value);
                root = balanceTree(root);
                root.color = Color.BLACK;
                return result;
            } else {
                root = new Node();
                root.color = Color.BLACK;
                root.value = value;
                return true;
            }
        }

        private boolean addNode(Node node, int value) {
            if (node.value == value) {
                return false;
            } else {
                if (node.value > value) {
                    if (node.left != null) {
                        boolean result = addNode(node.left, value);
                        node.left = balanceTree(node.left);
                        return result;
                    } else {
                        node.left = new Node();
                        node.left.color = Color.RED;
                        node.left.value = value;
                        return true;
                    }
                } else {
                    if (node.right != null) {
                        boolean result = addNode(node.right, value);
                        node.right = balanceTree(node.right);
                        return result;
                    } else {
                        node.right = new Node();
                        node.right.color = Color.RED;
                        node.right.value = value;
                        return true;
                    }
                }
            }
        }

        private Node balanceTree(Node node) {
            Node result = node;
            boolean needBalance;
            do {
                needBalance = false;
                if (result.right != null && result.right.color == Color.RED &&
                        (result.left == null || result.left.color == Color.BLACK)) {
                    needBalance = true;
                    result = rightSwap(result);
                }
                if (result.left != null && result.left.color == Color.RED &&
                        result.left.left != null && result.left.left.color == Color.RED) {
                    needBalance = true;
                    result = leftSwap(result);
                }
                if (result.left != null && result.left.color == Color.RED &&
                        result.right != null && result.right.color == Color.RED) {
                    needBalance = true;
                    colorSwap(result);
                }
            } while (needBalance);
            return result;
        }

        // правый малый поворот
        private Node rightSwap(Node node) {
            Node rightChild = node.right;
            Node betweenChild = rightChild.left;
            rightChild.left = node;
            node.right = betweenChild;
            rightChild.color = node.color;
            node.color = Color.RED;
            return rightChild;
        }

        // левый малый поворот
        private Node leftSwap(Node node) {
            Node leftChild = node.left;
            Node betweenChild = leftChild.right;
            leftChild.right = node;
            node.left = betweenChild;
            leftChild.color = node.color;
            node.color = Color.RED;
            return leftChild;
        }

        // Смена цвета
        private void colorSwap(Node node) {
            node.right.color = Color.BLACK;
            node.left.color = Color.BLACK;
            node.color = Color.RED;
        }

    }

    public static void main(String[] args) {
        task.MyTree myTree = new task.MyTree();
        myTree.add(5);
        myTree.add(6);
        myTree.add(7);
        myTree.add(9);
        myTree.add(1);
        myTree.add(4);
        System.out.println(myTree.getNode().left.color);
    }
}