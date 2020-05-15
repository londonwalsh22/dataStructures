/******************************************************************************
 *  Name: London Walsh
 *
 *  Hours to complete assignment (optional): 16 Hours
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

It works like ordinary binary search except uses compareTo to check the key against key in the middle of the array. I check to see if the key is less than or = to 0(its <= since I might have many matching prefixes but im only looking for the first instance) in the middle of the array and if it is I know that my first index is in the left half of the array and make mid my new hi. Else I know its the opposite and make mid my new lo. I return lo or hi if either is the term im looking for and -1 if it did not find anything.




/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor:
copying array(N) and mergesort(NlogN)
 = NlogN

allMatches():
2 Binary searches (2logN)
arrays.sort (MlogM)
 = 2logN + MlogM

numberOfMatches():
2 Binary Searches (2logN)
 = 2logN


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
I do not believe there are any bugs or limitations in my final code.


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I worked a bit on this assignment with Mike Callaghan talking through ideas of how to work through more difficult methods. Also helped Tucker Richlie when he was stuck on a few parts. talking through his problems logically.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
1) The Only big bug I ran into was in my Autocomplete and was pretty embarrasing(and by big bug I mean my own idiocy). I kept getting null pointer exceptions in my allmatches at the first use of BinarySearchDeluxe.I spent HOURS trying to find out why. I tested both my Term and BinarySearch Deluxe so I knew they were working. All my code looked like it should work but wouldn't go. I tried messing with my binary search and nothing. I assumed it was something with my sortby prefix order and tried many different combinations and nothing worked. Turns out my private final Term[] terms in autocomplete was the same as the Term[] terms in the constructor.....I just had to rename it term instead of terms since I was reusing the same name twice. And that is how I learned that you're your biggest enemy when it comes to programming.

2) The other semi-big complication I ran into was my in my search byprefix order in Term. it was working perfectly with wiktionary.txt but I was getting arrayindexoutofbounds exceptions when I ran cities.txt. it would work with some but not with others and I realized it had to do with the case of the letters when searching. This took me awhile since I was already using compartoignorecase in my compareto method. After putting compartoingorecase in my compareto instance in my prefixorder that seemed to solve it. I'm still not sure why I had to use it twice and why it wasnt working since it should have already been checking for case regardless???

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
This was a challenging assignment but I definitely learned a lot and enjoyed figuring out how to work through the problem. It took me a good deal of time to program and I didnt include all the time it took me to debug in my time at the top because it shouldnt have taken me the amount of time that it did. Although I definitely learned a lot about the importance of variable names and maybe to use more unique names specific to class in the future.


  