
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SeparateChainingHashST;


public class WordNet {
    
    private Digraph Connections;
    private SeparateChainingHashST<String, Bag<Integer>> synsetST;
    private SeparateChainingHashST<Integer, String> nounsST;
    //private ShortestCommonAncestor ancestor;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        
        int count = 0; // get size for digraph size since its not given 
        In insynsets = new In(synsets);
        In inhypernyms = new In(hypernyms);
        
        this.synsetST = new SeparateChainingHashST<String, Bag<Integer>>(); 
        this.nounsST = new SeparateChainingHashST<Integer, String>();
        
        
        while(insynsets.hasNextLine()) {
            
            
            String line = insynsets.readLine(); 
            
            String[] real = line.split(","); //read in string and break it up into tokens
            
            int index = Integer.parseInt(real[0]); //get the id
            
            nounsST.put(index, real[1]); //didnt realize this till later. Need for accessing noun in sca.
            
            String[] syn = real[1].split(" "); //split up the synset if there is more then one
            
            for (int i = 0; i < syn.length; i++) { //for every noun in the synset put it in the table with its id
                Bag<Integer> synbag = new Bag<Integer>();
                String word = syn[i];
                if (isNoun(word)){  //check to see if we have already added this sysnet.
                    
                    synsetST.get(syn[i]).add(index);// grab the bag that already exists
                    
                }  
                 
                if (!synsetST.contains(word)) {  //if not present already make a new bag and add
                    //Bag<Integer> newbag = new Bag<Integer>(); //to the HT
                    //nounsST.put(index, syn[i]);
                    synbag.add(index);
                    synsetST.put(syn[i], synbag);
                }
                
               
            }
            
            count++; 
            //this will get us our count for the digraph
            //since we dont know how big our file is.
            
        }
        
        this.Connections = new Digraph(count);
        while(inhypernyms.hasNextLine()) {
            
            String line = inhypernyms.readLine();
            String[] edgearray = line.split(","); //same as above 
            // just parsing through array and adding edges same as above
            int index = Integer.parseInt(edgearray[0]);
            for(int i = 1; i < edgearray.length; i++) {
                int edge = Integer.parseInt(edgearray[i]);
                Connections.addEdge(index, edge);
            }
           
        }
        
        //ancestor = new ShortestCommonAncestor(Connections);
        
        
    }

    // all WordNet nouns
    public Iterable<String> nouns() {
        
        return synsetST.keys();
        
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) { //just use contains call to see if we have the key already
        if(word == null) {throw new IllegalArgumentException("null word");}
        
        return synsetST.contains(word);
            
        
        
    }

    // return a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2) {
        ShortestCommonAncestor ancestor = new ShortestCommonAncestor(Connections);
        Bag<Integer> Noun1 = synsetST.get(noun1);
        Bag<Integer> Noun2 = synsetST.get(noun2);
        int scommon = ancestor.ancestor(Noun1, Noun2);
        String SCnoun = nounsST.get(scommon);
        return SCnoun;
        
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2) {
        ShortestCommonAncestor ancestor = new ShortestCommonAncestor(Connections);
        Bag<Integer> Noun1 = new Bag<Integer>(); //cant figure out why im having problems
        Bag<Integer> Noun2 = new Bag<Integer>();
        Noun1 = synsetST.get(noun1);
        Noun2 = synsetST.get(noun2);
        //Queue<Integer> q1 = new Queue<Integer>();
        
        
        int scommon = ancestor.length(Noun1, Noun2);
    
        return scommon;
        
    }

    // do unit testing of this class
    public static void main(String[] args) {
        //erased
        
        
    }

}
