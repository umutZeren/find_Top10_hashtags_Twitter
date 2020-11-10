package hash;

import java.util.Comparator;

public class Node<Key> 
{
	//This class represents node structure fore sequential search classes 
	// Node.
	 
		  // linked-list node
	//Every node have key for hashing
			 Key key;
			 /// int val holds number of occurences in hashtags
			 int val;
			 Node next;
			  Node(int val) 
			 {
				 this.val = val;
			 }
			 public Node(Key key, int val1, Node next1)
			 {
					// Summary:A constructor for node class
					// Precondition: gets value and next node and key 
					// Postcondition: constructs a new node with the given args.
				 this.key = key;
				 this.val = val;
				 this.next = next1;
			 }
	 
}
