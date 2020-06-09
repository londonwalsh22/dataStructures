/******************************************************************************

 *  Name: London Walsh      ***Using my one week extension on this assignment***
 *
 *  Hours to complete assignment (optional): Probably Around 20.
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
 -- Separate chaining hash table. meets time constraint. Worst case after N inserts 
for search insertion and delete is logn in the worst case making it an ideal choice.
Also takes constant time to search and insert into array. 



/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
 -- I used a digraph to store the hypernyms becuase it was the easiest way to store
all the edges and takes constant time for all the operations(also because we have to pass a digraph into SCA). I split the lines into tokens and stored them in an array. Then I parsed the first integer index for the vertex and the other spots for the connections in the digraph.


/******************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithms as a function of the number of vertices V and the
 *  number of edges E in the digraph?
 *****************************************************************************/

Description: I iterated over all the digraph checking each vertices outdegree making sure that the digraph only contained one vertice with an outdegree of 0.

Order of growth of running time:  V*E  # of vertices* the # of edges.


/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method, what is the order of
 *  growth of the worst-case running time as a function of the number of
 *  vertices V and the number of edges E in the digraph? For each method,
 *  what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you should assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't
 *  forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description: I did all my computing in the ancestor method. Kept a global variable length that changed every call to ancestor. so for both my length methods all I had to do was call ancestor to change the length variable accordinglly. 

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)              ran out of time to compute trying to fix my program.

ancestor(int v, int w)

length(Iterable<Integer> v,
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,
         Iterable<Integer> w)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
-- not running correctly. my outcast seems to look right and will give me correct answers when tested with the files given to us. I believe my distance method in wordnet is not working correctly. I put alot of effort into this and am pretty dissapointed but ultimately couldn't get everything working perfectly.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do include any 
 *  help from people (including course staff, TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/

 -- I worked with Tucker Richlie periodically throught the project. We worked on both wordnet and sca together. Only discussion no code was looked at. I also got help with Michael Callaghan. Only helped push me in the right direction with sca as far as cutting down my array use.  

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
 -- Shortest common ancestor took me the longest time to complete. I had to change the 
the way i was doing the iterable method. I ended up just doing all my work for length
and ancestor in SCA but it works fine when testing the output.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

-- pretty tough assignment. Definitely broke me on this one. I didnt stop trying until the last minute though.....