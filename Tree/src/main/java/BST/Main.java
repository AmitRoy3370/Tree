package BST;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new BST<>();

        tree.add(5);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(11);
        tree.add(10);
        tree.add(7);

        tree.print();

        System.out.println("max :- " + tree.getMax() + " min :- " + tree.getMin());

        System.out.println("data 11 is at here :- " + tree.search(11));

        System.out.println("now we delete 10.");

        tree.delete(10);

        System.out.println("now 10 is present :- " + tree.search(10));

        tree.print();

    }

}
