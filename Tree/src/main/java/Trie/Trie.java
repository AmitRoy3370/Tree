package Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie implements Tree {
    
    Node root;
    
    public Trie() {
        
        root = new Node(' ');
        
    }
    
    @Override
    public Tree add(String s) {
        
        Node currentNode = root;
        
        Map<Character, Node> childrens = root.getChildrens();
        
        char x[] = s.toCharArray();
        
        for (char ch : x) {
            
            if (childrens.containsKey(ch)) {
                
                currentNode = childrens.get(ch);
                
            } else {
                
                currentNode = new Node(ch);
                childrens.put(ch, currentNode);
                
            }
            
            childrens = currentNode.getChildrens();
            
        }
        
        currentNode.setEndOfWord(true);
        
        return this;
        
    }
    
    @Override
    public Tree delete(String s) {
        
        if (!search(s)) {
            
            return this;
            
        }
        
        Node currentNode = root;
        Map<Character, Node> childrens = root.getChildrens();
        
        char x[] = s.toCharArray();
        
        List<Node> list = new ArrayList<>();
        
        for (char ch : x) {
            
            if (!childrens.containsKey(ch)) {
                
                return this;
                
            }
            
            currentNode = childrens.get(ch);
            childrens = currentNode.getChildrens();
            
            list.add(currentNode);
            
        }
        
        if (list.isEmpty() || list.size() != x.length) {
            
            return this;
            
        }
        
        list.get(list.size() - 1).setEndOfWord(false);
        
        for (int i = list.size() - 1; i > 0; --i) {
            
            currentNode = list.get(i);
            
            if (currentNode.isEndOfWord()) {
                
                break;
                
            } else if (currentNode.getChildrens().isEmpty()) {
                
                list.get(i - 1).getChildrens().remove(currentNode.data);
                
            }
            
        }
        
        return this;
        
    }
    
    @Override
    public boolean search(String s) {
        
        Node node = find(s);
        
        return node != null && node.isEndOfWord();
        
    }
    
    private Node find(String s) {
        
        Node currentNode = root;
        
        Map<Character, Node> childrens = root.getChildrens();
        
        char x[] = s.toCharArray();
        
        for (char ch : x) {
            
            if (!childrens.containsKey(ch)) {
                
                return null;
                
            }
            
            currentNode = childrens.get(ch);
            childrens = currentNode.getChildrens();
            
        }
        
        return currentNode;
        
    }
    
    @Override
    public List<String> wordsWithPrefix(String s) {
        
        Node prefix = find(s);
        
        List<String> words = new ArrayList<>();
        
        if (prefix != null) {
            
            addWords(s, words, prefix);
            
        }
        
        return words;
        
    }
    
    private void addWords(String word, List<String> list, Node prefix) {
        
        if (prefix.isEndOfWord()) {
            
            list.add(word);
            
        }
        
        for (Node node : prefix.getChildrens().values()) {
            
            String s = node.data + "";
            
            addWords(word.concat(s), list, node);
            
        }
        
    }
    
    @Override
    public boolean containsrefix(String prefix) {
        
        Node node = find(prefix);
        
        return node != null;
        
    }
    
}
