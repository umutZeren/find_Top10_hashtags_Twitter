package hash;

public class SeparateChainingHashST<Key>
{
 private int N; // number of key-value pairs
 private int M; // hash table size
 protected SequentialSearchST<Key>[] st; // array of ST objects
 public int hashSize =0;


 public SeparateChainingHashST()
 {
	 this(997); 
 }
 public SeparateChainingHashST(int M)
 { 	// Create M linked lists.
	 this.M = M;
	 st = (SequentialSearchST<Key>[]) new SequentialSearchST[M];
	 for (int i = 0; i < M; i++)
	 st[i] = new SequentialSearchST();
 }
 //overloading hash
 
 
 
 private int hash(Key key )
 {
	 return (key.hashCode() & 0x7fffffff) % M; 
 }

 public Node get(Key key) 
 {
	 return st[hash(key)].get(key);
 } 
 public void put(Key key, int start)
 { 
	 st[hash(key)].put(key,start);
	 hashSize++;
 }
 
 
 
}