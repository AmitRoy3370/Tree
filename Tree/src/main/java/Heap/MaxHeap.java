package Heap;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    public void fixUpWard() {

        int index = position;

        int parentIndex = (index - 1) / 2;

        while (index >= 0 && heap[index].compareTo(heap[parentIndex]) > 0) {

            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;

        }

    }

    @Override
    public void fixDownWard(int endIndex) {

        if (endIndex == -1) {

            return;

        }

        int index = 0;

        while (index <= endIndex) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left > endIndex) {

                break;

            }

            int childToSwap = right > endIndex ? left : heap[left].compareTo(heap[right]) > 0 ? left : right;

            if (heap[index].compareTo(heap[childToSwap]) > 0) {

                break;

            }

            swap(index, childToSwap);

            index = childToSwap;

        }

    }

}
