package Ternary_Search_Tree;

public class Main {

    public static void main(String[] args) {

        Tree tree = new TST();

        tree.add("ant");
        tree.add("and");
        tree.add("anas");
        tree.add("anam");
        tree.add("cat");
        tree.add("car");
        tree.add("rat");
        tree.add("ram");
        tree.add("tie");
        tree.add("tide");
        tree.add("at");
        tree.add("am");
        tree.add("an");

        tree.print();

        System.out.println("anas is at here :- " + tree.search("anas"));
        System.out.println("anam is at here :- " + tree.search("anam"));
        System.out.println("cat is at here :- " + tree.search("cat"));
        System.out.println("rat is at here :- " + tree.search("rat"));

        tree.delete("an");

        tree.print();

        System.out.println("after delete and and is at here :- " + tree.search("and"));
        System.out.println("after delete an an is present :- " + tree.search("an"));
        System.out.println("after delete an ant is at here :- " + tree.search("ant"));

        System.out.println("now, we delete rat from here");

        tree.delete("rat");

        tree.print();

        System.out.println("rat is now present :- " + tree.search("rat"));

        System.out.println("ram is still at here :- " + tree.search("ram"));

        System.out.println("acat is at here :- " + tree.search("acat"));
        System.out.println("acar is at here :- " + tree.search("acar"));
        System.out.println("at and am is at here :- " + tree.search("at") + " " + tree.search("am"));

        System.out.println("we delete anam from here.");

        tree.delete("anam");

        tree.print();

        System.out.println("now anam present :- " + tree.search("anam"));
        System.out.println("now anas is present :- " + tree.search("anas"));
        System.out.println("nam is a prefix now after delete :- " + tree.presentPrefix("nam"));

        System.out.println("add time at here.");

        tree.add("time");

        tree.print();

        System.out.println("now delete it.");

        tree.delete("time");

        System.out.println("now set :- ");

        tree.print();

        System.out.println("prefix me is now a here :- " + tree.presentPrefix("me"));

    }

}
