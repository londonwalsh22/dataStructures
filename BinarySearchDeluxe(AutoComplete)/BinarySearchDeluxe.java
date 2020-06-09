import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1
    // if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (key == null || a == null || comparator == null)
            throw new NullPointerException("test");
        // System.out.println(key);
        int lo = 0, hi = a.length - 1;
        
        // System.out.println(a[mid]);
        // Arrays.sort(a);
        //just used for bug finding earlier.
        // if (comparator.compare(a[0], key) ==0) return 0;
        while (lo + 1 < hi) { // was lo+1
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) <= 0)
                hi = mid;
            else
                lo = mid;

        }
        if (comparator.compare(key, a[lo]) == 0) {
            return lo;
        }
        if (comparator.compare(key, a[hi]) == 0) {
            return hi;
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if
    // no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (key == null || a == null)
            throw new NullPointerException();

        //Arrays.sort(a);
        int lo = 0, hi = a.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) >= 0)
                lo = mid;
            else
                hi = mid;

        }
        if (comparator.compare(key, a[hi]) == 0) {
            return hi;
        }
        if (comparator.compare(key, a[lo]) == 0) {
            return lo;
            //took me awhile to realize i needed return statements outside the while loop
        }
        return -1;
    }

    
    public static void main(String[] args) {

        //deleted this on accident forgive me for my sins!!!
        
        
        
        
        
        
    }
}
