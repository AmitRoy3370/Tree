package RedBlack;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new RedBlack();

        tree.add(20);
        tree.add(10);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(15);
        tree.add(13);
        tree.add(18);
        tree.add(19);
        tree.add(4);
        tree.add(11);
        tree.add(12);
        tree.add(9);
        tree.add(14);

        tree.visit();

        tree.add(16);
        tree.add(17);

        tree.visit();
        /*tree.add(53);
        tree.add(43);
        tree.add(32);
        tree.add(12);
        tree.add(23);
        tree.add(33);
        tree.add(70);
        tree.add(60);
        tree.add(65);
        tree.add(83);
        tree.add(10);
        tree.add(9);
        tree.add(2);

        System.out.println("our whole avl tree is ");

        tree.visit();

        System.out.println("we will delete 33");

        tree.delete(33);*/

        tree.delete(12);

        tree.visit();

    }

}
