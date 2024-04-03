package RedBlack;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class Node<T extends Comparable<T>> {

    T data;

    Node<T> node, left, right, parent;

    Color color;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void flipColor() {

        setColor(getColor() == RED ? BLACK : RED);

    }

    public boolean isLeft() {

        if (parent == null) {

            return false;

        }

        return parent.getLeft() == this;

    }

}
