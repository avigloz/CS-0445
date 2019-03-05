public class BSTester<T>
{
	public static void main( String[] args ) throws Exception
	{
		BSTree<String> tree1 = new BSTree<String>( args[0] );
		System.out.format( "\ntree1 loaded from %s contains %d nodes:\n", args[0], tree1.size() ); 
		tree1.printInOrder();
		
		String[] keys = { "aaron", "alpha", "bonzo", "charlie", "doofy", "echo", 
						  "foobar", "horsey", "yahoo", "zylog"  };
		
		System.out.println(); 
		for ( String key : keys )
			if ( tree1.contains( key ) )
				System.out.format( "key:%s FOUND in tree1\n", key );
			else
				System.out.format( "key:%s NOT found in tree1\n", key );

		System.out.println(); 
		for ( String key : keys )
			if ( tree1.add( key ) )
				System.out.format( "key:%s ADDED to tree1\n", key );
			else
				System.out.format( "key:%s REJECTED by tree1\n", key );

		System.out.println(); 
		System.out.format( "tree1 after several add attempts contains %d nodes:\n", tree1.size() ); 
		tree1.printInOrder();
	}
}