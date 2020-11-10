package hash;
public class SequentialSearchST<Key> {

	//this classs represent 
	// first node in the linked list

		 protected Node first;
		 public Node get(Key key)
		 {
			 // Search for key, return associated value.
			 for (Node x = first; x != null; x = x.next)
			 if (key.equals(x.key))
				 return x; // search hit
			 
			 return  null; // search miss
		 }
		 public void put(Key key, int val)
		 { 
			 // Search for key. Update value if found; grow table if new.
			 for (Node x = first; x != null; x = x.next)
				 {
					 if (key.equals(x.key))
					 { 
						 x.val = val;				
						 return; 
					 } // Search hit: update val.

				 }first = new Node(key, val, first); // Search miss: add new node.
		 }
}

