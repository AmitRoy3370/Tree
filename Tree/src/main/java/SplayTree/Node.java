package SplayTree;

public class Node<T extends Comparable<T>> {

    T data;
    Node<T> left, right, parent;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean isLeft() {

        if (parent == null) { // root node

            return false;

        }

        return parent.getLeft() == this;

    }

    public boolean isRight() {

        if (parent == null) { // root node

            return false;

        }

        return parent.getRight() == this;

    }

    public Node<T> getGrandParent() {

        if (parent == null) { // root node

            return null;

        }

        return parent.getParent();

    }

}
