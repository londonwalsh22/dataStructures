

public class Outcast {
    
    private WordNet Wnet;
    
   public Outcast(WordNet wordnet) {        // constructor takes a WordNet object
       
       Wnet = wordnet;
       
   }
   
   public String outcast(String[] nouns) {  // given an array of WordNet nouns, return an outcast
       String Outcast = "";
       int BigD = 0;
       for (int i = 0; i < nouns.length; i++) {
           int distance = 0;
           
           for(int j = 0; j < nouns.length; j++) {  //calculate total distance for i + each J in array
               String noun1 = nouns[i];
               String noun2 = nouns[j];
               int tempD = Wnet.distance(noun1, noun2); 
               if (j == i) {
                   tempD = 0;
               }
               distance = distance + tempD; // add up total distance for all i, j, combinations
           }
           
           if (BigD < distance) { //if current big distance is smaller than current distance replace and make that
               Outcast = nouns[i]; //the new current outcast
               BigD = distance;
           }
         //just tweaked what i did in SCA iterable call   
       }
    return Outcast;
       
   }
   
   public static void main(String[] args) {  // see test client below
       
       WordNet wordnet = new WordNet(args[0], args[1]);
       Outcast outcast = new Outcast(wordnet);
           In in = new In(args[2]);
           String[] nouns = in.readAllStrings();
           StdOut.println("outcast5: " + ": " + outcast.outcast(nouns));
       
   }
   
}
