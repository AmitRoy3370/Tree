package AVL;

public class AVL<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    @Override
    public Tree<T> add(T data) {

        root = add(root, data);

        return this;

    }

    private Node<T> add(Node<T> node, T data) {

        if (isEmpty(node)) {

            return new Node<>(data);

        }

        if (data.compareTo(node.getData()) < 0) {

            node.setLeft(add(node.getLeft(), data));

        } else if (data.compareTo(node.getData()) > 0) {

            node.setRight(add(node.getRight(), data));

        } else {

            return node;

        }

        updateHeight(node);

        return applyRotation(node);

    }

    @Override
    public Tree<T> delete(T data) {

        if (isEmpty()) {

            return this;

        }

        root = delete(root, data);

        return this;

    }

    private Node<T> delete(Node<T> node, T data) {

        if (isEmpty(node)) {

            return null;

        }

        if (data.compareTo(node.getData()) < 0) {

            node.setLeft(delete(node.getLeft(), data));

        } else if (data.compareTo(node.getData()) > 0) {

            node.setRight(delete(node.getRight(), data));

        } else {

            if (isEmpty(node.getLeft())) {

                return node.getRight();

            } else if (isEmpty(node.getRight())) {

                return node.getLeft();

            }

            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getLeft(), node.getData()));

        }

        updateHeight(node);

        return applyRotation(node);

    }

    private Node<T> applyRotation(Node<T> node) {

        int balance = balance(node);

        if (balance > 1) { // left heavy sitution

            if (balance(node.getLeft()) < 0) { //L-R sitution

                node.setLeft(rotateLeft(node.getLeft()));

            }

            //LL sitution
            return rotateRight(node);

        }

        if (balance < -1) { // right heavy sitution

            if (balance(node.getRight()) > 0) { //RL sitution

                node.setRight(rotateRight(node.getRight()));

            }

            //RR sitution
            return rotateLeft(node);

        }

        return node;

    }

    private Node<T> rotateLeft(Node<T> node) {

        Node<T> right = node.getRight();

        Node<T> rightLeft = node.getRight().getLeft();

        right.setLeft(node);
        node.setRight(rightLeft);

        updateHeight(node);
        updateHeight(right);

        return right;

    }

    private Node<T> rotateRight(Node<T> node) {

        Node<T> left = node.getLeft();
        Node<T> leftRight = node.getLeft().getRight();

        left.setRight(node);
        node.setLeft(leftRight);

        updateHeight(node);
        updateHeight(left);

        return left;

    }

    private void updateHeight(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        node.setHeight(Math.max(leftHeight, rightHeight) + 1);

    }

    private int balance() {

        if (isEmpty()) {

            return 0;

        }

        return balance(root);

    }

    private int balance(Node<T> node) {

        if (isEmpty(node)) {

            return 0;

        }

        return getHeight(node.getLeft()) - getHeight(node.getRight());

    }

    private int getHeight() {

        if (isEmpty()) {

            return 0;

        }

        return getHeight(root);

    }

    private int getHeight(Node<T> node) {

        if (isEmpty(node)) {

            return 0;

        }

        return node.getHeight();

    }

    @Override
    public void traverse() {

        if (isEmpty()) {

            return;

        }

        inOrder(root);

        System.out.println();

    }

    private void inOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        inOrder(node.getLeft());

        System.out.print(node.getData().toString() + " ");

        inOrder(node.getRight());

    }

    @Override
    public T getMin() {

        if (isEmpty()) {

            return null;

        }

        return getMin(root);

    }

    private T getMin(Node<T> node) {

        if (!isEmpty(node.getLeft())) {

            return getMin(node.getLeft());

        }

        return node.getData();

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

    private boolean isEmpty() {

        return isEmpty(root);

    }

    private boolean isEmpty(Node<T> node) {

        return node == null;

    }

}
