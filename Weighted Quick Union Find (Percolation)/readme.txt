/******************************************************************************
 *  Name: London Walsh  
 *  NetID: 790-654-104
 *
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
	used an Integer array size (N*N)+N. Added the extra so when I checked bounds for the area below the bottom of the grid I didn't have to do anything crazy. it makes every value 0 initially and when I opened a site I changed the array index of that spot to 1. so when I checked down at the bottom of the array it was always 0. for the left and right check I used index%N=0 to check left and right bounds which I thought was clever since I had spent a lot of failed time trying different things but that worked really well. 
	I used a quick union of (N*N)+2. i made it so the first 0 to ((N*N)-1) were the grid using N to iterate each row and the extra 2 spots were my initalizers for top and bottom. I had checks to see if a index from 0 to N-1 was opened it would connect to the top intializer, and ((N*N)-1)-N to (N*N)-1 for the bottom row was opened it would connect to the Bottom Intializer. then I checked to see if it percolated if my last 2 extra indexes were connected.
	I checked to see if a spot was full by seeing if it was connected to my top Initializer. I also iterated through my array in perc to check if a spot was open. It would check if it was a 1 and return true. I was also able to figure out a simple equation for finding the index of a value based on the row and column that was input. this was what i used in most of methods.



/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to around
 *  60 seconds. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be a multiple of the preceding data point
 *****************************************************************************/

(keep T constant) T = 50

 n          time (seconds)
------------------------------
100         0.102
200         0.326
400         2.268
800         22.633

(keep n constant) N = 100

 T          time (seconds)
------------------------------
400          0.427
800          0.802
1600         1.544
3200         3.034


/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.


 *****************************************************************************/

running time (in seconds) as a function of n and T:  ~ 

 *  9.48*10^-10 * N^3 * T^1 ---rounded
 *  2.70*10^-10 * N^3.318 * T^.974 (unrounded)
******not sure which one you wanted but the less the T^(<1) fudges everything up*******

22.633/2.2633 = 9.979 -- log(Base2)9.979 = 3.318 about 3
3.034/1.544 = 1.965 --log(Base2)1.965 = .9745 about 1
3.034= a100^3*3200^1
a = 9.48*10^-10 (Rounded)

3.034 = a100^3.318*3200^.974
a = 2.70*10^-10 (unrounded a)

/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).

*****************************************************************************/

(keep T constant) T = 50

 n         time (seconds)
------------------------------
200         0.207
400         0.765
800         5.594
1600        31.054

(keep n constant) N = 100

 T          time (seconds)
------------------------------
200          0.189
400          0.318
800          0.59
1600         1.134


running time (in seconds) as a function of n and T:  ~ 

 *  7.09*10^-8 * N^2 * T^1 ---rounded
 *  1.24*10^-8 * N^2.47 * T^.942 (unrounded)
******not sure which one you wanted but the less the T^(<1) messes everything up*******

31.64/5.594 = 5.656 -- log(Base2)5.656 = 2.47 about 2 rounded down
1.134/.59 = 1.922 --log(Base2)1.922 = .942 about 1
1.134 = a100^2*1600^1
a = 7.09*10^-8 (rounded a)

1.134 = a100^2.47*1600^.942
a = 1.24*10^-8 (unrounded a)

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an n-by-n grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/
I used a normal int array for my percolation.
 ~ an int array uses 4N+24(+8for reference)bytes so.. 4N^2 + 32.
 ~ QWU uses two int arrays, 4 bytes for int object, 16 bytes overhead, 4 bytes padding 
2(total-arrays)* 4N^2 +32+(3*8)+2(extra spots) = 8N^2 + 90 bytes

 ~ so for a perc object with 16 bytes overhead, 4 bytes padding,
(4N^2) + 32 for array, 7 ints(7*4) and , 8N^2 + 90 for wqu
 ~ We get 12N^2 + 170 for a percolation object	
 ~ Using tilde to ignore low order terms we get 12N^2 Bytes

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Below

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Tucker Richlie and I both worked on this together. worked through best way to solve certain concepts in both programs with different methods. Lots of failed attempts on both parts. we tried lots of different things that failed miserably or took too long. No code was looked at, we just talked about how to solve the problems. My TA David also gave me help with certain tips on little errors I had in the beginning of running my programs. just small instantiating errors.


/******************************************************************************
 *  Describe any serious problems you encountered.                

*****************************************************************************/
Only two big problems. 
	First, in percolation i had trouble with the 2d array and realized i could iterate over by increments of N which worked way better. I hit some big snags figuring out how to check my bounds for the grid i was making with the single array. I found out that by indexing by N through my array and looking for remainders of 0 since all most left values were divisible by N. did the same for right side boundaries in the grid except by adding 1 so it was divisible by N. ex. if(bLeft >= 0 && (bLeft+1)%N != 0 && open[bLeft] == 1) { //check for boundary + if bLeft is less than 0
            union.union(boxnum, bLeft);
	Second, I hit a big snag in the percolationStats class. Originally tried using a double for loop and tried for an entire day to get this to work to no avail. first for loop iterated for T times. Second for loop would iterate N*N times. Would kick out before it even percolated sometimes giving me an index out of bounds when it added null values to my array. I tried making it bigger but run time would still suffer, and the potential for it ending without percolating was still possible.






/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. 

*****Honestly in the beginning I was having trouble at solving the problem and began having doubts. But after buckling down and working through the percolation class it made me enjoy finishing the rest of the assignment. It helped me realize that while this class is gonna be pretty tough its definitely possible and i'm gonna learn a ton. I also learned that you give us alot of time for a REASON and I will use my time much more effectively in the future.                                           
 *****************************************************************************/
