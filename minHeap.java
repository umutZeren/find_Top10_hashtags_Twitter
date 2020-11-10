package hash;

public class minHeap
{
	// this class blue prints a minheap
	
//max capaticy
private int max =10;
//current size 
protected int size = 0;
//heap array representation created
Node Heap[] =new Node[10];
// return indexes helper methods
private int leftChild(int parentIndex){return 2*parentIndex+1;}
private int rightChild(int parentIndex){return 2*parentIndex+2;}
private int parentIndex(int childIndex) {return (childIndex-1)/2;}

// to check isleaf 
private boolean hasleftChild(int pindex) {return leftChild(pindex)<size;}
private boolean hasrightChild(int pindex) {return rightChild(pindex)<size;}
private boolean hasParent(int pindex) {return parentIndex(pindex)<size;}

// to swap when heapify
private void swap(int start, int end) 
{
	// Summary: swaps two nodes w.r.t indexes
	// Precondition:gets int start and int end as indexes to swap
	// Postcondition: swaps in heap  according to given indexes

	Node temp = this.Heap[start];
	this.Heap[start]= this.Heap[end];
	this.Heap[end]= temp;
}
//get the 0th node ie min
public Node poll() 
{
	// Summary: deletes and returns min in heap
	// Precondition: heap is created with new keyword
	// Postcondition: min returned and array size decreased then array is heapified.

	//take 0th item to return
	Node item =this.Heap[0];
	// 0th item  is now last item
	this.Heap[0] = this.Heap[size-1];
	//size decreased
	size--;
	//heapify to preserve order 
	heapifyDown();
	//return deleted
	return item;
}
public void add(Node n) 
{

	// Summary: adds new node to heap 
	// Precondition: heap is created with new keyword, gets Node n
	// Postcondition: new node added and heap heapifed

	// add new node to last
	Heap[size]=n;
	// increase size
	size++;
	//heapify to preserve order 
	heapifyUp();
}


protected void heapifyUp() 
{
	// Summary: heapifies towards upwords
		// Precondition: heap is created with new keyword, exists in memory
		// Postcondition: heap heapified

	int index = size-1;
	/// check if there is parend and if parent val bigger then child swap
	while(hasParent(index) && Heap[parentIndex(index)].val > Heap[index].val) 
	{
		//sawpping nodes parent and child
		swap(parentIndex(index),index);
		// get index of parent of current node for other iteratioh of  loop
		index = parentIndex(index);
	}	
}
protected void heapifyDown() 
{
	// Summary: heapifies towards upwords
			// Precondition: heap is created with new keyword, exists in memory
			// Postcondition: heap heapified

	int index = 0;
	while(hasleftChild(index)) 
	{
		// Summary: heapifies towards downwords
		// Precondition: heap is created with new keyword, exists in memory
		// Postcondition: heap heapified

		//find smaller child left or right
		int smallerChildIndex =leftChild(index);
		if(hasrightChild(index) && this.Heap[rightChild(index)].val < this.Heap[leftChild(index)].val)	
		{	
			smallerChildIndex =rightChild(index);
		}
		// if heap index's val smaller then smaller child
		// no problem else swap 
		// update index val to smaller child and continue.
		if(Heap[index].val < Heap[smallerChildIndex].val)
			break;
		else
			swap(index,smallerChildIndex);
		index=smallerChildIndex;		
	}
}

}