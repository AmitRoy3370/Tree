package Heap;

public class Main {

    public static void main(String[] args) {

        System.out.println("max heap :- ");
        
        MaxHeap<Integer> tree = new MaxHeap<>();

        tree.add(3);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(9);
        tree.add(0);
        tree.add(2);
        tree.add(1);
        
        tree.print();

        System.out.println("after sorted :- ");

        tree.sort();

        tree.print();

        System.out.println("max delete :- " + tree.delete());

        System.out.println("after delete :- ");

        tree.print();

        System.out.println("min heap :- ");
        
        MinHeap<Integer> tree_ = new MinHeap<>();

        tree_.add(3);
        tree_.add(5);
        tree_.add(4);
        tree_.add(6);
        tree_.add(1);
        tree_.add(2);
        tree_.add(7);
        tree_.add(9);
        tree_.add(0);
        tree_.add(2);
        tree_.add(1);

        tree_.print();

        System.out.println("after sorted :- ");

        tree_.sort();

        tree_.print();

        System.out.println("max delete :- " + tree_.delete());

        System.out.println("after delete :- ");

        tree_.print();

    }

}
