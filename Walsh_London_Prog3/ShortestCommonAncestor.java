import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.In;

public class ShortestCommonAncestor {
    Digraph G;
    private SeparateChainingHashST<Integer, Boolean> Marked;
    private int[] distToV;
    int ancestor;
    int length;
    int disV;
    int disW;
    Bag<Integer> bag; 
   // constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G) {
       this.G = G;
       if(G == null) {throw new NullPointerException("null input");}
       
       int gcount = 0;
       
       for(int i = 0; i < G.V(); i++ ) {
           int j = G.outdegree(i);
           if(j == 0) {
               gcount++;
           }
       }
       if (gcount != 1) { throw new IllegalArgumentException("not a rooted DAG");}
       Marked = new SeparateChainingHashST<Integer, Boolean>(G.V());
       distToV = new int[G.V()];
       bag = new Bag<Integer>();
       
   }

   // length of shortest ancestral path between v and w
   public int length(int v, int w) {
       
       int AdjustLength = ancestor(v, w);
       
       
        return length;
       }

   // a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w) {
       Queue<Integer> q = new Queue<Integer>();
       distToV[v] = 0;
       
       bag.add(v);
       Marked.put(v, true);
       q.enqueue(v);
       while (!q.isEmpty()) {
           int s = q.dequeue();
           for (int i : G.adj(s)) {
               if (Marked.get(i) == null) { //check!!!!
                   
                   distToV[i] = distToV[s] + 1;
                   bag.add(i);
                   Marked.put(i, true);
                   q.enqueue(i);
               }
           }
       } // end first while loop
       
       //Marked.put(w, true);
       if (Marked.get(w) != null) {
           ancestor = w;
           disV = distToV[w];
           
           disW = 0;
           length = disV + disW;
           return ancestor;
       }
       distToV[w] = 0;
       q.enqueue(w);
       while (!q.isEmpty()) {
           int s = q.dequeue();
           for (int j : G.adj(s)) {
               
               if (Marked.get(j) != null) {
                   ancestor = j;
                   disV = distToV[j];
                   distToV[j] = distToV[s] + 1;
                   disW = distToV[j];
                   
                   length = disW + disV;
                   return ancestor;
               }
               //else just move up the tree.
               if (Marked.get(j) == null) {
                   
                   distToV[j] = distToV[s] + 1;
                   Marked.put(j, true);
                   bag.add(j);
                   q.enqueue(j);
               }
               
           }
       }
       
       length = disV+disW;   
       //}
       for(int i : bag) {  //reset all marked ints to null
           Marked.put(i, null);
       }
       
    return ancestor;  
       
   }

   // length of shortest ancestral path of vertex subsets A and B
   public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
       
       int AdjustLength = ancestor(subsetA, subsetB);
    
       
       return length;
       
   }

   // a shortest common ancestor of vertex subsets A and B
   public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
       
       int TempSCA;
       int TempL = -1;
       
       for (int s : subsetA) { //just like outcast check arrays against each other
           
           for (int i : subsetB) {
               TempSCA = ancestor(s,i);
               if(TempL == -1) {  //needed for check on the first iteration. 
                   TempL = length;
               }
               if(TempL >= length) {
                   TempL = length;
                   ancestor = TempSCA;
               }
           }
           /*Marked.put(s, true); //felt bad deleting all this since it took me awhile.
           distToV[s] = 0;
           q.enqueue(s);*/
       }
       /*while (!q.isEmpty()) {
           int v = q.dequeue();
           for (int w : G.adj(v)) {
               if (Marked.get(w) == null) {
                   
                   distToV[w] = distToV[v] + 1;
                   Marked.put(w, true);
                   q.enqueue(w);
               }
           }
       }
       for (int s : subsetB) {
           Marked.put(s, true);
           distToV[s] = 0;
           q.enqueue(s);
       }
       
       while (!q.isEmpty()) {
           int v = q.dequeue();
           for (int w : G.adj(v)) {
               if (Marked.get(w) != null) {
                   ancestor = w;
                   disV = distToV[w];
                   distToV[w] = distToV[v] + 1;
                   disW = distToV[w];
                   
                   break;
               }
               
               if (Marked.get(w) == null) {
                   
                   distToV[w] = distToV[v] + 1;
                   Marked.put(w, true);
                   q.enqueue(w);
               }
           }
       }
       length = disV + disW;*/
       length = TempL;
    return ancestor;
       
       
   }

   // do unit testing of this class
   public static void main(String[] args) {
       
       //erased
   }
}

