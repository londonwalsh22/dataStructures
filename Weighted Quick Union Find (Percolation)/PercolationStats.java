import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
    
    int N, T, i, p, row, col;
    double[] exp; //needs to be a double since it will be storing threshold
    double Opencount; 
    double output;
    
    
    
   public PercolationStats(int N, int T) {  // perform T independent experiments on an N-by-N grid
       if (N <= 0) {throw new IllegalArgumentException();}
       if (T <= 0) {throw new IllegalArgumentException();}
       exp = new double [T];
       output = 0;
       this.N = N;
       this.T = T;
       
       for (i = 0; i < T; i++) {  //run T experiments
           Opencount = 0;
           Percolation perc = new Percolation(N);
           while(!perc.percolates()) {   //run the percolation till it percolates
               int row = StdRandom.uniform(N);//random row and col
               int col = StdRandom.uniform(N);
               
               while(!perc.isOpen(row, col)) { //if the site is already open try again
                   
                   perc.open(row, col);
                   Opencount++;
               }
                 //end of first for loop, originally tried using a double for loop
               //and tried for an entire day to get this to work to no avail. what a waste...
               //would kick out before it even percolated giving me an index out of bounds running n*n trials
           }
           output = perc.numberOfOpenSites()/(double)(N*N);
           exp[i] = output; 
           
           
       } // end of for loop
       
       
   }
   
   public double mean() {                    // sample mean of percolation threshold
   
       return StdStats.mean(exp);
   }
   
   
   public double stddev() {                 // sample standard deviation of percolation threshold
   
       return StdStats.stddev(exp);
   
   }
   
   public double confidenceLow() {          // low  endpoint of 95% confidence interval
   
       return mean() - (1.96*stddev()) / Math.sqrt(T);
   
   }
   
   public double confidenceHigh() {         // high endpoint of 95% confidence interval
   
       return mean() + (1.96*stddev()) / Math.sqrt(T);
   }
   
   public static void main(String[] args) {  // unit testing (suggested)
       
   
       
   }
   
}
