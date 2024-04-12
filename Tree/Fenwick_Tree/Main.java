
package Fenwick_Tree;

public class Main {
    
    public static void main(String[] args) {
        
        int a[] = new int[]{3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        
        FenWick fenwick = new FenWick(a);
        
        fenwick.build();
        
        fenwick.print();
        
        System.out.println(fenwick.query(3, 5));
        
    }
    
}
