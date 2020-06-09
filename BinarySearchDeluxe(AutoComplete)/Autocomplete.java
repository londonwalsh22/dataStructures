import java.util.Arrays;

import edu.princeton.cs.algs4.MergeX;

public class Autocomplete {
    private final Term[] term; // was terms and wouldn't work.

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) throw new NullPointerException();
        
        term = terms;
        //for(int i = 0; i< term.length; i++) { testing
            //System.out.println(term[i]);testing
        //}
        MergeX.sort(term); //linearithmic sort nlogn
        
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) throw new NullPointerException();
        
        Term spot1Term = new Term(prefix, 0); //took me a hot minute to figure out.
        
        int spot1 = BinarySearchDeluxe.firstIndexOf(term, spot1Term, Term.byPrefixOrder(prefix.length()));
        
        //this took me while to realize i had to make prefix a new term before it would work.
        int spot2 = BinarySearchDeluxe.lastIndexOf(term, spot1Term, Term.byPrefixOrder(prefix.length()));
        //gives us first spot and last spot of all the matches
        
        
        Term[] allMatch = new Term[spot2 - spot1 + 1];
        
        for (int i = 0; i < allMatch.length; i++) { //copy all prefix matches into new array and sort.
            allMatch[i] = term[spot1+ i];
        }
        
        Arrays.sort(allMatch, Term.byReverseWeightOrder());
        
        return allMatch; //return all out matches
        
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) throw new NullPointerException();
        Term sizeterm = new Term(prefix, 0);
        int spot1 = BinarySearchDeluxe.firstIndexOf(term, sizeterm, Term.byPrefixOrder(prefix.length()));
        int spot2 = BinarySearchDeluxe.firstIndexOf(term, sizeterm, Term.byPrefixOrder(prefix.length()));
        return 1 + spot2 - spot1;
    }
    public static void main(String[] args) {

     // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
            
        }
        
        
    }
    
}




