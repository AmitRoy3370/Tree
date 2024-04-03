package BST;

public class BST<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    @Override
    public Tree<T> add(T data) {

        root = add(root, data);

        return this;

    }

    private Node<T> add(Node<T> node, T data) {

        if (isEmpty(node)) {

            node = new Node<>(data);

        }

        if (data.compareTo(node.getData()) > 0) {

            node.setRight(add(node.getRight(), data));

        } else if (data.compareTo(node.getData()) < 0) {

            node.setLeft(add(node.getLeft(), data));

        }

        return node;

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

            try {

                node.setLeft(delete(node.getLeft(), data));

            } catch (Exception e) {

            }

        } else if (data.compareTo(node.getData()) > 0) {

            try {

                node.setRight(delete(node.getRight(), data));

            } catch (Exception e) {

            }

        } else {

            if (isEmpty(node.getLeft())) {

                return node.getRight();

            } else if (isEmpty(node.getRight())) {

                return node.getLeft();

            }

            node.setData(getMax(node.getLeft()));

            try {

                node.setLeft(delete(node.getLeft(), node.getData()));

            } catch (Exception e) {

            }

        }

        return node;

    }

    @Override
    public boolean search(T data) {

        if (isEmpty()) {

            return false;

        }

        return !isEmpty(search(root, data));

    }

    private Node<T> search(Node<T> node, T data) {

        if (isEmpty(node)) {

            return null;

        }

        if (data.compareTo(node.getData()) < 0) {

            return search(node.getLeft(), data);

        } else if (data.compareTo(node.getData()) > 0) {

            return search(node.getRight(), data);

        }

        return node;

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
    public Tree<T> print() {

        System.out.print("in order traversal :- ");

        inOrder(root);

        System.out.println();

        System.out.print("pre order traversal :- ");

        preOrder(root);

        System.out.println();

        System.out.print("post order traversal :- ");

        postOrder(root);

        System.out.println();
        
        return this;

    }

    private void inOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        inOrder(node.getLeft());

        System.out.print(node.getData().toString() + " ");

        inOrder(node.getRight());

    }

    private void preOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        System.out.print(node.getData() + " ");

        preOrder(node.getLeft());
        preOrder(node.getRight());

    }

    private void postOrder(Node<T> node) {

        if (isEmpty(node)) {

            return;

        }

        postOrder(node.getLeft());
        postOrder(node.getRight());

        System.out.print(node.getData() + " ");

    }

    private boolean isEmpty() {

        return isEmpty(root);

    }

    private boolean isEmpty(Node<T> node) {

        return node == null;

    }

}
