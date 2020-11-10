package hash;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tester_Part2 {
public static void main(String []args) throws IOException 
{
	for(int e=0;e<3;e++)
	{
			minHeap mh = new minHeap();
		Liner_Prob<String, Node> ha = new Liner_Prob<String,Node>(50);
	//create filereader to read from doc
		FileReader fr = null;
		fr = new FileReader(new File(System.getProperty("user.dir")+"\\src\\"+"twitter.txt"));
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
					Node<String> check =  ha.get(token.substring(0),e);
			/// get returns null if aint in hashtable
				if(check == null) 
					{	
					//put in hashtable
					//since there is no linked list next is null
						ha.put(token.substring(0),new Node(token,1,null),e);	
					}
					else 
					{
						//if already in table  count
						ha.get(token.substring(0),e).val +=1;		
					
					}
		
				}
			}
	//loop all hashtable
			int index=0;		
			for(;index<ha.M;index++)
				{
					Node n=null;
					if((Node)(ha.vals[index]) !=null)
						n=ha.vals[index];
							// check if any node is worthy of going in heap
						if(n == null)
							continue;
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
				}
	
			System.out.println("results");
			//create aux array to reverse poll
			///since its min heap its will return increasing if just poll
	
			Node [] res =  new Node [10];
			//polls first is min putted in last place in aux array
			for(int z=0;z<10;z++) {
				res[9-z] = mh.poll();
			}
			// print results in decrease from aux array
			//inform about probes
			System.out.println("avg probe "+ha.probing/ha.N);
			System.out.println("total key value pairs "+ha.N);
		}
	}
	
}