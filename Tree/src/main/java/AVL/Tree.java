package AVL;

public interface Tree<T extends Comparable<T>> {

    Tree<T> add(T data);
    Tree<T> delete(T data);
    void traverse();
    T getMin();
    T getMax();
    
}
