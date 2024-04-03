package Ternary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class TST implements Tree {

    Node root;

    @Override
    public Tree add(String word) {

        root = add(root, word.toCharArray(), 0);

        return this;

    }

    private Node add(Node node, char word[], int index) {

        if (isEmpty(node)) {

            node = new Node(word[index]);

        }

        if (word[index] > node.getData()) {

            node.setRight(add(node.getRight(), word, index));

        } else if (word[index] < node.getData()) {

            node.setLeft(add(node.getLeft(), word, index));

        } else if (index < word.length - 1) {

            node.setMiddle(add(node.getMiddle(), word, index + 1));

        } else if (index == word.length - 1) {

            node.setEndCharacter(true);

        }

        return node;

    }

    @Override
    public Tree delete(String word) {

        if (isEmpty()) {

            return this;

        }

        if (!search(word)) {

            return this;

        }

        delete(root, word.toCharArray(), 0);

        return this;

    }

    private void delete(Node node, char word[], int index) {

        if (isEmpty(node)) {

            return;

        }

        if (word[index] > node.getData()) {

            delete(node.getRight(), word, index);

        } else if (word[index] < node.getData()) {

            delete(node.getLeft(), word, index);

        } else {

            if (index == word.length - 1) {

                node.setEndCharacter(false);

                if (free(node)) {

                    node = null;

                }

            } else {

                delete(node.getMiddle(), word, index + 1);

            }

        }

    }

    private boolean free(Node node) {

        return !(!isEmpty(node.getLeft()) || !isEmpty(node.getRight()) || !isEmpty(node.getMiddle()));

    }

    @Override
    public boolean search(String word) {

        if (isEmpty()) {

            return false;

        }

        Node node = contain(root, word.toCharArray(), 0);

        return !isEmpty(node) && node.isEndCharacter();

    }

    private Node contain(Node node, char word[], int index) {

        if (isEmpty(node)) {

            return null;

        }

        if (word[index] > node.getData()) {

            return contain(node.getRight(), word, index);

        } else if (word[index] < node.data) {

            return contain(node.getLeft(), word, index);

        } else if (index < word.length - 1) {

            return contain(node.getMiddle(), word, index + 1);

        } else if (index == word.length - 1) {

            return node;

        }

        return node;

    }

    private boolean isEmpty() {

        return isEmpty(root);

    }

    private boolean isEmpty(Node node) {

        return node == null;

    }

    @Override
    public void print() {

        if (isEmpty()) {

            return;

        }

        List<String> list = new ArrayList<>();

        print(root, "", list);

        for (String i : list) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

    private void print(Node node, String word, List<String> list) {

        if (isEmpty(node)) {

            return;

        }

        print(node.getLeft(), word, list);

        word += node.getData();

        if (node.isEndCharacter()) {

            list.add(word);

        }

        print(node.getMiddle(), word, list);

        word = word.substring(0, word.length() - 1);

        print(node.getRight(), word, list);

    }

    @Override
    public boolean presentPrefix(String prefix) {

        Node node = contain(root, prefix.toCharArray(), 0);

        return !isEmpty(node);

    }

}
