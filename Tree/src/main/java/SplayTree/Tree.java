package SplayTree;

public interface Tree<T extends Comparable<T>> {

    public Tree<T> add(T data);
    public Tree<T> delete(T data);
    public void visit();
    public T getMax();
    public T getMin();
    public boolean find(T data);
    public int size();
    
}
