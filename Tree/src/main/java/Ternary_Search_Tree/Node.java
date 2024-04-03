package Ternary_Search_Tree;

public class Node {

    final char data;
    Node left, right, middle;
    boolean endCharacter = false;

    public Node(char data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public boolean isEndCharacter() {
        return endCharacter;
    }

    public void setEndCharacter(boolean endCharacter) {
        this.endCharacter = endCharacter;
    }

    public char getData() {
        return data;
    }

}
