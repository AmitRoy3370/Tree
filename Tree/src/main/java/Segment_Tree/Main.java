package Segment_Tree;

public class Main {

    public static void main(String[] args) {

        int a[] = new int[]{3, 2, 1, 10, 8, 3, 1};

        Tree tree = new Tree(a);

        tree.add();

        tree.print();

        System.out.println("sum till 2 to 4 :- " + tree.query(2, 4));

        tree.update(2, 4);

        tree.print();

        System.out.println("now the range till 2 to 4 :- " + tree.query(2, 4));

    }

}
