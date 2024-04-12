package Fenwick_Tree;

public class FenWick {

    int a[], tree[];
    int n;

    public FenWick(int a[]) {

        this.a = a;
        this.n = this.a.length;
        this.tree = new int[n + 1];

    }

    void build() {

        for (int i = 1; i != n + 1; ++i) {

            prepare(i, a[i - 1]);

        }

    }

    void prepare(int i, int value) {

        while (i < tree.length) {

            tree[i] += value;

            i = next(i);

        }

    }

    int getSum(int i) {

        ++i;

        int sum = 0;

        while (i > 0) {

            sum += tree[i];

            //System.out.println("i :- " + i);
            i = back(i);

        }

        return sum;

    }

    int query(int l, int r) {

        return getSum(r) - getSum(l - 1);

    }

    int next(int x) {

        return x + (x & -x);

    }

    int back(int x) {

        return x - (x & -x);

    }

    void print() {

        for (int i : tree) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

}
