package Ternary_Search_Tree;

public interface Tree {

    public Tree add(String word);

    public Tree delete(String word);

    public boolean search(String word);
    
    public void print();
    
    public boolean presentPrefix(String prefix);

}
