package Trie;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.add("algorithom");
        trie.add("algo3370");
        trie.add("algo");
        trie.add("amit");
        trie.add("arpon");
        trie.add("like");
        trie.add("life");

        System.out.println("like is present at here :- " + trie.search("like"));

        System.out.println("life is present at here :- " + trie.search("life"));

        List<String> list = trie.wordsWithPrefix("algo");

        System.out.print("prefixes of algo :- ");

        for (String i : list) {

            System.out.print(i + " ");

        }

        System.out.println();

        list = trie.wordsWithPrefix("a");

        System.out.print("prefixes of a is :- ");

        for (String i : list) {

            System.out.print(i + " ");

        }

        System.out.println();

        System.out.println("prefix li is present at here :- " + trie.containsrefix("li"));

        trie.delete("like");

        System.out.println("after delete like is preseent :- " + trie.search("like"));

        System.out.println("word life is present :- " + trie.search("life"));

        System.out.println("prefix li is present now :- " + trie.containsrefix("li"));

    }

}
