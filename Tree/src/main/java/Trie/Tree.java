package Trie;

import java.util.List;

public interface Tree {

    public Tree add(String s);

    public Tree delete(String s);

    public boolean search(String s);

    public List<String> wordsWithPrefix(String s);

    public boolean containsrefix(String prefix);

}
