
package AVL;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> avl = new AVL<>();

        avl.add(53);
        avl.add(43);
        avl.add(32);
        avl.add(12);
        avl.add(23);
        avl.add(33);
        avl.add(70);
        avl.add(60);
        avl.add(65);
        avl.add(83);
        avl.add(10);
        avl.add(9);
        avl.add(2);

        System.out.println("our whole avl tree is ");

        avl.traverse();

        System.out.println("we will delete 33");

        avl.delete(33);

        avl.traverse();

    }

}
