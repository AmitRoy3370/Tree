package Segment_Tree;

public class Tree {

    int segment[], a[];

    int len, n;

    public Tree(int[] a) {

        this.a = a;

        this.n = this.a.length;

        this.len = (int) Math.ceil(Math.log(n) / Math.log(2));

        this.len = 2 * (int) Math.pow(2, this.len) - 1;

        this.segment = new int[len];

    }

    public void add() {

        add(0, 0, n - 1);

    }

    private int add(int segmentIndex, int l, int r) {

        if (l > r) {

            return 0;

        }

        if (l == r) {

            return segment[segmentIndex] = a[l];

        }

        int mid = (l + r) / 2;

        return segment[segmentIndex] = add(2 * segmentIndex + 1, l, mid) + add(2 * segmentIndex + 2, mid + 1, r);

    }

    public void update(int index, int element) {

        int oldElement = a[index];
        int newElement = element;

        a[index] = element;

        update(0, 0, n - 1, index, newElement - oldElement);

    }

    private void update(int segmentIndex, int start, int end, int index, int difference) {

        if (start > end) {

            return;

        }

        int mid = (start + end) / 2;

        if (index > end || start > index) {

            return;

        }

        if (index >= start && end >= index) {

            segment[segmentIndex] += difference;

        }

        if (start != end) {

            update(2 * segmentIndex + 1, start, mid, index, difference);
            update(2 * segmentIndex + 2, mid + 1, end, index, difference);

        }

    }

    public int query(int l, int r) {

        return search(0, 0, n - 1, l, r);

    }

    private int search(int i, int start, int end, int l, int r) {

        if (start > end) {

            return 0;

        }

        if (start == end) {

            if (start >= l && r >= end) {

                return segment[i];

            }

            return 0;

        }

        int mid = (start + end) / 2;

        if (start > r || l > end) {

            return 0;

        }

        if (start >= l && r >= end) {

            return segment[i];

        }

        return search(2 * i + 1, start, mid, l, r) + search(2 * i + 2, mid + 1, end, l, r);

    }

    public void print() {

        for (long i : segment) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

}
