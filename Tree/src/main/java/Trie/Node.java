package Trie;

import java.util.Map;
import java.util.HashMap;

public class Node {

    final char data;
    boolean endOfWord = false;
    Map<Character, Node> childrens = new HashMap<>();

    public Node(char data) {
        this.data = data;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public Map<Character, Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(Map<Character, Node> childrens) {
        this.childrens = childrens;
    }

}
