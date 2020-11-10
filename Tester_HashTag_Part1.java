package hash;
import java.util.*; 


import java.util.Scanner;
import java.awt.RenderingHints.Key;
import java.io.*; 
// all classes already compiled
// command java "Tester_Hash" twitter.txt should be use to work this code 
public class Tester_HashTag_Part1 
{
	//this class represent Tester for hash table and heap
	
	// key:#token_string -> value:how many times it has been seen in document
	
	public static void main(String []args) throws IOException 		
	{ 
		
		
		{
		// Summary: returns  top 10 hashtags
		// Precondition: twitter.textis given as command line args0.
		//and in same direction with src folder.
		// Postcondition: returned top 10 tags. used minHeap and hashtable
		
		//create instance of minHeap, seperateChainingHashSt
	
		minHeap mh = new minHeap();
		SeparateChainingHashST<String> ha = new SeparateChainingHashST<String>();
	//create filereader to read from doc
		FileReader fr = null;
		fr = new FileReader(new File(System.getProperty("user.dir")+"\\src\\"+"twitter.txt"));
		//fr=new FileReader(new File(System.getProperty("user.dir")+"\\src\\twitter.txt")); 
	
		// for reading  by char one by one
		 int i; 
			while((i=fr.read()) != -1) 
			{
				//if hashtag start found
				if( (char)i == '#')
				{
					//create empty token
					String token ="";
					
					//read until see " " or endline 
					for(;(i=fr.read())!= ' ' && i!=-1 && (char)i!='\n' && (char)(i)!='\r' ; )
					{
						token+= (char)(i);
					}
						//all have # at first char so their key 
					// if reade empty token  forget this loop and go loop again for another token
					if(token == "" || token ==" ")
						continue;
					token=token.toLowerCase();
					// aram burda yapýlýyor dikkat
					Node<String> check =  ha.get(token.substring(0));
			/// get returns null if aint in hashtable
				if(check == null) 
					{	
					//put in hashtable
						ha.put(token.substring(0),1);	
					}
					else 
					{
						//if already in table  count
						ha.get(token.substring(0)).val +=1;		
					
					}
		
				}
			}
	//loop all hashtable
			int index=0;		
			for(;index<997;index++)
				{
					Node n=ha.st[index].first;
					if(n ==null)
						continue;
					// if n not null go for next node  till its null
					while(n!=null)
					{
							// check if any node is worthy of going in heap
							if(mh.size==0 || mh.Heap[0].val<n.val )
							{
								//if size 10 first poll then add
								if(mh.size ==10)
								{
									Node ne = mh.poll();
			
								}
								// add to heap since node's val is good enough				
								mh.add(n);
							}
							//check another node 
						n=n.next;
					}
				}
	
			System.out.println("results");
			//create aux array to reverse poll
			///since its min heap its will return increasing if just poll

			Node [] res =  new Node [10];
			//polls first is min putted in last place in aux array
			for(int e=0;e<10;e++) {
				res[9-e] = mh.poll();
			}
			// print results in decrease from aux array
			for(Node n: res)
				System.out.println(n.key +" : " +n.val);
				
			//inform about probes
			
			System.out.println(ha.hashSize);
		}
	
	}
	
}

