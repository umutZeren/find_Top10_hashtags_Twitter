package hash;

public class Liner_Prob <Key, Value>
	{
	protected int probing =0;
	protected double N; // number of key-value pairs in the table
	protected int M =400; // size of linear-probing table
	protected Key[] keys; // the keys
	protected Value[] vals; // the values
	public Liner_Prob(int cap)
	{
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Node[cap];
		this.M=cap;
	}
	private int hash(Key key, int arg)
	{ 
		int result = 0;
		switch (arg) 
		 {
		 case 0:
			result=(key.hashCode() & 0x7fffffff) %this.M;
			 break;
		 case 1:
			result= (int) PJWHash(key);
			 break;
		 case 2:
			 result= (int) SDBMHash((String)key);
			 break; 
		 }
		return result; 
	}
	private void resize(int cap ,int arg)
	{
		Liner_Prob<Key, Value> t;
		t = new  Liner_Prob <Key, Value>(cap);
		for (int i = 0; i < M; i++)
		if (keys[i] != null)
		t.put(keys[i], vals[i],arg);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	public void put(Key key, Value val, int arg)
	{
	if (N >= M/2) resize(2*M,arg); // double M (see text)
	int i;
	for (i = hash(key,arg); keys[i] != null; i = (i + 1) % M)
	{
		if (keys[i].equals(key)) 
		{
			vals[i] = val; 
			return; 
		}
		this.probing++;
	}
	keys[i] = key;
	vals[i] = val;
	N++;
	}
	public Value get(Key key,int arg)
	{
		for (int i = hash(key,arg); keys[i] != null; i = (i + 1) % M)
		if (keys[i].equals(key))
		return vals[i];
		return null;
	}
	 
	 
	 
	  private long PJWHash (Key key)
 {
    long BitsInUnsignedInt = (long)(4 * 8);
    long ThreeQuarters     = (long)((BitsInUnsignedInt  * 3) / 4);
    long OneEighth         = (long)(BitsInUnsignedInt / 8);
    long HighBits          = (long)(0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
    long hash              = 0;
    long test              = 0;

    for(int i = 0; i < ((String) key).length(); i++)
    {
       hash = (hash << OneEighth) +((String)key).charAt(i);

       if((test = hash & HighBits)  != 0)
       {
          hash = (( hash ^ (test >> ThreeQuarters)) & (~HighBits));
       }
    }
	return hash%M;
 }
 
 public long SDBMHash(String str)
 {
    long hash = 0;
    int i    = 0;

    for (i = 0; i < str.length(); i++)
    {
       hash = (str.charAt(i)) + (hash << 6) + (hash << 16) - hash;
    }

    return Math.abs(hash%M);
 }
 
	
}
