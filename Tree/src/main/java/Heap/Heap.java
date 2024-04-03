package Heap;

import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> implements Tree<T> {

    protected T[] heap;
    protected int position = -1;

    public Heap() {

        heap = (T[]) new Comparable[2];

    }

    @Override
    public Tree<T> sort() {

        for (int i = 0; i <= position; ++i) {

            swap(0, position - i);
            fixDownWard(position - i - 1);

        }

        return this;

    }

    public void print() {

        for (T i : heap) {

            if (i == null) {

                break;

            }

            System.out.print(i.toString() + " ");

        }

        System.out.println();

    }

    @Override
    public T delete() {

        if (isEmpty()) {

            return null;

        }

        T result = heap[0];

        heap[0] = heap[--position];

        heap[position + 1] = null;

        fixDownWard(position);

        return result;

    }

    @Override
    public Tree<T> add(T data) {

        if (isFull()) {

            reSize(2 * heap.length);

        }

        heap[++position] = data;

        fixUpWard();

        return this;

    }

    public abstract void fixUpWard();

    public abstract void fixDownWard(int endIndex);

    public void swap(int i, int j) {

        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    private boolean isFull() {

        return position == heap.length - 1;

    }

    private void reSize(int capacity) {

        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);

    }

    private boolean isEmpty() {

        return heap.length == 0;

    }

}
