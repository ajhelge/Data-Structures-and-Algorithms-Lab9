package lab109.helgesonaj;

public class BinarySearchTree {

    // Represent a node of binary tree
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            // Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Represent the root of binary tree
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    // insert() will add new node to the binary search tree
    public void insert(int data) {
        // Create a new node
        Node newNode = new Node(data);

        // Check whether tree is empty
        if (root == null) {
            root = newNode;
            return;
        } else {
            // current node point to root of the tree
            Node current = root, parent = null;

            while (true) {
                // parent keep track of the parent node of current node.
                parent = current;

                // If data is less than current's data, node will be inserted to the left of
                // tree
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                // If data is greater than current's data, node will be inserted to the right of
                // tree
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    // minNode() will find out the minimum node
    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    // deleteNode() will delete the given node from the binary search tree
    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        } else {
            // value is less than node's data then, search the value in left subtree
            if (value < node.data)
                node.left = deleteNode(node.left, value);

            // value is greater than node's data then, search the value in right subtree
            else if (value > node.data)
                node.right = deleteNode(node.right, value);

            // If value is equal to node's data that is, we have found the node to be
            // deleted
            else {
                // If node to be deleted has no child then, set the node to null
                if (node.left == null && node.right == null)
                    node = null;

                // If node to be deleted has only one right child
                else if (node.left == null) {
                    node = node.right;
                }

                // If node to be deleted has only one left child
                else if (node.right == null) {
                    node = node.left;
                }

                // If node to be deleted has two children node
                else {
                    // then find the minimum node from right subtree
                    Node temp = minNode(node.right);
                    // Exchange the data between node and temp
                    node.data = temp.data;
                    // Delete the node duplicate node from right subtree
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }

    // inorder() will perform inorder traversal on binary search tree
    public void inorderTraversal(Node node) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            if (node.left != null)
                inorderTraversal(node.left);
            System.out.print(node.data + " ");
            if (node.right != null)
                inorderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            if (node.left != null)
                postOrderTraversal(node.left);
            if (node.right != null)
                postOrderTraversal(node.right);
            System.out.print(node.data + " "); // for post-Order print data after exploring subtrees.
        }
    }

    public void preOrderTraversal(Node node) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            System.out.print(node.data + " "); // for pre-Order print data before exploring subtrees.
            if (node.left != null)
                preOrderTraversal(node.left);
            if (node.right != null)
                preOrderTraversal(node.right);
        }
    }

    // Recursive Height Method.
    // public int height(Node node) {
    // if(node == null){return 0;}
    // int h = 0;
    // if(node.left != null){
    // h = Math.max(h, 1 + height(node.left));
    // }
    // if(node.right != null){
    // h = Math.max(h, 1 + height(node.right));
    // }
    // return h;
    // }

    public int height(Node node) {
        int height = 0;
        LinkedStack<Node> currentLayer = new LinkedStack<>();
        LinkedStack<Node> nextLayer = new LinkedStack<>();

        currentLayer.push(node);
        while (!currentLayer.isEmpty()) {


            // For each node in current list, add it's childen to next layer.
            int currentSize = currentLayer.size();
            for (int i = 0; i < currentSize; i++) {
                Node currentNode = currentLayer.pop();
                if (currentNode.left != null) {
                    nextLayer.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLayer.push(currentNode.right);
                }
            }
            
            // If there is a next layer of the tree then increment height.
            if (nextLayer.top() != null) {
                height++;
            }

            // Next layer is now the current layer.
            while (!nextLayer.isEmpty()) {
                currentLayer.push(nextLayer.pop());
            }

        }

        return height;
    }
}