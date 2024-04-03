package SplayTree;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new Splay<>();

        tree.add(1);
        tree.add(2);

        System.out.println("after added 1 and 2");

        tree.visit();

        tree.add(3);

        System.out.println("after added 3");

        tree.visit();

        tree.add(4);
        tree.add(5);

        tree.add(6);
        tree.add(7);
        tree.add(8);

        System.out.println("after added 4, 5, 6, 7, 8");

        tree.visit();

        tree.add(9);

        System.out.println("after added 9");

        tree.visit();

        System.out.println("before delete size :- " + tree.size());
        
        tree.delete(9);

        System.out.println("after delete 9");

        tree.visit();

        System.out.println("after delete size is :- " + tree.size());
        
        System.out.print("9 is present :- ");
        
        System.out.println(tree.find(9));
        
        System.out.println("max now :- " + tree.getMax());
        
        tree.visit();
        
        System.out.println("finding 6 :- " + tree.find(6));

        System.out.println("after finding 6");

        tree.visit();

    }

}
