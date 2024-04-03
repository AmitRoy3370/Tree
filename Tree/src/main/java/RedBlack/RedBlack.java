package RedBlack;

import static java.awt.Color.RED;
import static java.awt.Color.BLACK;

public class RedBlack<T extends Comparable<T>> implements Tree<T> {
    
    Node<T> root;
    
    @Override
    public Tree<T> add(T data) {
        
        Node<T> node = new Node<>(data);
        
        root = add(root, node);
        
        applyReColorAndRotation(node);
        
        root.setParent(null);
        
        return this;
        
    }
    
    private Node<T> add(Node<T> node, Node<T> addedNode) {
        
        if (isEmpty(node)) {
            
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
        
        applyReColorAndRotation(root);
        
        root.setParent(null);
        
        return this;
        
    }
    
    private Node<T> delete(Node<T> node, T data) {
        
        if (isEmpty(node)) {
            
            return null;
            
        }
        
        if (data.compareTo(node.getData()) < 0) {
            
            try {
                
                node.setLeft(delete(node.getLeft(), data));
                
                if (!isEmpty(node.getLeft())) {
                    
                    node.getLeft().setParent(node);
                    
                }
                
            } catch (Exception e) {
                
            }
            
        } else if (data.compareTo(node.getData()) > 0) {
            
            try {
                
                node.setRight(delete(node.getRight(), data));
                
                if (!isEmpty(node.getRight())) {
                    
                    node.getRight().setParent(node);
                    
                }
                
            } catch (Exception e) {
                
            }
            
        } else {
            
            if (isEmpty(node.getLeft())) {
                
                return node.getRight();
                
            } else if (isEmpty(node.getRight())) {
                
                return node.getLeft();
                
            }
            
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getLeft(), node.getData()));
            
            if (!isEmpty(node.getLeft())) {
                
                node.getLeft().setParent(node);
                
            }
            
        }
        
        applyReColorAndRotation(node);
        
        return node;
        
    }
    
    private void applyReColorAndRotation(Node<T> node) {
        
        if (isEmpty(node)) {
            
            return;
            
        }
        
        Node<T> parent = node.getParent();
        
        if (!isEmpty(parent) && parent.getColor() == RED) {
            
            Node<T> grandParent = node.getParent().getParent();
            
            if (isEmpty(grandParent)) {
                
                return;
                
            }
            
            Node<T> uncle = parent.isLeft() ? grandParent.getRight() : grandParent.getLeft();
            
            if (!isEmpty(uncle) && uncle.getColor() == RED) {
                
                reColor(parent, uncle, grandParent);
                
            } else if (parent.isLeft()) { // left heavy sitution

                leftHeavySitution(node, parent, grandParent);
                
            } else if (!parent.isLeft()) { // right heavy sitution

                rightHeavySitution(node, parent, grandParent);
                
            }
            
        }
        
        root.setColor(BLACK);
        
    }
    
    private void reColor(Node<T> parent, Node<T> uncle, Node<T> grandParent) {
        
        parent.flipColor();
        uncle.flipColor();
        grandParent.flipColor();
        
        applyReColorAndRotation(grandParent);
        
    }
    
    private void leftHeavySitution(Node<T> node, Node<T> parent, Node<T> grandParent) {
        
        if (!node.isLeft()) { // L-R sitution

            rotateLeft(parent);
            
        }

        //L-L sitution
        parent.flipColor();
        grandParent.flipColor();
        
        rotateRight(grandParent);
        
        applyReColorAndRotation(node.isLeft() ? parent : grandParent);
        
    }
    
    private void rightHeavySitution(Node<T> node, Node<T> parent, Node<T> grandParent) {
        
        if (node.isLeft()) { // R-L sitution

            rotateRight(parent);
            
        }

        //R-R sitution
        parent.flipColor();
        grandParent.flipColor();
        
        rotateLeft(grandParent);
        
        applyReColorAndRotation(node.isLeft() ? grandParent : parent);
        
    }
    
    private void rotateLeft(Node<T> node) {
        
        if (isEmpty(node)) {
            
            return;
            
        }
        
        Node<T> right = node.getRight();
        Node<T> rightLeft = node.getRight().getLeft();
        
        node.setRight(rightLeft);
        
        if (!isEmpty(node.getRight())) {
            
            node.getRight().setParent(node);
            
        }
        
        right.setLeft(node);
        right.setParent(node.getParent());
        
        updateChildOfParent(node, right);
        
        node.setParent(right);
        
    }
    
    private void rotateRight(Node<T> node) {
        
        if (isEmpty(node)) {
            
            return;
            
        }
        
        Node<T> left = node.getLeft();
        Node<T> leftRight = node.getLeft().getRight();
        
        node.setLeft(leftRight);
        
        if (!isEmpty(node.getLeft())) {
            
            node.getLeft().setParent(node);
            
        }
        
        left.setRight(node);
        left.setParent(node.getParent());
        
        updateChildOfParent(node, left);
        
        node.setParent(left);
        
    }
    
    private void updateChildOfParent(Node<T> node, Node<T> tempNode) {
        
        if (isEmpty(node.getParent())) {
            
            root = tempNode;
            
        } else if (node.isLeft()) {
            
            node.getParent().setLeft(tempNode);
            
        } else if (!node.isLeft()) {
            
            node.getParent().setRight(tempNode);
            
        }
        
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
    
    private T getMin(Node<T> node) {
        
        if (!isEmpty(node.getLeft())) {
            
            return getMin(node.getLeft());
            
        }
        
        return node.getData();
        
    }
    
    @Override
    public void visit() {
        
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
    
    private boolean isEmpty() {
        
        return isEmpty(root);
        
    }
    
    private boolean isEmpty(Node<T> node) {
        
        return node == null;
        
    }
    
}
