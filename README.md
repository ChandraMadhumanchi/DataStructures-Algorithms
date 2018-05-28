# Time Complexity

Big O : HOW TIME SCALES WITH RESPRCT TO SOME INPUT VARIABLES
       1) Different steps get added
       2) Drop constans
       3) Different inputs => different variables
       4) Drop non-dominate terms
 constant time  O(1) => Excelent
 O(log n) => Good
 linear time  O(n) => Fair
 O(n log n) => Bad
 quadratic time O(n^2) => Harrible
 O(2^n) => ""
 O(n!) => ""
 
 # DataStructures-Algorithms
 
 Arrays
 Linked Lists

 Stack
 		Last In First Out
 Queue
 		First In First Out
 		
	. Linear data structures
	. Flexible size
	 
 Trees:
 	Binary trees
 	
 	  	1) Binary Tree Search
 	  	2) Insert
 	  
 	Balanced tree   vs   UnBalanced tree
 	
 		inser: O(log n)       insert: O(n)
 		find : O(log n)       find : O(n)
 	
    Traversing
    
    	1. Inorder						2. Preorder						3.Postorder
    	
    	left then root then right		root then left then right		left then right then root
    	
 Graphs
 
 HashTable  
 
 	H => T									int hashCode(String s) { // some computaation}
 	A => A									String -> hashcode -> index
 	S => B									COLLISION
 	H => L                                  ----------
 	. => E                                  CHAINING -- > Hash table with linked list
 	
 	* For any problem, have hash tables at the top of your mid
 	O(1) for a good hashtable
 	O(n) for a terrible hashtable -> lots of collisions,ets...
 
 Sorting Algorithms
 	QuickSort
 	MergerSort