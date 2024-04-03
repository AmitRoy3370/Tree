package SplayTree;

public class Splay<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    int size = 0;

    @Override
    public Tree<T> add(T data) {

        Node<T> node = new Node<>(data);

        root = add(root, node);

        Splay(node);

        root.setParent(null);

        return this;

    }

    private Node<T> add(Node<T> node, Node<T> addedNode) {

        if (isEmpty(node)) {

            ++size;

            return addedNode;

        }

        if (addedNode.getData().compareTo(node.getData()) < 0) {

            node.setLeft(add(node.getLeft(), addedNode));

            if (!isEmpty(node.getLeft())) {

                node.getLeft().setParent(node);

            }

        } else if (addedNode.getData().compareTo(node.getData()) > 0) {

            node.setRight(add(node.getRight(), addedNode));

            if (!isEmpty(node.getRight())) {

                node.getRight().setParent(node);

            }

        }

        return node;

    }

    @Override
    public Tree<T> delete(T data) {

        if (isEmpty()) {

            return null;

        }

        root = delete(root, data);

        root.setParent(null);

        return this;

    }

    private Node<T> delete(Node<T> node, T data) {

        if (isEmpty(node)) {

            --size;

            return null;

        }

        if (data.compareTo(node.getData()) < 0) {

            node.setLeft(delete(node.getLeft(), data));

            if (!isEmpty(node.getLeft())) {

                node.getLeft().setParent(node);

            }

        } else if (data.compareTo(node.getData()) > 0) {

            node.setRight(delete(node.getRight(), data));

            if (!isEmpty(node.getRight())) {

                node.getRight().setParent(node);

            }

        } else {

            if (isEmpty(node.getLeft())) {

                --size;

                return node.getRight();

            } else if (isEmpty(node.getRight())) {

                --size;

                return node.getLeft();

            }

            node.setData(getMax(node.getLeft()));

            node.setLeft(delete(node.getLeft(), node.getData()));

            if (!isEmpty(node.getLeft())) {

                node.getLeft().setParent(node);

            }

        }

        return node;

    }

    @Override
    public boolean find(T data) {

        if (isEmpty()) {

            return false;

        }

        return find(root, data);

    }

    private boolean find(Node<T> node, T data) {

        if (isEmpty(node)) {

            return false;

        }

        if (data.compareTo(node.getData()) == 0) {

            Splay(node);

            return true;

        }

        return data.compareTo(node.getData()) < 0 ? find(node.getLeft(), data) : find(node.getRight(), data);

    }

    private void Splay(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        Node<T> parent = node.getParent();

        if (isEmpty(parent)) {

            return;

        }

        if (isEmpty(node.getGrandParent())) { //add node in root node/ 

            if (node.isLeft()) { // left sitution / zig sitution

                rotateRight(parent);

            } else if (node.isRight()) { // right sitution / zag sitution

                rotateLeft(parent);

            }

        } else if (parent.isLeft() && node.isLeft()) { // L-L sitution / zig-zig sitution

            rotateRight(node.getGrandParent());
            rotateRight(parent);

        } else if (parent.isRight() && node.isRight()) { // R-R sitution // zag zag sitution

            rotateLeft(node.getGrandParent());
            rotateLeft(parent);

        } else if (parent.isRight() && node.isLeft()) { // R-L sitution / zag-zig Sitution

            rotateRight(parent);
            rotateLeft(parent);

        } else if (parent.isLeft() && node.isRight()) { // L-R sitution // zig zag sitution

            rotateLeft(parent);
            rotateRight(parent);

        }

    }

    private void rotateRight(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        Node<T> left = node.getLeft();

        if (isEmpty(left)) {

            return;

        }

        Node<T> leftRight = node.getLeft().getRight();

        node.setLeft(leftRight);

        if (!isEmpty(node.getLeft())) {

            node.getLeft().setParent(node);

        }

        left.setRight(node);
        left.setParent(node.getParent());

        updateChildOfParentNode(node, left);

        node.setParent(left);

    }

    private void rotateLeft(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        Node<T> right = node.getRight();

        if (isEmpty(right)) {

            return;

        }

        Node<T> rightLeft = node.getRight().getLeft();

        node.setRight(rightLeft);

        if (!isEmpty(node.getRight())) {

            node.getRight().setParent(node);

        }

        right.setLeft(node);
        right.setParent(node.getParent());

        updateChildOfParentNode(node, right);

        node.setParent(right);

    }

    private void updateChildOfParentNode(Node<T> node, Node<T> tempNode) {

        if (isEmpty(node.getParent())) {

            root = tempNode;

        } else if (node.isLeft()) {

            node.getParent().setLeft(tempNode);

        } else if (node.isRight()) {

            node.getParent().setRight(tempNode);

        }

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public void visit() {

        if (isEmpty()) {

            return;

        }

        System.out.println("post order trabersal :- ");

        postOrder(root);

        System.out.println();

        System.out.println("in order traversal :- ");

        inOrder(root);

        System.out.println();

    }

    private void postOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        System.out.print(node.getData().toString() + " ");

        postOrder(node.getLeft());
        postOrder(node.getRight());

    }

    private void inOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        inOrder(node.getLeft());

        System.out.print(node.getData().toString() + " ");

        inOrder(node.getRight());

    }

    private boolean search(Node<T> node, T data) {

        if (isEmpty(node)) {

            return false;

        }

        search(node.getLeft(), data);

        if (node.getData().equals(data)) {

            return true;

        }

        search(node.getRight(), data);

        return false;

    }

    @Override
    public T getMax() {

        if (isEmpty()) {

            return null;

        }

        return getMax(root);

    }

    private T getMax(Node<T> node) {

        if (!isEmpty(node.getRight())) {

            return getMax(node.getRight());

        }

        return node.getData();

    }

    @Override
    public T getMin() {

        if (isEmpty()) {

            return null;

        }

        return getMin(root);

    }

    private boolean isEmpty() {

        return isEmpty(root);

    }

    private boolean isEmpty(Node<T> node) {

        return node == null;

    }

    private T getMin(Node<T> node) {

        if (!isEmpty(node.getLeft())) {

            return getMin(node.getLeft());

        }

        return node.getData();

    }

}
