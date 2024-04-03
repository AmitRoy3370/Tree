package Heap;

public interface Tree<T extends Comparable<T>> {

    Tree<T> add(T data);

    T delete();

    Tree<T> sort();

}
