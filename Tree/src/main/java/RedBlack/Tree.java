package RedBlack;

public interface Tree<T> {

    Tree<T> add(T data);

    Tree<T> delete(T data);

    T getMax();

    T getMin();

    void visit();

}
