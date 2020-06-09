import java.util.Comparator;


public class Term implements Comparable<Term> {
    
    private final long weight;
    private final String query;
    
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null) throw new NullPointerException("test");
        if (weight < 0) throw new IllegalArgumentException();
        this.query = query;
        this.weight = weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
                if (t1.weight == t2.weight) 
                    return 0;
                if (t1.weight > t2.weight) 
                    return -1;
              //if (t1.weight < t2.weight) //kind of dumb you can't so it this way
                    return 1;
            }
        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException();
        final int rr = r;
        return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
                //int smaller;
                String first;
                String second;
                
                //smaller = t1.query.length() < t2.query.length() ? t1.query.length() : t2.query.length();
                
                
                if (t1.query.length() < rr) {
                    first = t1.query;}
                else { first = t1.query.substring(0,rr);}
                
                if (t2.query.length() < rr) {
                    second = t2.query;}
                else { second = t2.query.substring(0,rr);}
                
                
                return first.compareToIgnoreCase(second); // why do i need this again?
                
                
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        
        return this.query.compareToIgnoreCase(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        
        return weight + "    " + query;//weight + "\t" + query;
        
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work)
    public static void main(String[] args) {
        /**
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 0);
        terms[1] = new Term("Baylor", 0);
        terms[2] = new Term("Gaerry", 0);
        terms[3] = new Term("Tabbon", 0);
        terms[4] = new Term("Taavon", 0);
        
        Arrays.sort(terms);
        for(Term t : terms) {
            System.out.println(t);
        }
        System.out.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for(Term t : terms) {
            System.out.println(t);
        }
        System.out.println();
        Arrays.sort(terms, Term.byPrefixOrder(3));
        for(Term t : terms) {
            System.out.println(t);
        }**/
        // read in the terms from a file
        /**String filename = args[0];
        In in = new In("wiktionary.txt");
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        } **/
        
    }
}
