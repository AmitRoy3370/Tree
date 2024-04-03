package BST;

public interface Tree<T extends Comparable<T>> {

    public Tree<T> add(T data);
    public Tree<T> delete(T data);
    public boolean search(T data);
    public T getMax();
    public T getMin();
    public Tree<T> print();
    
}
