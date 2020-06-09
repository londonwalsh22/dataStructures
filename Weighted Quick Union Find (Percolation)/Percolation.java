

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    int N, boxnum, bRight, bLeft, bUp, bDown, openSites;
    int[] open;  //this will store my 1's and 0's to tell me if an index is open or not 1=open
    
    public WeightedQuickUnionUF union;
    
    public Percolation(int N)  {               // create N-by-N grid, with all sites initially blocked
        if (N <= 0) { throw new IllegalArgumentException();}
        
        this.N = N;
        open = new int[(N*N)+N];//this way when i'm checking neighbors i don't have to throw
        //array index out of bounds exception
        union = new WeightedQuickUnionUF(N*N+2); //last 2 spots for initializer points
        
        
    
    }  
   
    
    public void open(int row, int col) {      // open the site (row, col) if it is not open already
        if (row < 0 || row > N-1) { throw new IndexOutOfBoundsException();}
        if (col < 0 || col > N-1) { throw new IndexOutOfBoundsException();}
        boxnum = N * ((row+1)-1)+(col+1)-1; //this will give us the number thats being referenced.
        
        open[boxnum] = 1; //requested index gets changed to open
        bRight = boxnum+1; //this will find the indexes for # left right up and down of boxnum
        bLeft = boxnum-1;
        bUp = boxnum-N;
        bDown = boxnum+N;
        //union all neighbors that are also open, array is big
        // 
        if(open[bRight] == 1 && bRight%N != 0 ) { //check for boundary
            union.union(boxnum, bRight); 
        }
        if(bLeft >= 0 && (bLeft+1)%N != 0 && open[bLeft] == 1) { //check for boundary + if bLeft is less than 0
            union.union(boxnum, bLeft);
        } 
        if(bUp >= 0 && open[bUp] == 1) {
            union.union(boxnum, bUp);
        }
        if(open[bDown] == 1) {
            union.union(boxnum, bDown);
        }
        if (boxnum <= N-1) {
            union.union(boxnum, (((N*N)-1)+1)); //union first row to top initializer
        }
        if (boxnum >= ((N*N)-1)-(N-1)) {
            union.union(boxnum, (N*N)+1); //union bottom open sites to bottom initializer
        }
        
       
        
    
    }
 
    public boolean isOpen(int row, int col) {  // is the site (row, col) open?
        if (row < 0 || row > N-1) { throw new IndexOutOfBoundsException();}
        if (col < 0 || col > N-1) { throw new IndexOutOfBoundsException();}
        boxnum = N * ((row+1)-1)+(col+1)-1;
        
        return open[boxnum] == 1;
        
    }
    
    
    public boolean isFull(int row, int col) {  // is the site (row, col) full?
        if (row < 0 || row > N-1) { throw new IndexOutOfBoundsException();}
        if (col < 0 || col > N-1) { throw new IndexOutOfBoundsException();}
        boxnum = N * ((row+1)-1)+(col+1)-1;
        return union.connected(boxnum, (N*N));
    }
    
    
    public int numberOfOpenSites() {          // number of open sites
        openSites = 0;
        for(int i = 0; i < open.length; i++) {
            if(open[i] == 1) {
                openSites += 1;
            }
        }
        return openSites;
    
    
    }
    
    
    public boolean percolates() {              // does the system percolate?
        return union.connected((N*N), (N*N)+1);
    }
    
    
    public static void main(String[] args) {  // unit testing (suggested)
        
        
    
       
    }
    
    
}
